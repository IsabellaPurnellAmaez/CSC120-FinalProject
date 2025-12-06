public class Table {
    public Boolean checkedUnder; 
    private String message;

    public Table(){
        this.checkedUnder = false;
        this.message = "Under the table is a piece of paper that says: \n abcdefghijklmnopqrstuvwxyz \n nopqrstuvwxyzabcdefghijklm \n \n ybbx haqre gur pbhpu phfuvbaf";
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

