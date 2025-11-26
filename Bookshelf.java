public class Bookshelf {//do we need bookshelf or book? does it matter?
    
    private Boolean foundClue = false;
    private String foundMessage = "No found message written";
    public Boolean foundLeadUpClues = false;

    public Bookshelf(){
        this.foundMessage = "Inside the book there is only one page with any writing on it. The page has two lines of text, the first is impossible to understand and says 'guerr bar oyhr terra', the second line is much more readable and says 'Look under the table..."; //we should include what the page says. 
        this.foundClue = false;
        this.foundLeadUpClues = false; //there may be a way to have a method in each object that asks just about if the necessary object before it has been found. If it has, then you can find this one, otherwise not. 

    }

    public void approachBookshelf(){
        if (this.foundLeadUpClues){
            System.out.println("You notice there's a book with it's spine facing in...");
        } else{
            System.out.println("You notice something weird about the bookshelf but you can't quite tell what just yet. Maybe keep looking around...");
        }
    }

    public Boolean getFoundClue(){
        return this.foundClue;
    }

    public void pickUpBook(){
        System.out.println(this.foundMessage);
        this.foundClue = true;
    }

}
