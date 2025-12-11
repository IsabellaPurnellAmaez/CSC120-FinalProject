import java.util.ArrayList;

public class Puzzle {
    ArrayList<Integer> pieces; //array list of puzzle pieces*** 

    public Puzzle(){
        this.pieces = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            pieces.add(i);
        }

    }
    public void placePiece(int pieceNumber){ // have piece number be some sort of variable in main OR check if piece in pocket instead.***
        if(pieces.contains(pieceNumber)){
            pieces.remove(Integer.valueOf(pieceNumber));
            //have this message say "you have placed *some number* of pieces." then say if the puzzle is done or not. 
            System.out.println("You have placed piece " + pieceNumber + " into the puzzle.");
            }
        else {
            System.out.println("You don't have any pieces to finish the puzzle, go find them!");
        }
    }

    public void flipPuzzle(){
        if(this.pieces.size() == 3 ){
            System.out.println("You flip the completed puzzle to reveal a hidden message."); // add message
        } else {
            System.out.println("The puzzle is not yet completed. You cannot flip it.");
        }
    }

}
