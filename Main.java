import java.util.ArrayList;
import java.util.Scanner;


public class Main { //im wondering if theres a way to make a list of all the objects in each room. That way if someone is trying to go to an object it first checks that they're in the appropriate room first? I think it'd be more efficient to do that in main rather than have each object have a Boolean attribute that's 'inLivingRoom' or 'inBedroom'...
   private Cup redCup; 
   private Cup blueCup; 
   private Cup greenCup; 

   private Bookshelf bookshelf;
   private Table table;
   private Couch couch;
   private Box box;

   private Door outsideDoor;
   private Door bedroomDoor;
   private Key outsideDoorKey;
   private Key bedroomDoorKey;

   private Nightstand nightstand;
   private Dresser dresser;
   private Bed bed;
   private Puzzle puzzle;
   
   private PuzzlePiece puzzlePiece1;
   private PuzzlePiece puzzlePiece2;
   private PuzzlePiece puzzlePiece3;

   private Mirror mirror;

   
    //private int pieceNumber = ; //number of puzzle pieces found & on the player's person.

   public Main(){
      this.redCup = new Cup("Inside the red cup is a piece of paper. On it is a note: 'Look at the books'");
      this.blueCup = new Cup("Inside the blue cup is a piece of paper with the number '4' on it");
      this.greenCup = new Cup("Inside the red cup is a piece of paper with the number '7' on it");

      this.bookshelf = new Bookshelf();
      this.table = new Table();
      this.couch = new Couch();
      this.box = new Box();

      this.outsideDoor = new Door("Outside door");
      this.bedroomDoor = new Door("Bedroom door");
      this.outsideDoorKey = new Key("Outside door");
      this.bedroomDoorKey = new Key("Bedroom door");

      this.nightstand = new Nightstand();
      this.dresser = new Dresser();
      this.bed = new Bed();
      this.puzzle = new Puzzle();
      
      this.puzzlePiece1 = new PuzzlePiece(""); //not sure what the found messages should actually be for these? Just you've picked up the piece?
      this.puzzlePiece2 = new PuzzlePiece("");
      this.puzzlePiece3 = new PuzzlePiece("");

      this.mirror = new Mirror();
      }

      public void checkBookshelf(){ //need a bunch of methods to access object methods and reset booleans about whether or not clues can be accessed yet
         if(this.redCup.foundCup){ 
            this.bookshelf.foundClue = true;
         }
         this.bookshelf.approachBookshelf();
      }

      


    public static void main (String[] args){ //idk what this duplicate modifier error means. Is it bc the object is named Main as well? 
      System.out.println("You are locked inside a room. The room has two doors, the one you entered through and another that you don't know where it leads. Both are locked. Inside the room with you is a table with three different colored cups, a bookshelf, and a couch.");
      Scanner playGame = new Scanner(System.in);
      String inputLine = playGame.nextLine();

      if(inputLine.contains("cup") && inputLine.contains("lift") || inputLine.contains("pick up")){ //starting to write code interacting with the player. Not sure if it should be in main or in the methods above...
         if(inputLine.contains("red")){
            //pick up redCup
         }
      }


   }

}


