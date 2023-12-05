package org.example.Tests;

import org.example.Model.Comptes;
import org.example.Repository.ComptesCrudOperations;

import java.sql.SQLException;

public class ComptesTest {
    public static void ComptesTest() throws SQLException, ClassNotFoundException {
        ComptesCrudOperations comptesCrudOperations = new ComptesCrudOperations();
        Comptes comptes = new Comptes(1,1,"gfg",2000_00f,"ghgh", "2023-12-01","jgh");
        comptesCrudOperations.save(comptes);
        comptesCrudOperations.findAll();

        comptesCrudOperations.delete(comptes);
    }
}
