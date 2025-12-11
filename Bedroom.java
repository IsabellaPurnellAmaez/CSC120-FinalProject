import java.util.NavigableMap;

public class Bedroom {
    public Key outsideDoorKey;

    public Nightstand nightstand;
    public Dresser dresser;
    public Bed bed;
    public Puzzle puzzle;
   
    public PuzzlePiece puzzlePiece1;
    public PuzzlePiece puzzlePiece2;
    public PuzzlePiece puzzlePiece3;

    public Mirror mirror;

    public String roomMessage;
    //private int pieceNumber = ; //number of puzzle pieces found & on the player's person.

    public Bedroom(){
        this.outsideDoorKey = new Key("Outside door");
    
        this.nightstand = new Nightstand();
        this.dresser = new Dresser();
        this.bed = new Bed();
        this.puzzle = new Puzzle();
        
        this.puzzlePiece1 = new PuzzlePiece(""); //not sure what the found messages should actually be for these? Just you've picked up the piece?
        this.puzzlePiece2 = new PuzzlePiece("");
        this.puzzlePiece3 = new PuzzlePiece("");

        this.mirror = new Mirror();

        this.roomMessage = "You're in a bedroom with a bed, nightstand, and a dresser with a puzzle on it. There is one door leading to the livingroom.";
    }

    public Key getOutsideDoorKey(){
        return outsideDoorKey;
    }

    public Nightstand getNightstand(){
        return nightstand;
    }
    public Dresser getDresser(){
        return dresser;
    }
    public Bed getBed(){
        return bed;
    }
    public Puzzle getPuzzle(){
        return puzzle;
    }

    public PuzzlePiece getPuzzlePiece1(){
        return puzzlePiece1;
    }
    public PuzzlePiece getPuzzlePiece2(){
        return puzzlePiece2;
    }
    public PuzzlePiece getPuzzlePiece3(){
        return puzzlePiece3;
    }  

    public Mirror getMirror(){
        return mirror;
    }

    public String getRoomMessage(){
        return roomMessage;
    }
}
