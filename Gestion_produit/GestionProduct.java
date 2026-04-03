import java.util.*; // Importation de tout le package java.util.
 
public class GestionProduct {
 
    public static List<Products> addProduct() { // addproduct: méthode pour ajouter et retourner un tableau de produits.
        Scanner input = new Scanner(System.in);
        List<Products> products = new ArrayList<>();
 
        String addMore = "yes";
 
        while (addMore.equals("yes")) {
 
            System.out.print("Entrez le nom du produit: ");
            String productName = input.nextLine();
 
            System.out.print("Entrer le prix du produit: ");
            double productPrice = input.nextDouble();
 
            System.out.print("Entrez le stock du produit: ");
            int productStock = input.nextInt();
            input.nextLine();
 
            Products product = new Products(productName, productPrice, productStock);
            products.add(product);
 
            System.out.print("Voulez-vous ajouter d'autres produits? (yes/no): ");
            addMore = input.nextLine();
        }
 
        return products;
    }
}