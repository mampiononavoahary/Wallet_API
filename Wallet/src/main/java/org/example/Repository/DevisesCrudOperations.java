package org.example.Repository;

import org.example.Database.ConnectDatabase;
import org.example.Model.Comptes;
import org.example.Model.Devise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevisesCrudOperations implements CrudOperation<Devise>{
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection connection = connectDatabase.CreateConnection();

    public DevisesCrudOperations() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Devise> findAll() {
        List<Devise> array = new ArrayList<>();
        String sql = "SELECT * FROM Devises;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_devise");
                String nom = resultSet.getString("nom_devise");
                String symboles = resultSet.getString("symbole_devise");

                try {
                    Devise.TopicA topicA = Devise.TopicA.valueOf(nom);
                    Devise.TopicB topicB = Devise.TopicB.valueOf(symboles);

                    Devise devise = new Devise(id, topicA, topicB);
                    array.add(devise);
                } catch (IllegalArgumentException e) {
                    // Handle the case where the database value doesn't match any enum constant
                    // You can log a warning, set a default value, or throw an exception
                    System.err.println("Invalid enum constant for symbole_devise: " + symboles);
                }
            }
            for (Devise devise : array) {
                System.out.println(devise);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }


    @Override

    public List<Devise> saveAll(List<Devise> toSave) {
        return null;
    }

    @Override
    public Devise save(Devise toSave) {
        return null;
    }

    @Override
    public Devise delete(Devise toDelete) {
        return null;
    }
}
