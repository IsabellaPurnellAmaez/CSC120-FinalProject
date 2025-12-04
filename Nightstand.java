import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Nightstand extends Storage {
    Key key;

    public Nightstand() {
        this.numOfDrawers = 2;
        this.drawerSpecifics = new HashMap<>(); //key: drawer #, value [locked (T/F), foundMessage]
        
        drawerSpecifics.put(1, (new ArrayList<>())); 
        drawerSpecifics.get(1).addAll(Arrays.asList("T", "You found a puzzle piece and a piece of paper that says to look around the dresser..."));

        drawerSpecifics.put(2, (new ArrayList<>())); 
        drawerSpecifics.get(2).addAll(Arrays.asList("F", "You found another puzzle piece..."));

        //need to write IN MAIN a method for when you can unlock the second drawer using open method from storage
        //2 drawer after key is used locked is T and message is shown
    }

    public void unlock(){ //take string from scanner in main
        Scanner scanner = new Scanner(System.in);
        String keyInput = scanner.nextLine();
        System.out.println("What key do you want to use?");
        if(keyInput.equals(key.description)){ 
        List<String> newList = Arrays.asList("T", "You found another puzzle piece...");
        drawerSpecifics.put(2, newList);
        } else if(!keyInput.equals(key.description)){
            System.out.println("This key does not unlock the second drawer");
        } else {
            System.out.println("You don't have that key for this drawer.");
        }
        scanner.close();
    }
}
