import java.util.Scanner;

public class Box {
    public String boxCode; //could be int? could figure out how to do the thing where it takes in multiple possible types for int or string.
    public Boolean open; 
    private String checkOutBox;
    public Boolean tryToOpen;

    public Box(){
        this.boxCode = "3417";
        this.open = false;
        this.checkOutBox = "The box is small and has a lock on it that requires a 4 digit code to open.";
        this.tryToOpen = false;

    }

    public void pickUp(){
        System.out.println(checkOutBox);
    }
}


