import java.util.ArrayList;
abstract class Storage {
    int numOfDrawers;
    ArrayList<Integer> drawer;
    boolean isLocked;

    public void open(int drawer){
        if(!isLocked){
            System.out.println("Drawer " + drawer + " is now open.");
        } else {
            System.out.println("Drawer is locked. Needs a key to be open.");
        }
        //needs to add key to if statement to unlock
    }
}
