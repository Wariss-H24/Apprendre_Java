package services;

import java.util.*;
import models.CompteBancaire;

public class BanqueService {

    private List<CompteBancaire> comptes = new ArrayList<>();

    public void creerCompte(int numero, String nom) {
        comptes.add(new CompteBancaire(numero, nom));
        System.out.println("Compte créé pour " + nom);
    }

    public CompteBancaire chercherCompte(int numero) {
        for (CompteBancaire c : comptes) {
            if (c.getNumeroCompte() == numero) {
                return c;
            }
        }
        return null;
    }
}