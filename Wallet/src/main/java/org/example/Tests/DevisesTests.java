package org.example.Tests;

import org.example.Repository.DevisesCrudOperations;

import java.sql.SQLException;

public class DevisesTests {


    public static void DevisesTests() throws SQLException, ClassNotFoundException {
        DevisesCrudOperations devisesCrudOperations = new DevisesCrudOperations();

        devisesCrudOperations.findAll();
    }
}
