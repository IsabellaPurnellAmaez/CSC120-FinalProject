public class LivingRoom {
    public Cup redCup; 
    public Cup blueCup; 
    public Cup greenCup; 

    public Bookshelf bookshelf;
    public Table table;
    public Couch couch;
    public Box box;

    public Door outsideDoor;
    public Door bedroomDoor;
    public Key bedroomDoorKey;

    public LivingRoom(){
        this.redCup = new Cup("Inside the red cup is a piece of paper. On it is a note: 'Look at the book'");
        this.blueCup = new Cup("Inside the blue cup is a piece of paper with the number '4' on it");
        this.greenCup = new Cup("Inside the red cup is a piece of paper with the number '7' on it");

        this.bookshelf = new Bookshelf();
        this.table = new Table();
        this.couch = new Couch();
        this.box = new Box();
        

        this.outsideDoor = new Door("Outside door");
        this.bedroomDoor = new Door("Bedroom door");
        this.bedroomDoorKey = new Key("Bedroom door");
    }
    
    
}
