public class PuzzlePiece {
    private String foundMessage = "No found message written"; //do we need a message for finding puzzle pieces?
    public Boolean foundPiece = false;

    /**
     * Constructor for PuzzlePiece class
     * @param foundMessage the message for when a piece of the puzzle is found
     */
    public PuzzlePiece(String foundMessage){
        this.foundMessage = foundMessage;
        this.foundPiece = false;
    }

    /**
     * Getter for foundPiece
     * @return the status of foundPiece
     */
    public Boolean getFoundPiece(){
        return this.foundPiece;
    }

    /**
     * Method to pick up a puzzle piece
     */
    public void pickUp(){
        System.out.println(this.foundMessage);
        this.foundPiece = true;
    }

}
