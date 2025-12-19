public class Bed {
    private boolean lifted;

    /**
     * Constructor for Bed class
     */
    public Bed(){
        this.lifted = false;
    }

    /**
     * Method to lift the covers on the bed
     */
    public void liftCovers(){
        if(!this.lifted){
            this.lifted = true; 
            System.out.println("you have lifted the covers and found a clue! there's a piece of paper with the letters 'TUK'...");  
        } else {
            System.out.println("the covers are already lifted.");
        }
    }

    /**
     * Method to pick up the clue under the covers
     */
    public void pickUp(){  
        if(this.lifted){
            System.out.println("you found a clue under the covers!");
        } else if(!this.lifted){
            System.out.println("you need to lift the covers first.");
        } else {
            System.out.println("you have already found the clue under the covers.");
        }
    }

}
