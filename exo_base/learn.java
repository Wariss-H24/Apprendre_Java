import java.util.Arrays;

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
        //Exo 4
        System.out.println("Le tableau contient : " + PairNumber(num) + "nombres pair");

        //Niveau 2
        //Exo 5
        System.out.println("La moyenne des elements est : " + moyenne(num));
        //Exo 6
        System.out.println("L'inverse du tableau est : " + Arrays.toString(inverse(num)));
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

    //Funcion exo 4

    public static int PairNumber(int[] pair){
        int getPair=0;
        for ( int i = 0; i < pair.length; i++){
            if (pair[i] % 2 == 0){
                getPair++;
            }
        }
        return getPair;
    }


    //Niveau 2
    //Function exo 5
    public static double moyenne(int[] tab){
        int MyMoy = 0;
        for(int i=0; i < tab.length ; i++){
            MyMoy += tab[i];
        }
        return (double) MyMoy / tab.length;
    }

    public static int[] inverse(int[] bat){
        int[] result= new int[bat.length];
        for (int i =0; i < bat.length; i++){
           result[i] = bat[bat.length - 1 - i];
        }
        return result;
    }
}