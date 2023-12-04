package org.example.Repository;

import org.example.Database.ConnectDatabase;
import org.example.Model.Comptes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComptesCrudOperations implements CrudOperation{
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
    public List saveAll(List toSave) {
        return null;
    }

    @Override
    public Object save(Object toSave) {
        return null;
    }

    @Override
    public Object delete(Object toDelete) {
        return null;
    }
}
