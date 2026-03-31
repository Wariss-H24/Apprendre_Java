public class learn {
    public static void main(String[] args) {
        myMethode();
        // Exo 1
        int[] nombres = {3, 7, 2, 9, 5};
        
        Showelement(nombres);
        //Exo 2
        System.out.println("La somme des nombres est : " + Somme(nombres));
        //Exo 3
        
        int[] num = {3, 7, 2, 9, 5};
        System.out.println("Le plus grand des nombres est : " + MaxNumber(num));
    }
    
    //Hello world
    public static void myMethode(){
        System.out.println("Hello Wariss");
    }
    
    //Function exo 1
    public static void Showelement(int[] nombres){
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }
    }

    //Function exo 2
    public static int Somme(int [] sum){
        int Somme = 0;
        for (int i = 0; i < sum.length; i++ ){
            Somme +=sum[i];
        }
        return Somme;
    }

    //Function exo 3
    public static int MaxNumber(int[] num){
        int max = num[0];
        for (int i = 1; i < num.length; i++){
            if (num[i]> max ) {
                max = num[i];
            }
        }
        return max;
    }
}