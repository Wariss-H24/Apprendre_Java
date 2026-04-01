import java.util.*;
public class Exo {
    public static void main(String[] args) {

        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        
        for (int n : num) {
            if(n % 2 == 0){
                System.out.println(num);
            };
        }
    
    // cree un likedlisste avec 3 nom et vous ajouter le nouveau nom 1 au debut et un a la fin
        LinkedList<String> noms = new LinkedList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        noms.addFirst("Sahid");
        noms.addLast("Sergio");
        System.out.println(noms);

    //declare une liste de string mais utilise une arrayLIste ajoute 3 element et affiche les
     List<String> nos = new ArrayList<>();
        nos.add("Alice");
        noms.add("Bob");
        noms.add("Charlie");
        for (String nom : nos) {
            System.out.println(nom);
        }

        //
        HashMap<String, Integer> personne= new HashMap<>();
        personne.put("Wariss", 23);
        personne.put("Sahid", 23);
        personne.put("Sergio", 23);
         System.out.println(personne);
         System.out.println(personne.get("Sahid"));
         
         //
}
}


