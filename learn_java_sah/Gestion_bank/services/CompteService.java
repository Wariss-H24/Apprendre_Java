package services;

import models.CompteBancaire;
import models.Transaction;
import models.TransactionType;

public class CompteService {

    public boolean deposer(CompteBancaire compte, double montant) {
        if (montant <= 0) {
            System.out.println(" Erreur : Le montant doit être positif !");
            return false;
        }
        compte.setSolde(compte.getSolde() + montant);
        compte.getTransactions().add(new Transaction(TransactionType.DEPOT, montant));
        System.out.println(" Dépôt de " + montant + " FCFA effectué. Nouveau solde : " + compte.getSolde() + " FCFA");
        return true;
    }

    public boolean retirer(CompteBancaire compte, double montant) {
        if (montant <= 0) {
            System.out.println(" Erreur : Le montant doit être positif !");
            return false;
        }
        if (montant <= compte.getSolde()) {
            compte.setSolde(compte.getSolde() - montant);
            compte.getTransactions().add(new Transaction(TransactionType.RETRAIT, montant));
            System.out.println(" Retrait de " + montant + " FCFA effectué. Nouveau solde : " + compte.getSolde() + " FCFA");
            return true;
        } else {
            System.out.println(" Solde insuffisant ! Solde actuel : " + compte.getSolde() + " FCFA");
            return false;
        }
    }
}