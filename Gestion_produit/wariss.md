import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String[] produits1 = {"riz", "maïs", "mil"};
        int[] prix1 = {25, 50, 75};
        int[] stock1 = {2, 4, 6};
        
        System.out.println("Voulez vous ajouter un nouveau produit ?");
        String resultat = scanner.nextLine(); 
        if (resultat.equalsIgnoreCase("oui")) {
            System.out.println("Nom du produit");
            String nom = scanner.nextLine(); 
            System.out.println("Prix du produit : ");
            int prix = scanner.nextInt();
            System.out.println("Stock du produit");
            int stock = scanner.nextInt();

            String[] nProduits = new String[produits1.length +1];
            int[] nPrix = new int[prix1.length +1];
            int[] nStock = new int[stock1.length +1];

            for (int i = 0; i < produits1.length; i++) {
                nProduits[i] = produits1[i];
                nPrix[i] = prix1[i];
                nStock[i] = stock1[i];
            }

            nProduits[produits1.length] =  nom;
            nPrix[produits1.length] =  prix;
            nStock[produits1.length] = stock;

            // String[] produits2 = {"savon", "dentifrice", "brosse", "shampoing", "crème"};
            // String[] produits3 = {"stylo", "cahier", "livre", "gomme", "règle"};
            // int[] prix2 = {150, 175, 200, 225, 250};
            // int[] prix3 = {275, 300, 325, 350, 375};
            // int[] stock2 = {5, 8, 12, 4, 3};
            // int[] stock3 = {10, 9, 7, 20, 88};
                for (int i = 0; i < produits1.length; i++) {
                System.out.println("Produit : " + produits1[i]);
                System.out.println("Prix : " + prix1[i]);
                System.out.println("Stock : " + stock1[i]);
        }
        }else {
            System.out.println("\nListe des produits :");
            for (int i = 0; i < produits1.length; i++) {
                System.out.println("Produit : " + produits1[i]);
                System.out.println("Prix : " + prix1[i]);
                System.out.println("Stock : " + stock1[i]);
            }
        }
}
}


//Ajouter la methode de supresion de  produit crud sur le produit et surtout vider tout le stock

Cree le package Modele et Service puis déplacer les modèles dans le package et les dans le packages Service.