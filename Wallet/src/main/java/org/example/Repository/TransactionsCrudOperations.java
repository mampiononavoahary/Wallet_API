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
                     resultSet.getInt("transaction_id"),
                        resultSet.getInt("id_compte"),
                        resultSet.getFloat("montant"),
                        resultSet.getString("type_transaction"),
                        resultSet.getTimestamp("date_transaction")
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
    public Transactions save(Transactions toSave) {

    }

    @Override
    public Transactions delete(Transactions toDelete) {
        return null;
    }

    @Override
    public List saveAll(List toSave) {
        return null;
    }

}
