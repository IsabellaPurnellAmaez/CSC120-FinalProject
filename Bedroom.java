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
}
