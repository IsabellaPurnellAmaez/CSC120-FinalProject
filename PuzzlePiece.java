public class PuzzlePiece {
    private String foundMessage = "No found message written";
    private Boolean foundPiece = false;


    public PuzzlePiece(String foundMessage){
        this.foundMessage = foundMessage;
        this.foundPiece = false;
    }

    public Boolean getFoundPiece(){
        return this.foundPiece;
    }
    public void pickUp(){
        System.out.println(this.foundMessage);
        this.foundPiece = true;
    }

}
