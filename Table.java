public class Table {
    public Boolean checkedUnder; 
    private String message;

    /**
     * Constructor for Table class
     */
    public Table(){
        this.checkedUnder = false;
        this.message = "You find a piece of paper that seems to be a cipher for the unreadable page in the book.";
    }

    /**
     * Method to read the message under the table
     */
    public void readMessage(){
        if(checkedUnder == false){
            System.out.println(message);
            checkedUnder = true;
        }else{
            System.out.println("You've already looked here. There's nothing else to see.");
        }
    }
   
}

