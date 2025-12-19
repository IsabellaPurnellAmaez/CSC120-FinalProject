
public class Box {
    public String boxCode; //could be int? could figure out how to do the thing where it takes in multiple possible types for int or string.
    public Boolean open; 
    public Boolean tryToOpen;

    /**
     * Constructor for Box class
     */
    public Box(){
        this.boxCode = "3417";
        this.open = false;
        this.tryToOpen = false;
    }

}