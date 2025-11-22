import java.util.ArrayList;

public class Puzzle {
    int missingPieces;
    ArrayList<Integer> pieces;
    boolean isCompleted;

    public Puzzle(){
        this.missingPieces = 3;
        this.pieces = new ArrayList<>();
        for(int i = 1; i <= missingPieces; i++){
            pieces.add(i);
        }
        this.isCompleted = false;
    }//not sure how to implement collecting pieces and completing puzzle with individual pieces
    public void placePiece(int pieceNumber){ // not sure how to do this without a specific piece number
        if(pieces.contains(pieceNumber)){
            pieces.remove(Integer.valueOf(pieceNumber));
            System.out.println("You have placed piece " + pieceNumber + " into the puzzle.");
            if(pieces.isEmpty()){
                isCompleted = true;
                System.out.println("Congratulations! You have completed the puzzle.");
            }
        } else {
            System.out.println("Piece " + pieceNumber + " is not available to place.");
        }
    }

    public void flipPuzzle(){
        if(isCompleted){
            System.out.println("You flip the completed puzzle to reveal a hidden message."); // add message
        } else {
            System.out.println("The puzzle is not yet completed. You cannot flip it.");
        }
    }

}
