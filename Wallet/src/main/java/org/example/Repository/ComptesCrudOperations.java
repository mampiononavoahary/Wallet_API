package org.example.Repository;

import org.example.Database.ConnectDatabase;
import org.example.Model.Comptes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComptesCrudOperations implements CrudOperation<Comptes>{
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection connection = connectDatabase.CreateConnection();

    public ComptesCrudOperations() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Comptes> findAll() {
        List<Comptes> array = new ArrayList<>();
        String sql = "SELECT * FROM Comptes;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                array.add(new Comptes(
                    resultSet.getInt("id_compte"),
                        resultSet.getInt("id_devise"),
                        resultSet.getString("nom_compte"),
                        resultSet.getFloat("solde"),
                        resultSet.getString("type_compte"),
                        resultSet.getTimestamp("date_ouverture"),
                        resultSet.getString("proprietire")
                ));
            }
            for (Comptes comptes : array){
                System.out.println(comptes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    @Override
    public List<Comptes>saveAll(List<Comptes> toSave) {
        String sql = "INSERT INTO Comptes(id_compte,id_devise,nom_compte,solde,type_compte,date_ouverture,proprietaire)VALUES(?,?,?,?,?,?,?);";
        List<Comptes> array = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            for (Comptes comptes : array){
                statement.setInt(1,comptes.getId_compte());
                statement.setInt(2,comptes.getId_devise());
                statement.setString(3,comptes.getNom_compte());
                statement.setFloat(4,comptes.getSolde());
                statement.setString(5,comptes.getType_compte());
                statement.setTimestamp(6,comptes.getDate_ouverture());
                statement.setString(7, comptes.getProprietaire());
                int rows = statement.executeUpdate();
                if (rows>0){
                    System.out.println("Comptes inserted");
                    array.add(comptes);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    @Override
    public Comptes save(Comptes toSave) {
        try {
            String query = "INSERT INTO Comptes(id_compte,nom_compte,solde,type_compte,date_ouverture,proprietaire)VALUES(?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,toSave.getId_compte());
                preparedStatement.setString(2,toSave.getNom_compte());
                preparedStatement.setFloat(3,toSave.getSolde());
                preparedStatement.setString(4,toSave.getType_compte());
                preparedStatement.setTimestamp(5,toSave.getDate_ouverture());
                preparedStatement.setString(6,toSave.getProprietaire());

                preparedStatement.executeUpdate();
                System.out.println("Comptes inserted");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Comptes delete(Comptes toDelete) {
        String sql = "DELETE FROM Comptes WHERE id_compte=?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,toDelete.getId_compte());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
