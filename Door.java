import java.util.Scanner;
public class Door {
    String name;
    boolean isLocked;
    Key key;

    public Door(String name){
        this.name = name;
        this.isLocked = true;
    }

    public void unlock(){
        Scanner keyInput = new Scanner(System.in);
        System.out.println("What key do you want to use?");
        if(keyInput.equals(key.description)){ 
            if(key.usage == this.name){
                isLocked = false;
            } else if(key.usage != this.name){
                isLocked = true;
                System.out.println("This key does not unlock " + this.name);
            }
        } else {
            System.out.println("You don't have that key for this door.");
        }
        keyInput.close();
    }
}
