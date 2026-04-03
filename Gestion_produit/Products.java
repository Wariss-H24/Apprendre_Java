public class Products {
        
    private String produit;
    private double prix;
    private int stock;
        
    public Products (String produit, double prix, int stock){
        this.produit = produit;
        this.prix = prix;
        this.stock = stock;
    }
    public String getProduit() {
        return produit;
    }
     public double getPrix() {
        return prix;
    }

    public int getStock() {
        return stock;
    }
    public void setProduit(String produit) {
        this.produit = produit;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
