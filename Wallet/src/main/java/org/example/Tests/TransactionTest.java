package org.example.Tests;

import org.example.Model.Transactions;
import org.example.Repository.TransactionsCrudOperations;

import java.sql.SQLException;

public class TransactionTest {
    public static void TransactionTest() throws SQLException, ClassNotFoundException {
        TransactionsCrudOperations transactionsCrudOperations = new TransactionsCrudOperations();
        Transactions transactions = new Transactions(1,1,1,1000_12f,"kli","2023-12-12");
        transactionsCrudOperations.save(transactions);

        transactionsCrudOperations.findAll();
        transactionsCrudOperations.delete(transactions);
    }
}
