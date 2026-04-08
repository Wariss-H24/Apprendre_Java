# 🔐 Système d'Authentification Bancaire - Documentation Complète

## 📋 Table des matières
1. [Vue d'ensemble](#vue-densemble)
2. [Architecture](#architecture)
3. [Code source](#code-source)
4. [Fonctionnalités](#fonctionnalités)
5. [Guide d'utilisation](#guide-dutilisation)

---

## Vue d'ensemble

Ce projet implémente un **système de gestion bancaire avec authentification obligatoire**. Chaque utilisateur doit créer un compte et se connecter avant d'effectuer toute transaction.

### Caractéristiques principales :
✅ Authentification par mot de passe  
✅ Vérification de l'unicité des comptes  
✅ Gestion des dépôts et retraits  
✅ Historique des transactions  
✅ Validation des montants  
✅ Messages d'erreur clairs  

---

## Architecture

```
Gestion_bank/
├── models/
│   ├── CompteBancaire.java      # Entité compte avec authentification
│   ├── Transaction.java          # Entité transaction
│   └── TransactionType.java       # Enum (DEPOT, RETRAIT)
├── services/
│   ├── BanqueService.java        # Gestion des comptes + authentification
│   └── CompteService.java        # Opérations bancaires
└── Main.java                      # Interface console
```

### Flux d'authentification :
```
Accueil
  ├── Créer un compte (numéro, nom, mot de passe)
  └── Se connecter (vérif. numéro + mot de passe)
      └── Menu sécurisé (dépôt, retrait, solde, historique)
```

---

## Code source

### 1. `models/CompteBancaire.java`

```java
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
```

**Description :**
- Représente un compte bancaire avec identifiants et mot de passe
- Stocke le solde et l'historique des transactions
- Méthode `verifierMotDePasse()` : valide le mot de passe

---

### 2. `models/TransactionType.java`

```java
package models;

public enum TransactionType {
    DEPOT,
    RETRAIT
}
```

**Description :**
- Enum pour typer les transactions
- Valeurs : `DEPOT` ou `RETRAIT`

---

### 3. `models/Transaction.java`

```java
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
```

**Description :**
- Enregistre chaque opération (type, montant, date/heure)
- `toString()` affiche un format lisible

---

### 4. `services/BanqueService.java`

```java
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
```

**Méthodes :**
- `creerCompte()` : crée un compte avec vérification d'unicité
- `chercherCompte()` : recherche un compte par numéro
- `authentifier()` : **valide les identifiants** et retourne le compte ou `null`

---

### 5. `services/CompteService.java`

```java
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
```

**Méthodes :**
- `deposer()` : effectue un dépôt avec validation du montant
- `retirer()` : effectue un retrait avec vérification du solde

---

### 6. `Main.java`

```java
import services.*;
import models.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BanqueService banqueService = new BanqueService();
        CompteService compteService = new CompteService();

        int choixPrincipal;
        CompteBancaire compteConnecte = null;

        do {
            System.out.println("\n" + "=".repeat(40));
            System.out.println(" SYSTÈME DE GESTION BANCAIRE ");
            System.out.println("=".repeat(40));
            System.out.println("1. Créer un compte");
            System.out.println("2. Se connecter");
            System.out.println("3. Quitter");
            System.out.print(">> Votre choix : ");
            choixPrincipal = sc.nextInt();
            sc.nextLine(); // Consommer la nouvelle ligne

            switch (choixPrincipal) {

                case 1: // Créer un compte
                    System.out.print("Numéro de compte : ");
                    int numero = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nom du titulaire : ");
                    String nom = sc.nextLine();
                    System.out.print("Mot de passe : ");
                    String motDePasse = sc.nextLine();
                    banqueService.creerCompte(numero, nom, motDePasse);
                    break;

                case 2: // Se connecter
                    System.out.print("Numéro de compte : ");
                    int numConnexion = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mot de passe : ");
                    String mdp = sc.nextLine();
                    
                    compteConnecte = banqueService.authentifier(numConnexion, mdp);
                    
                    if (compteConnecte != null) {
                        // Menu des opérations après authentification
                        menuOperations(sc, compteConnecte, compteService);
                    }
                    break;

                case 3: // Quitter
                    System.out.println(" Au revoir !");
                    break;

                default:
                    System.out.println(" Choix invalide !");
            }

        } while (choixPrincipal != 3);

        sc.close();
    }

    // Menu des opérations bancaires (après authentification)
    public static void menuOperations(Scanner sc, CompteBancaire compte, CompteService compteService) {
        int choix;

        do {
            System.out.println("\n" + "-".repeat(40));
            System.out.println(" Connecté : " + compte.getNomTitulaire());
            System.out.println("-".repeat(40));
            System.out.println("1. Dépôt");
            System.out.println("2. Retrait");
            System.out.println("3. Voir le solde");
            System.out.println("4. Voir les transactions");
            System.out.println("5. Se déconnecter");
            System.out.print(">> Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1: // Dépôt
                    System.out.print("Montant à déposer : ");
                    double montantDepot = sc.nextDouble();
                    sc.nextLine();
                    compteService.deposer(compte, montantDepot);
                    break;

                case 2: // Retrait
                    System.out.print("Montant à retirer : ");
                    double montantRetrait = sc.nextDouble();
                    sc.nextLine();
                    compteService.retirer(compte, montantRetrait);
                    break;

                case 3: // Solde
                    System.out.println("💰 Solde : " + compte.getSolde() + " FCFA");
                    break;

                case 4: // Transactions
                    if (compte.getTransactions().isEmpty()) {
                        System.out.println(" Aucune transaction pour ce compte.");
                    } else {
                        System.out.println(" HISTORIQUE DES TRANSACTIONS :");
                        compte.getTransactions().forEach(t -> System.out.println("   " + t));
                    }
                    break;

                case 5: // Déconnexion
                    System.out.println(" Déconnecté avec succès !");
                    break;

                default:
                    System.out.println(" Choix invalide !");
            }

        } while (choix != 5);
    }
}
```

**Structure :**
- `main()` : écran d'authentification initial
- `menuOperations()` : menu protégé après connexion réussie

---

## Fonctionnalités

### ✅ Création de compte
- Numéro unique (vérification d'unicité)
- Nom du titulaire
- Mot de passe

### ✅ Authentification
- Vérification du compte existant
- Vérification du mot de passe
- Accès au menu protégé si succès
- Blocage si identifiants incorrects

### ✅ Opérations bancaires (après authentification)
- **Dépôt** : ajouter de l'argent avec validation (montant > 0)
- **Retrait** : retirer de l'argent avec vérification du solde
- **Solde** : consulter le solde actuel
- **Historique** : lister toutes les transactions

### ✅ Sécurité
- Pas d'accès aux transactions sans authentification
- Validation des montants (positifs obligatoires)
- Messages d'erreur clairs
- Déconnexion avec retour au menu principal

---

## Guide d'utilisation

### Compilation
```bash
javac -d . models/*.java services/*.java Main.java
```

### Exécution
```bash
java Main
```

### Scénario d'utilisation

**1. Créer un compte**
```
>> Votre choix : 1
Numéro de compte : 100
Nom du titulaire : Alice
Mot de passe : secret123
✅ Compte créé avec succès pour Alice
```

**2. Se connecter**
```
>> Votre choix : 2
Numéro de compte : 100
Mot de passe : secret123
✅ Bienvenue Alice ! vous êtes maintenant connecté.
```

**3. Effectuer des transactions**
```
>> Votre choix : 1
Montant à déposer : 500
✅ Dépôt de 500.0 FCFA effectué. Nouveau solde : 500.0 FCFA
```

**4. Voir l'historique**
```
>> Votre choix : 4
HISTORIQUE DES TRANSACTIONS :
   DEPOT - 500.0 FCFA - 2026-04-08T13:45:12.123456789
```

**5. Se déconnecter**
```
>> Votre choix : 5
✅ Déconnecté avec succès !
```

### Cas d'erreur

**Mauvais mot de passe :**
```
>> Votre choix : 2
Numéro de compte : 100
Mot de passe : incorrect
❌ Mot de passe incorrect !
```

**Compte inexistant :**
```
>> Votre choix : 2
Numéro de compte : 999
Mot de passe : quelconque
❌ Compte non trouvé !
```

**Montant négatif :**
```
>> Votre choix : 1
Montant à déposer : -100
❌ Erreur : Le montant doit être positif !
```

**Solde insuffisant :**
```
>> Votre choix : 2
Montant à retirer : 1000
❌ Solde insuffisant ! Solde actuel : 500.0 FCFA
```

---

## 🔒 Points de sécurité

| Point | Implémentation |
|------|-----------------|
| Authentification | Vérification du numéro + mot de passe |
| Unicité | Impossible créer 2 comptes avec même numéro |
| Montants | Validation (positifs obligatoires) |
| Solde | Vérification avant retrait |
| Accès | Aucune opération sans authentification |

---

## 📝 Notes

- Les données sont stockées **en mémoire** (disparaissent à la fermeture)
- Les mots de passe sont **comparés en texte clair** (en production, utiliser un hash)
- Pas de persistence en base de données
- Interface console seulement

---

**Fin de la documentation - Système d'authentification bancaire ✅**
