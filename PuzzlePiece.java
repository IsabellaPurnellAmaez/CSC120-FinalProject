public class PuzzlePiece {
    private Boolean foundPiece = false;

    /**
     * Constructor for PuzzlePiece class
     * @param foundMessage the message for when a piece of the puzzle is found
     */
    public PuzzlePiece(){
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
        this.foundPiece = true;
    }

}
