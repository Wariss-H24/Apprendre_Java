package exo_base;
import java.util.Scanner;
public class Exercie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le mo : ");
        String userInput = scanner.nextLine();
        myMethod();
        System.out.println(Charactere(userInput));
        System.out.println(Charactere("Bonjour tout le monde"));  
} 

 static void myMethod(){
    System.out.println("Hello World");
}

public static int Charactere(String str){
    int resultat = 0;
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        c= Character.toLowerCase(c);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
            resultat++;
        }
    }
    return resultat;
}

}