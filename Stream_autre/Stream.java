import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream{
    public static void main(String[] args) {
        threChar();

        //ArrayList
        ArrayList<String> voiture = new ArrayList<String>();
        voiture.add("RollRoyce");
        voiture.add("Ferrari");
        voiture.add("BMW");
        voiture.add("Toyota");
        voiture.add(0,"Mercedes");
        voiture.get(0);
        voiture.set(2, "Opnel");
        voiture.remove(4);
        voiture.size();
        System.out.println(voiture);

        //HashSet
        HashSet<String> bayol = new HashSet<String>();
        bayol.add("Phantom_RR");
        bayol.add("Marc Xos");
        bayol.add("Vinto");
        
        System.out.println(bayol);

        //HashMap : Paires clé-valeur (Les clés sont uniques)
        HashMap<String, String> capitalCitites = new HashMap<String, String>(); 
        capitalCitites.put("England", "London");
        capitalCitites.put("Germany", "Berlin");
        capitalCitites.put("Norway", "Oslo");
        System.out.println(capitalCitites);

        //Itérator
        Iterator<String> it = voiture.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //
       ArrayList<Integer> ordoner = new ArrayList<>(Arrays.asList(1, 2, 3));

        int min = Collections.min(ordoner);
        int max = Collections.max(ordoner);

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

    }
    public static void threChar(){
        List<String> noms = Arrays.asList("Ali", "Jean", "Paul", "Anna");

        List<String> result= noms.stream()
        .filter(n -> n.length() > 3)
        .map(String::toUpperCase)
        .sorted()
        .collect(Collectors.toList());
        System.out.println(result);
    }
}