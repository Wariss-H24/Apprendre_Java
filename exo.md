
import java.util.Scanner;

public class Exo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String userInput = scanner.nextLine();
        // System.out.print("Entrez le mot : ");
        myMethod();
        // double userDouble= scanner.nextDouble();
        // System.out.println(Reele(userDouble));
        // System.out.println(Charactere("Bonjour tout le monde")); 
        //Puissance
        System.out.print("Entrez le nombre : ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(Power(a, b));
} 
 
 static void myMethod(){
    System.out.println("Hello World");
}

public static int Charactere(String str){
    int resultat = 0;
    for (int i = 0; i < str.length(); i++) {
        char voyelle = str.charAt(i);
        voyelle= Character.toLowerCase(voyelle);
        if (voyelle == 'a' || voyelle == 'e' || voyelle == 'i' || voyelle == 'o' || voyelle == 'u' || voyelle == 'y') {
            resultat++;
        }
    }
    return resultat; 
}

public static String Reele (double number){ 
     double resultat = number;  
     int partieEntiere = (int) number;
    return "La partie entière de " + number + " est " + partieEntiere + " et la partie décimale est " + (resultat - partieEntiere);

}

public static int Power(int base, int exposant){
    int resultat = 1;
    for (int i = 0; i < exposant; i++) {
        resultat *= base;
    }
    return resultat;
}
}