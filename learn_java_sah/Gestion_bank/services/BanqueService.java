package services;

import java.util.*;
import models.CompteBancaire;

public class BanqueService {

    private List<CompteBancaire> comptes = new ArrayList<>();

    public boolean creerCompte(int numero, String nom, String motDePasse) {
        // Vérifier si le compte existe déjà
        if (chercherCompte(numero) != null) {
            System.out.println(" Erreur : Un compte avec le numéro " + numero + " existe déjà.");
            return false;
        }
        comptes.add(new CompteBancaire(numero, nom, motDePasse));
        System.out.println(" Compte créé avec succès pour " + nom);
        return true;
    }

    public CompteBancaire chercherCompte(int numero) {
        for (CompteBancaire c : comptes) {
            if (c.getNumeroCompte() == numero) {
                return c;
            }
        }
        return null;
    }

    public CompteBancaire authentifier(int numero, String motDePasse) {
        CompteBancaire compte = chercherCompte(numero);
        if (compte == null) {
            System.out.println("Compte non trouvé !");
            return null;
        }
        if (!compte.verifierMotDePasse(motDePasse)) {
            System.out.println(" Mot de passe incorrect !");
            return null;
        }
        System.out.println("Bienvenue " + compte.getNomTitulaire()  + " !" + "vous êtes maintenant connecté.");
        return compte;
    }
}