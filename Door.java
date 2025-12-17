public class Door {
    String name;
    boolean isLocked;
    Key key;

    /**
     * Constructor for Door class
     * @param name the name of the door
     */
    public Door(String name){
        this.name = name;
        this.isLocked = true;
    }
}
