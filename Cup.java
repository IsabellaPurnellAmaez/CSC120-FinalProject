public class Cup{
    
    private String foundMessage;
    private Boolean foundCup;


    public Cup(String foundMessage){
        this.foundMessage = foundMessage;
        this.foundCup = false;
    }

    public Boolean getFoundCup(){
        return this.foundCup;
    }

    public void pickUp(){
        System.out.println(this.foundMessage);
        this.foundCup = true;
    }


public static void main(String[] args){
    
}


}