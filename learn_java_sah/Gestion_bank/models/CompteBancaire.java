package models;

import java.util.*;

public class CompteBancaire {
    private int numeroCompte;
    private String nomTitulaire;
    private String motDePasse;
    private double solde;
    private List<Transaction> transactions = new ArrayList<>();

    public CompteBancaire(int numero, String nom, String motDePasse) {
        this.numeroCompte = numero;
        this.nomTitulaire = nom;
        this.motDePasse = motDePasse;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }
    public String getNomTitulaire() {
        return nomTitulaire; 
    }
    public double getSolde() { 
        return solde; 
    }

    public void setSolde(double solde) {
     this.solde = solde; 
    }
    public List<Transaction> getTransactions() { 
    return transactions; 
    }

    public boolean verifierMotDePasse(String motDePasse) {
        return this.motDePasse.equals(motDePasse);
    }
}