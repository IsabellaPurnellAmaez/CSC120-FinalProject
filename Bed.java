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
            System.out.println("You have lifted the covers."); // add indication of a clue
        } else {
            System.out.println("The covers are already lifted.");
        }
    }

    public void pickUp(){
        if(lifted && clueFound){
            clueFound = true;
            System.out.println("You found a clue under the covers!");
        } else if(!lifted){
            System.out.println("You need to lift the covers first.");
        } else {
            System.out.println("You have already found the clue under the covers.");
        }
    }

}
