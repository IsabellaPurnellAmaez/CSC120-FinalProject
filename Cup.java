public class Cup{
    
    private String color = "No color selected";
    private String foundMessage = "No found message written";
    private Boolean foundCup = false;


    public Cup(String color, String foundMessage){
        this.color = color;
        this.foundMessage = foundMessage;
        this.foundCup = false;
    }

    public Boolean getFoundCup(){
        return this.foundCup;
    }

    public void pickUp(String color){
        System.out.println(this.foundMessage);
        this.foundCup = true;
    }


public static void main(String[] args){
    
}


}