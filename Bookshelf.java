public class Bookshelf {//do we need bookshelf or book? does it matter?
    
    public Boolean foundBook = false;
    private String foundBookMessage = "No found message written";

    public Bookshelf(){
        this.foundBookMessage = "Inside the book there is only one page with any writing on it. The page has two lines of text, the first is impossible to understand and says 'guerr bar oyhr terra' \n The second line is much more readable and says 'Look under the table...";
    }

    public void approachBookshelf(){
        if (!this.foundBook){
            System.out.println("There's one book that has it's spine turned in.");
        } else{
            System.out.println("You've already been to the bookshelf, there's no more to see here.");
        }
    }

    public void pickUpBook(){
        System.out.println(this.foundBookMessage);
        this.foundBook = true;
    }

}
