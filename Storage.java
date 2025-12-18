import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Storage {
    int numOfDrawers;
    Map<Integer, List<String>> drawerSpecifics = new HashMap<>(); //key: drawer #, value [locked (T/F), foundMessage]

    /**
     * Method to open a specific drawer
     * @param drawerNum the drawer number that is being opened
     */
    public void open(int drawerNum){
        if(drawerSpecifics.get(drawerNum).get(0) == "T"){
            System.out.println("Drawer " + drawerNum + " is now open.");
            System.out.println(drawerSpecifics.get(drawerNum).get(1));
            //does drawer need to be an object?? hopefully not
        } else {
            System.out.println("Drawer is locked. Needs a five letter code to be open.");
        }
        //needs to add key to if statement to unlock
    }

   

}
