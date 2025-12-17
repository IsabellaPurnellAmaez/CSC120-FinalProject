public class Cup{
    
    private String foundMessage;
    public Boolean foundCup;

    /**
     * Constructor for Cup class
     * @param foundMessage the message for when the cup is found
     */
    public Cup(String foundMessage){
        this.foundMessage = foundMessage;
        this.foundCup = false;
    }

    /**
     * Method to pick up a cup
     */
    public void pickUp(){
        System.out.println(this.foundMessage);
        this.foundCup = true;
    }


}