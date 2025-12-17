import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class Nightstand extends Storage {
    Key key;

    /**
     * Constructor for Nightstand class
     */
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

    /**
     * Method to unlock the second drawer
     * @param nextLine the input string to check against the key description
     */
    public void unlock(String nextLine){ //take string from scanner in main
        System.out.println("What key do you want to use?");
        if(nextLine.equals(key.description)){ 
        List<String> newList = Arrays.asList("T", "You found another puzzle piece...");
        drawerSpecifics.put(2, newList);
        } else if(!nextLine.equals(key.description)){
            System.out.println("This key does not unlock the second drawer");
        } else {
            System.out.println("You don't have that key for this drawer.");
        }
    }
}
