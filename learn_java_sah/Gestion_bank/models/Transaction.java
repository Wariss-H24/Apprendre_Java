package models;

import java.time.LocalDateTime;

public class Transaction {
    private TransactionType type;
    private double montant;
    private LocalDateTime date;

    public Transaction(TransactionType type, double montant) {
        this.type = type;
        this.montant = montant;
        this.date = LocalDateTime.now();
    }

    public String toString() {
        return type + " - " + montant + " FCFA - " + date;
    }
}