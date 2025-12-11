import java.util.Scanner;
public class Door {
    String name;
    boolean isLocked;
    Key key;

    public Door(String name){
        this.name = name;
        this.isLocked = true;
    }
}
