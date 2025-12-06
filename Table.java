public class Table {
    public Boolean checkedUnder; 
    private String message;

    public Table(){
        this.checkedUnder = false;
        this.message = "You find a piece of paper that seems to be a cipher for the unreadable page in the book.";
    }

    public void readMessage(){
        if(checkedUnder == false){
            System.out.println(message);
            checkedUnder = true;
        }else{
            System.out.println("Something about this table does look odd but you can't quite figure out what. Maybe keep looking around.");
        }
    }
   
}

