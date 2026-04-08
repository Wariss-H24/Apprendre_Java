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
            System.out.println("BIENVENU CHEZ H-24_BANC ");
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
                    System.out.println(" Solde : " + compte.getSolde() + " FCFA");
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