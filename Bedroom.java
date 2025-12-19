//import java.util.NavigableMap;

public class Bedroom {
    private Key outsideDoorKey;

    private Nightstand nightstand;
    private Dresser dresser;
    private Bed bed;
    private Puzzle puzzle;
   
    private PuzzlePiece puzzlePiece1;
    private PuzzlePiece puzzlePiece2;
    private PuzzlePiece puzzlePiece3;

    private Mirror mirror;

    private String roomMessage;
    //private int pieceNumber = ; //number of puzzle pieces found & on the player's person.

    /**
     * Constructor for Bedroom class
     */
    public Bedroom(){
        this.outsideDoorKey = new Key("outside door");
    
        this.nightstand = new Nightstand();
        this.dresser = new Dresser();
        this.bed = new Bed();
        this.puzzle = new Puzzle();
        
        this.puzzlePiece1 = new PuzzlePiece(); 
        this.puzzlePiece2 = new PuzzlePiece();
        this.puzzlePiece3 = new PuzzlePiece();

        this.mirror = new Mirror();

        this.roomMessage = "you're in a bedroom with a bed, nightstand, and a dresser with a puzzle on it. there is one door leading to the living room.";
    }

    /**
     * Getter for outsideDoorKey
     * @return outside door key
     */
    public Key getOutsideDoorKey(){
        return outsideDoorKey;
    }

    /**
     * Getter for nightstand
     * @return the nightstand
     */
    public Nightstand getNightstand(){
        return nightstand;
    }
    /**
     * Getter for dresser
     * @return the dresser
     */
    public Dresser getDresser(){
        return dresser;
    }
    /**
     * Getter for bed
     */
    public Bed getBed(){
        return bed;
    }
    /**
     * Getter for puzzle
     * @return the puzzle
     */
    public Puzzle getPuzzle(){
        return puzzle;
    }

    /**
     * Getter for puzzlePiece1
     * @return the puzzlePiece1
     */
    public PuzzlePiece getPuzzlePiece1(){
        return puzzlePiece1;
    }
    /**
     * Getter for puzzlePiece2
     * @return the puzzlePiece2
     */
    public PuzzlePiece getPuzzlePiece2(){
        return puzzlePiece2;
    }
    /**
     * Getter for puzzlePiece3
     * @return the puzzlePiece3
     */
    public PuzzlePiece getPuzzlePiece3(){
        return puzzlePiece3;
    }  

    /**
     * Getter for mirror
     * @return the mirror
     */
    public Mirror getMirror(){
        return mirror;
    }

    /**
     * Getter for roomMessage
     * @return the roomMessage
     */
    public String getRoomMessage(){
        return roomMessage;
    }
}
