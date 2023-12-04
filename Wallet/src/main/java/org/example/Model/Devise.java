package org.example.Model;

import java.util.Objects;

public class Devise {
    private int id_devise ;
    private String nom_devise ;
    private Topic symbole_devise;
    public enum Topic {
        Euros,
        Dollar,
        Ariary,
        Other,
    }
    public Devise(int id_devise, String nom_devise, Topic symbole_devise) {
        this.id_devise = id_devise;
        this.nom_devise = nom_devise;
        this.symbole_devise = symbole_devise;
    }

    public int getId_devise() {
        return id_devise;
    }

    public void setId_devise(int id_devise) {
        this.id_devise = id_devise;
    }

    public String getNom_devise() {
        return nom_devise;
    }

    public void setNom_devise(String nom_devise) {
        this.nom_devise = nom_devise;
    }

    public Topic getSymbole_devise() {
        return symbole_devise;
    }

    public void setSymbole_devise(Topic symbole_devise) {
        this.symbole_devise = symbole_devise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devise devise = (Devise) o;
        return id_devise == devise.id_devise && Objects.equals(nom_devise, devise.nom_devise) && Objects.equals(symbole_devise, devise.symbole_devise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_devise, nom_devise, symbole_devise);
    }

    @Override
    public String toString() {
        return "Devise{" +
                "id_devise=" + id_devise +
                ", nom_devise='" + nom_devise + '\'' +
                ", symbole_devise='" + symbole_devise + '\'' +
                '}';
    }
}
