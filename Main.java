import java.util.Scanner;


public class Main { //im wondering if theres a way to make a list of all the objects in each room. That way if someone is trying to go to an object it first checks that they're in the appropriate room first? I think it'd be more efficient to do that in main rather than have each object have a Boolean attribute that's 'inLivingRoom' or 'inBedroom'...

   static LivingRoom livingRoom = new LivingRoom();
   static Bedroom bedroom = new Bedroom();
   
   public void checkBookshelf(){ //need a bunch of methods to access object methods and reset booleans about whether or not clues can be accessed yet
      if(livingRoom.redCup.foundCup){ 
         livingRoom.bookshelf.foundClue = true;
      }
      livingRoom.bookshelf.approachBookshelf();
   }

    public static void main (String[] args){ //idk what this duplicate modifier error means. Is it bc the object is named Main as well? 
      Boolean inLivingRoom = true;
      Boolean inBedroom = false;
      Boolean stillPlaying = true;
   
      System.out.println("You are locked inside a room. The room has two doors, the one you entered through and another that you don't know where it leads. Both are locked. Inside the room with you is a table with three different colored cups, a bookshelf, and a couch.");
      Scanner playGame = new Scanner(System.in);
      String inputLine = "";
      
      do{
         inputLine = playGame.nextLine();
         //cups interaction
         if(inLivingRoom == true && inputLine.contains("cup") && (inputLine.contains("lift") || inputLine.contains("pick up"))){ //starting to write code interacting with the player. Not sure if it should be in main or in the methods above...
            if(inputLine.contains("red")){ 
               livingRoom.redCup.pickUp();
            } else if(inputLine.contains("blue")){
               livingRoom.blueCup.pickUp();
            } else if(inputLine.contains("green")){
               livingRoom.greenCup.pickUp();
            } else {
               System.out.println("What color cup do you want to pick up? red, blue, or green?");
               if(inputLine.contains("red")){ 
                  livingRoom.redCup.pickUp();
               } else if(inputLine.contains("blue")){
                  livingRoom.blueCup.pickUp();
               } else if(inputLine.contains("green")){
                  livingRoom.greenCup.pickUp();
               }
            }
         } else if (inLivingRoom == false && inputLine.contains("cup") && (inputLine.contains("lift") || inputLine.contains("pick up"))){
            System.out.println("You can't see any cups here.");
         } 

         //bookshelf interaction
         if(inLivingRoom == true && inputLine.contains("booksheld") && inputLine.contains("approach") || inputLine.contains("look at")){
            livingRoom.bookshelf.approachBookshelf();
            //add print statement saying smthn abt book
            if(inputLine.contains("book") && inputLine.contains("pick up") || inputLine.contains("look at")){
               livingRoom.bookshelf.pickUpBook();
               //add print statement for clue
            }
         } else if (inLivingRoom == false && inputLine.contains("booksheld") && inputLine.contains("approach") || inputLine.contains("look at")){
            System.out.println("You can't see a bookshelf here.");
         }

         //table interaction




























         //-----------










         

















         //-----------
      } while (stillPlaying);


      if(inLivingRoom == false && inBedroom == false){
         stillPlaying = false;
         System.out.println("Congrats! You've haved escaped the room!");
         playGame.close();
      }
   }

}


