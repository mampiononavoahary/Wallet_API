package org.example.Model;

import java.sql.Timestamp;
import java.util.Objects;

public class Transactions {
    private  int id_transaction ;
    private int id_compte ;
    private float montant ;
    private String type_transaction;
    private Timestamp date_transaction;

    public Transactions(int id_transaction, int id_compte, float montant, String type_transaction, Timestamp date_transaction) {
        this.id_transaction = id_transaction;
        this.id_compte = id_compte;
        this.montant = montant;
        this.type_transaction = type_transaction;
        this.date_transaction = date_transaction;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getType_transaction() {
        return type_transaction;
    }

    public void setType_transaction(String type_transaction) {
        this.type_transaction = type_transaction;
    }

    public Timestamp getDate_transaction() {
        return date_transaction;
    }

    public void setDate_transaction(Timestamp date_transaction) {
        this.date_transaction = date_transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return id_transaction == that.id_transaction && id_compte == that.id_compte && Float.compare(montant, that.montant) == 0 && Objects.equals(type_transaction, that.type_transaction) && Objects.equals(date_transaction, that.date_transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_transaction, id_compte, montant, type_transaction, date_transaction);
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id_transaction=" + id_transaction +
                ", id_compte=" + id_compte +
                ", montant=" + montant +
                ", type_transaction='" + type_transaction + '\'' +
                ", date_transaction=" + date_transaction +
                '}';
    }
}
