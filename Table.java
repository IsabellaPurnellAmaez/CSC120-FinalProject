public class Table {
    public Boolean checkedUnder; 
    private String message;

    public Table(){
        this.checkedUnder = false;
        this.message = "Under the table is a piece of paper that says: \n abcdefghijklmnopqrstuvwxyz \n nopqrstuvwxyzabcdefghijklm";
    }

 
    public Boolean getCheckedUnder(){ //should the attribute be private and just have this method or just let it be public
        return checkedUnder;
    }

    public void readMessage(){
        if(checkedUnder){
            System.out.println(message);
        }else{
            System.out.println("Something about this table does look odd but you can't quite figure out what. Maybe keep looking around.");
        }
    }
   
}

