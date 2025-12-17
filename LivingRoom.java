public class LivingRoom {
    private Cup redCup; 
    private Cup blueCup; 
    private Cup greenCup; 

    private Bookshelf bookshelf;
    private Table table;
    private Couch couch;
    private Box box;

    private Door outsideDoor;
    private Door bedroomDoor;
    private Key bedroomDoorKey;

    private String roomMessage;

    public LivingRoom(){
        this.redCup = new Cup("Inside the red cup is a piece of paper. On it is a note: 'Look at the bookshelf'");
        this.blueCup = new Cup("Inside the blue cup is a piece of paper with the number '4' on it");
        this.greenCup = new Cup("Inside the green cup is a piece of paper with the number '7' on it");

        this.bookshelf = new Bookshelf();
        this.table = new Table();
        this.couch = new Couch();
        this.box = new Box();
        

        this.outsideDoor = new Door("outside");
        this.bedroomDoor = new Door("bedroom");
        this.bedroomDoorKey = new Key("Bedroom door");

        this.roomMessage = "Inside the living room is a table with three cups on it, a couch, and a bookshelf. There are two doors, the one you came through and a door leading to another room.";
    }
    
    /**
     * Getter for redCup
     * @return the redCup
     */
    public Cup getRedCup(){
        return redCup;
    }
    /**
     * Getter for blueCup
     * @return the blueCup
     */
    public Cup getBlueCup(){
        return blueCup;
    }
    /**
     * Getter for greenCup
     * @return the greenCup
     */
    public Cup getGreenCup(){
        return greenCup;
    }

    /**
     * Getter for bookshelf
     * @return the bookshelf
     */
    public Bookshelf getBookshelf(){
        return bookshelf;
    }
    /**
     * Getter for table
     * @return the table
     */
    public Table getTable(){
        return table;
    }
    /**
     * Getter for couch
     * @return the couch
     */
    public Couch getCouch(){
        return couch;
    }
    /**
     * Getter for box
     * @return the box
     */
    public Box getBox(){
        return box;
    }

    /**
     * Getter for outsideDoor
     * @return the outsideDoor
     */
    public Door getOutsideDoor(){
        return outsideDoor;
    }
    /**
     * Getter for bedroomDoor
     * @return the bedroomDoor
     */
    public Door getBedroomDoor(){
        return bedroomDoor;
    }
    /**
     * Getter for bedroomDoorKey
     * @return the bedroomDoorKey
     */
    public Key getBedroomDoorKey(){
        return bedroomDoorKey;
    }

    /**
     * Getter for roomMessage
     * @return the roomMessage
     */
    public String getRoomMessage(){
        return roomMessage;
    }
    
}
