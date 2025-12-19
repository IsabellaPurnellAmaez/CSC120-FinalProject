public class Cup{
    
    private String foundMessage;
    private Boolean foundCup;

    /**
     * Constructor for Cup class
     * @param foundMessage the message for when the cup is found
     */
    public Cup(String foundMessage){
        this.foundMessage = foundMessage;
        this.foundCup = false;
    }

    /**
     * getter for foundCup boolean
     * @return found cup 
     */
    public Boolean getFoundCup(){
        return this.foundCup;
    }

    /**
     * Method to pick up a cup
     */
    public void pickUp(){
        System.out.println(this.foundMessage);
        this.foundCup = true;
    }


}