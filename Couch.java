public class Couch {
    private Boolean lifted;
    private String liftedMessage = "No found message written";

    /**
     * Constructor for Couch class
     */
    public Couch(){
        this.liftedMessage = "underneath the couch cushions is a small black box with a lock on it.";
        this.lifted = false;
    }

     /**
     * getter for lifted
     * @return whether or not the couch cushion has been lifted
     */
    public Boolean getLifted(){
        return this.lifted;
    }

    /**
     * Method to pick up cushions
     */
    public void pickUpCushions(){
        if(!this.lifted){
            System.out.println(this.liftedMessage);
            this.lifted = true;
        } else{
            System.out.println("you've already checked under the cushions. underneath the couch cushions is a small black box with a lock on it.");
        }
    }
    
}
