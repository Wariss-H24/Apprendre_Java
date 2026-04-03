import java.util.*;
public class Main {
    public static void main(String[] args) {
       
       List<Products> products = GestionProduct.addProduct();
         System.out.println("\nProduct List:");
         for (int i = 0; i < products.size(); i++) {
             Products product = products.get(i);
             System.out.println(product.getProduit() + " - $" + product.getPrix() + " - Stock: " + product.getStock());
         }
}
}
 