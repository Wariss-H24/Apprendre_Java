public class Produitelectronique extends Products{
    
    private int garantie;
    public Produitelectronique(String produit, double prix, int stock, int garantie) {
        super(produit, prix, stock);
        this.garantie = garantie; 
    }
    

    public int getGarantie() {
        return garantie;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }
}




