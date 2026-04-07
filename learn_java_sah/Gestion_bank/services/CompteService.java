package services;

import models.CompteBancaire;
import models.Transaction;
import models.TransactionType;

public class CompteService {

    public void deposer(CompteBancaire compte, double montant) {
        compte.setSolde(compte.getSolde() + montant);
        compte.getTransactions().add(new Transaction(TransactionType.DEPOT, montant));
    }

    public void retirer(CompteBancaire compte, double montant) {
        if (montant <= compte.getSolde()) {
            compte.setSolde(compte.getSolde() - montant);
            compte.getTransactions().add(new Transaction(TransactionType.RETRAIT, montant));
        } else {
            System.out.println(" Solde insuffisant");
        }
    }
}