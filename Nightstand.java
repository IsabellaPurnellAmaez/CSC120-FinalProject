import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Nightstand extends Storage {

    public Nightstand() {
        this.numOfDrawers = 2;
        this.drawerSpecifics = new HashMap<>(); //key: drawer #, value [locked (T/F), foundMessage]
        
        drawerSpecifics.put(1, (new ArrayList<>())); 
        drawerSpecifics.get(1).addAll(Arrays.asList("T", "You found a puzzle piece and a piece of paper that says to look around the dresser..."));

        drawerSpecifics.put(2, (new ArrayList<>())); 
        drawerSpecifics.get(2).addAll(Arrays.asList("F", "You found another puzzle piece..."));


        //need to write IN MAIN a method for when you can unlock the second drawer using open method from storage
    }
}
