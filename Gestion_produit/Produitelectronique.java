public class Produitelectronique extends Products{
    
    private int garentie;
    public Produitelectronique(String produit, double prix, int stock, int garantie) {
        super(produit, prix, stock); 
        // this.garantie = garantie; 
    }
    

    public int getGarentie() {
        return garentie;
    }

    public void setGarentie(int garentie) {
        this.garentie = garentie;
    }
}




