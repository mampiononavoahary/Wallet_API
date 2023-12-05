package org.example.Repository;

import org.example.Database.ConnectDatabase;
import org.example.Model.Transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionsCrudOperations implements CrudOperation<Transactions>{

    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection connection = connectDatabase.CreateConnection();

    public TransactionsCrudOperations() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Transactions> findAll() {
        List<Transactions> array = new ArrayList<>();
        String sql = "SELECT * FROM Comptes;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                array.add(new Transactions(
                     resultSet.getInt("id_transaction"),
                        resultSet.getInt("id_devise"),
                        resultSet.getInt("id_compte"),
                        resultSet.getFloat("montant"),
                        resultSet.getString("type_transaction"),
                        resultSet.getString("date_transaction")
                ));
            }
            for (Transactions transactions : array){
                System.out.println(transactions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    @Override
    public List<Transactions> saveAll(List<Transactions> toSave) {
        String sql = "INSERT INTO Transactions(id_transaction,id_devise, id_compte, montant, type_transaction, date_transaction) VALUES (?,?, ?, ?, ?, ?, ?);";
        List<Transactions> array = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Transactions transaction : toSave) {
                statement.setInt(1, transaction.getId_transaction());
                statement.setInt(2,transaction.getId_devise());
                statement.setInt(3, transaction.getId_compte());
                statement.setFloat(4, transaction.getMontant());
                statement.setString(5, transaction.getType_transaction());
                statement.setDate(6, transaction.getDate_transaction());

                int rows = statement.executeUpdate();
                if (rows > 0) {
                    System.out.println("Transaction inserted");
                    array.add(transaction);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return array;
    }


    @Override
    public Transactions save(Transactions toSave) {
        String sql = "INSERT INTO Transactions(id_transaction,id_devise, id_compte, montant, type_transaction, date_transaction, description) VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, toSave.getId_transaction());
            statement.setInt(2,toSave.getId_devise());
            statement.setInt(3, toSave.getId_compte());
            statement.setFloat(4, toSave.getMontant());
            statement.setString(5, toSave.getType_transaction());
            statement.setDate(6, toSave.getDate_transaction());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Transaction insérée avec succès");

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        toSave.setId_transaction(generatedKeys.getInt(1));
                    }
                }
                return toSave;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    @Override
    public Transactions delete(Transactions toDelete) {
        String sql = "DELETE FROM Transactions WHERE id_transaction = ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, toDelete.getId_transaction());
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Transaction supprimée avec succès");
                return toDelete;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
