public class Bed {
    boolean lifted;
    boolean clueFound;

    public Bed(){
        this.lifted = false;
        this.clueFound = false;
    }

    public void liftCovers(){
        if(!lifted){
            lifted = true;
            clueFound = true;
            System.out.println("You have lifted the covers."); // add clue
        } else {
            System.out.println("The covers are already lifted.");
        }
    }
}
