import java.util.Scanner;

public class Box {
    private String boxCode; //could be int? could figure out how to do the thing where it takes in multiple possible types for int or string.
    public Boolean open; 
    private String checkOutBox;
    private Boolean tryToOpen;

    public Box(){
        this.boxCode = "3417";
        this.open = false;
        this.checkOutBox = "The box is small and has a lock on it that requires a 4 digit code to open.";
        this.tryToOpen = false;

    }

    public void openBox(){
        this.tryToOpen = false;
        Scanner tryLock = new Scanner(System.in);
        while(this.tryToOpen){
            String codeTry = tryLock.nextLine(); //I think this method probably has bugs with the scanner and I doubt it works right now, need to do more testing. 
            if(codeTry == this.boxCode){
                System.out.println("You've opened the box! Inside is a key.");
                this.open = true;
            }  else{
                System.out.println("Not quite right, care to try again?"); // need a way for them to maybe leave and come back? this whole section needs a lot of work. 
                String endTry = tryLock.nextLine();
                if (endTry.contains("no") || endTry.contains("No")){ //this needs work. Need to slice the string and check for some sort of affirmative/negative statement and then proceed. Also how to do or statements in java? Google said || but that does not seem to be working.
                    tryLock.close();
                    this.tryToOpen = false;
                    System.out.println("Ok, now what will you do?"); 
                }
            }
        }
    }

    public void pickUp(){
        System.out.println(checkOutBox);
    }
}


