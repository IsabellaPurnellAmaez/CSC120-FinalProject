import java.util.ArrayList;

public class Puzzle {
    private ArrayList<String> pieces; //array list of puzzle pieces  
    private Boolean flipped;

    /**
     * Constructor for Puzzle class
     */
    public Puzzle(){
        this.pieces = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            pieces.add("puzzle piece " + i);
        }
        this.flipped = false;
    }

    /**
     * Getter for flipped
     * @return the status of flipped
     */
    public Boolean getFlipped(){
        return this.flipped;
    }

    /**
     * Method to place a puzzle piece into the puzzle
     * @param pieceNumber the number of the piece being placed
     */
    public void placePiece(String pieceNumber){ // have piece number be some sort of variable in main OR check if piece in pocket instead.***
        if(pieces.contains(pieceNumber)){
            pieces.remove(pieceNumber);
            //have this message say "you have placed *some number* of pieces." then say if the puzzle is done or not. 
            System.out.println("you have placed piece " + pieceNumber + " into the puzzle.");
            }
        else if(this.pieces.size() == 0){
            System.out.println("you've completed the puzzle and a message is revealed. it now says 'flip me over'");
        } else {
            System.out.println("you don't have any pieces to finish the puzzle, go find them!");
        }

        

    }

    /**
     * Method to flip the completed puzzle
     */
    public void flipPuzzle(){
        if(this.pieces.size() == 0 ){
            System.out.println("you flip the completed puzzle to reveal a hidden message: look behind the mirror"); // add message
            this.flipped = true;
        } else {
            System.out.println("the flipped puzzle has a message on it but there are still too many pieces missing to understand what it says. go look for more pieces and then try to flip it again.");
        }
    }

}
