public class Couch {
    public Boolean lifted;
    private String liftedMessage = "No found message written";

    /**
     * Constructor for Couch class
     */
    public Couch(){
        this.liftedMessage = "Underneath the couch cushions is a small black box with a lock on it.";
        this.lifted = false;
    }

    /**
     * Method to pick up cushions
     */
    public void pickUpCushions(){
        if(!this.lifted){
            System.out.println(this.liftedMessage);
            this.lifted = true;
        } else{
            System.out.println("You've already checked under the cushions. Underneath the couch cushions is a small black box with a lock on it.");
        }
    }
    
}
