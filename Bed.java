public class Bed {
    boolean lifted;

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
        if(!lifted){
            lifted = true; //clueFound = true?
            System.out.println("You have lifted the covers and found a clue! There's a puzzle piece and a piece of paper with the letters 'TUK'..."); // add indication of a clue
        } else {
            System.out.println("The covers are already lifted.");
        }
    }

    /**
     * Method to pick up the clue under the covers
     */
    public void pickUp(){ //pick up the clues*** 
        if(lifted){
            System.out.println("You found a clue under the covers!");
        } else if(!lifted){
            System.out.println("You need to lift the covers first.");
        } else {//no third option add clueFound back?
            System.out.println("You have already found the clue under the covers.");
        }
    }

}
