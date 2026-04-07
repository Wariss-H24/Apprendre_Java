import services.*;
import models.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BanqueService banqueService = new BanqueService();
        CompteService compteService = new CompteService();

        int choix;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Créer compte");
            System.out.println("2. Dépôt");
            System.out.println("3. Retrait");
            System.out.println("4. Solde");
            System.out.println("5. Transactions");
            System.out.println("6. Quitter");

            choix = sc.nextInt();

            System.out.print("Numéro compte: ");
            int num = sc.nextInt();

            CompteBancaire compte = banqueService.chercherCompte(num);

            switch (choix) {

                case 1:
                    sc.nextLine();
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    banqueService.creerCompte(num, nom);
                    break;

                case 2:
                    if (compte != null) {
                        System.out.print("Montant: ");
                        double m = sc.nextDouble();
                        compteService.deposer(compte, m);
                    }
                    break;

                case 3:
                    if (compte != null) {
                        System.out.print("Montant: ");
                        double m = sc.nextDouble();
                        compteService.retirer(compte, m);
                    }
                    break;

                case 4:
                    if (compte != null) {
                        System.out.println("Solde: " + compte.getSolde());
                    }
                    break;

                case 5:
                    if (compte != null) {
                        compte.getTransactions().forEach(System.out::println);
                    }
                    break;
            }

        } while (choix != 6);
    }
}