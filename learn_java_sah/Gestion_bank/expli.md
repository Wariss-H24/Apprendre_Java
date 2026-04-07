## Projet : Gestion bancaire (mini)

Ce fichier contient une explication complète du code, la logique d'exécution, les cas limites et des suggestions d'amélioration. Tu peux le copier-coller ou le partager tel quel.

## 1. Vue d'ensemble rapide

Ce petit projet gère des comptes bancaires en mémoire. Fonctionnalités :
- créer un compte (numéro + titulaire)
- déposer ou retirer de l'argent
- consulter le solde
- lister les transactions

Stockage : une liste en mémoire des objets `CompteBancaire` (pas de persistance).

## 2. Contrat (inputs / outputs / erreurs)

- Entrées : saisies utilisateur depuis la console (choix du menu, numéro de compte, montant, nom).
- Sorties : affichages console (menus, messages d'état, solde, transactions).
- Erreurs gérées : solde insuffisant (message imprimé). La recherche de compte retourne `null` si introuvable (le code vérifie `compte != null`).
- Modes d'échec non traités : saisie invalide (ex. lettres au lieu d'un nombre), montants négatifs, duplicata de numéro de compte, concurrence.

## 3. Fichiers et explications détaillées

### `models/CompteBancaire.java`

But : représenter un compte bancaire.

Contenu :
- Champs : `numeroCompte` (int), `nomTitulaire` (String), `solde` (double), `transactions` (List<Transaction>).
- Constructeur : `CompteBancaire(int numero, String nom)` initialise `numeroCompte` et `nomTitulaire` (solde par défaut 0.0).
- Getters / Setter : `getNumeroCompte()`, `getNomTitulaire()`, `getSolde()`, `setSolde(double)`, `getTransactions()`.

Points clés :
- Les transactions sont stockées dans une `ArrayList` créée lors de l'instanciation.
- Pas de validation dans `setSolde`.

### `models/TransactionType.java`

But : enum des types d'opérations.

Contenu : `DEPOT`, `RETRAIT`.

### `models/Transaction.java`

But : représenter une opération (type, montant, date/heure).

Contenu :
- Champs : `TransactionType type`, `double montant`, `LocalDateTime date`.
- Constructeur : enregistre le type, le montant et la date courante (`LocalDateTime.now()`).
- `toString()` renvoie une chaîne lisible : ex. `DEPOT - 500.0 FCFA - 2026-04-07T13:00:54.741349500`.

### `services/BanqueService.java`

But : gérer la collection (liste) de comptes.

Contenu :
- Champ : `List<CompteBancaire> comptes = new ArrayList<>()`.
- `creerCompte(int numero, String nom)` : ajoute un nouveau compte et affiche "Compte créé pour X" (pas de vérif d'unicité).
- `chercherCompte(int numero)` : recherche et retourne le compte correspondant ou `null`.

Points : responsabilité limitée (création + recherche), tout en mémoire.

### `services/CompteService.java`

But : effectuer les opérations métier sur un compte (dépôt/retrait + enregistrement transaction).

Contenu :
- `deposer(CompteBancaire compte, double montant)` : augmente le solde et ajoute une `Transaction` de type `DEPOT`.
- `retirer(CompteBancaire compte, double montant)` : si `montant <= solde`, décrémente le solde et ajoute `Transaction` de type `RETRAIT`, sinon affiche "Solde insuffisant".

Points :
- Pas de validation pour montants négatifs (risque : dépôt négatif diminue le solde).

### `Main.java`

But : interface console (menu) pour utiliser les services.

Logique :
1. Instancie `Scanner`, `BanqueService`, `CompteService`.
2. Boucle do/while affichant le menu et lisant le choix.
3. Demande toujours un `Numéro compte` après le choix (mauvaise UX pour Quitter).
4. Selon l'option : création, dépôt, retrait, affichage solde, affichage transactions.

Points :
- Le code vérifie `if (compte != null)` pour les opérations, mais n'affiche pas de message si le compte est introuvable.
- Mélange `nextInt()` et `nextLine()` de `Scanner` : le code tente de consommer la ligne avant la saisie du `nom`.

## 4. Logique d'exécution complète (pas à pas)

1. Démarrage -> affichage menu.
2. L'utilisateur choisit une option.
3. Le programme demande un numéro de compte (toujours).
4. Selon le choix :
   - 1 : créer compte (saisir nom)
   - 2/3 : si compte existe, saisir montant et déposer/retrier; sinon rien (à améliorer)
   - 4 : afficher solde si compte existe
   - 5 : afficher transactions si compte existe
   - 6 : quitter (mais le programme demande un numéro avant de quitter)

Exemple : créer 123 (Alice), déposer 500, afficher solde -> 500.0, lister transaction -> DEPOT - 500.0 ...

## 5. Cas limites / edge cases

- Entrées non numériques -> `InputMismatchException` et plantage.
- Montants négatifs -> acceptés, comportement incohérent possible.
- Numéros de compte dupliqués -> possible (pas de vérification d'unicité).
- Concurrence -> non gérée.
- Persistance -> non présente (les données sont perdues au redémarrage).

## 6. Suggestions d'améliorations (priorisées)

1. Ne demander le numéro de compte que pour les options qui en ont besoin (ne pas le demander pour Quitter).
2. Afficher "Compte introuvable" lorsque `chercherCompte` retourne `null`.
3. Valider les montants (ex: `montant > 0`).
4. Vérifier l'unicité du numéro avant création.
5. Gérer les exceptions de saisie (`Scanner`) pour éviter les plantages.
6. Ajouter des tests unitaires (JUnit) pour les services.
7. Optionnel : persistance (fichier JSON / BDD embarquée).

## 7. Pitch condensé (prêt à présenter)

Ce petit programme Java simule la gestion basique de comptes bancaires en mémoire. Les modèles `CompteBancaire` et `Transaction` représentent les données. `BanqueService` gère la création/recherche de comptes et `CompteService` applique les opérations (dépôt/retrait) en enregistrant les transactions. `Main` fournit une interface console. Il n'y a pas de persistance : tout reste en mémoire pendant l'exécution.

## 8. Notes pour la présentation technique

- Structure : packages `models` (entités) et `services` (logique métier).
- Principe : séparation des responsabilités (services != I/O).
- Idéal pour présenter les concepts DAO/service/CLI à des débutants.
- Points à améliorer : validation, messages utilisateur, tests, persistance.

## 9. Exemple de diapositive (bullets)

- Objectif : simuler opérations bancaires basiques.
- Modèles : Compte, Transaction.
- Services : création/recherche de compte, dépôt/retrait.
- Interface : menu console (Main.java).
- Limitations : pas de persistance, pas de validation robuste.
- Améliorations : validations, gestion d'erreurs, tests, sauvegarde.

## 10. Prochaines actions possibles

- Modifier `Main.java` pour améliorer l'UX (ne pas demander le numéro pour Quitter, afficher message compte introuvable).
- Ajouter validation d'entrée et contrôles pour montants.
- Écrire des tests unitaires JUnit pour `CompteService` et `BanqueService`.

---

Fait : j'ai exporté l'explication complète dans ce fichier `expli.md`.

Souhaites-tu que j'applique maintenant l'une des améliorations listées (par exemple : afficher "Compte introuvable" et ne pas demander le numéro pour Quitter) ?
