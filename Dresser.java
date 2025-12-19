import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Dresser extends Storage {

    /**
     * Constructor for Dresser class
     */
    public Dresser() {
        this.numOfDrawers = 3;
        this.drawerSpecifics = new HashMap<>(); //key: drawer #, value [locked (T/F), foundMessage]
        
        drawerSpecifics.put(1, (new ArrayList<>())); 
        drawerSpecifics.get(1).addAll(Arrays.asList("T", "you found a piece of paper that says SC..."));

        drawerSpecifics.put(2, (new ArrayList<>())); 
        drawerSpecifics.get(2).addAll(Arrays.asList("T", "you found a piece of paper that says to check under the covers of the bed..."));

        drawerSpecifics.put(3, (new ArrayList<>())); 
        drawerSpecifics.get(3).addAll(Arrays.asList("T", "you found a puzzle piece..."));
    
        
    }
}
