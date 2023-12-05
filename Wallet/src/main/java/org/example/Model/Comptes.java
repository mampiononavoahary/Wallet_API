package org.example.Model;

import java.util.Date;
import java.util.Objects;

public class Comptes {
    private   int id_compte;
    private int id_devise;
    private String nom_compte;
    private Float solde;
    private String type_compte;
    private java.sql.Date date_ouverture ;
    private String proprietaire;

    public Comptes(int id_compte, int id_devise, String nom_compte, Float solde, String type_compte, String date_ouverture, String proprietaire) {
        this.id_compte = id_compte;
        this.id_devise=id_devise;
        this.nom_compte = nom_compte;
        this.solde = solde;
        this.type_compte = type_compte;
        this.date_ouverture = java.sql.Date.valueOf(date_ouverture);
        this.proprietaire = proprietaire;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public String getNom_compte() {
        return nom_compte;
    }

    public void setNom_compte(String nom_compte) {
        this.nom_compte = nom_compte;
    }

    public Float getSolde() {
        return solde;
    }

    public int getId_devise() {
        return id_devise;
    }

    public void setId_devise(int id_devise) {
        this.id_devise = id_devise;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public String getType_compte() {
        return type_compte;
    }

    public void setType_compte(String type_compte) {
        this.type_compte = type_compte;
    }

    public java.sql.Date getDate_ouverture() {
        return date_ouverture;
    }

    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = (java.sql.Date) date_ouverture;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comptes comptes = (Comptes) o;
        return id_compte == comptes.id_compte && Objects.equals(nom_compte, comptes.nom_compte) && Objects.equals(solde, comptes.solde) && Objects.equals(type_compte, comptes.type_compte) && Objects.equals(date_ouverture, comptes.date_ouverture) && Objects.equals(proprietaire, comptes.proprietaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_compte, nom_compte, solde, type_compte, date_ouverture, proprietaire);
    }

    @Override
    public String toString() {
        return "Comptes{" +
                "id_compte=" + id_compte +
                ", id_devise ="+ id_devise+
                ", nom_compte='" + nom_compte + '\'' +
                ", solde=" + solde +
                ", type_compte='" + type_compte + '\'' +
                ", date_ouverture=" + date_ouverture +
                ", proprietaire='" + proprietaire + '\'' +
                '}';
    }
}
