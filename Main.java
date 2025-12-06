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
         } else if (inLivingRoom == false && inputLine.contains("cup")){
            System.out.println("There are no cups in this room.");
         } 

         //bookshelf interaction
         if(inLivingRoom == true && livingRoom.redCup.foundCup == true && inputLine.contains("bookshelf") && inputLine.contains("approach") || inputLine.contains("look at")){
            livingRoom.bookshelf.approachBookshelf();
            if(inputLine.contains("book") && inputLine.contains("pick up") || inputLine.contains("look at")){
               livingRoom.bookshelf.pickUpBook();
               //add print statement for clue
            }
         } else if (inLivingRoom == false && inputLine.contains("bookshelf")){
            System.out.println("There is no bookshelf in this room.");
         }

         //table interaction
         if(inLivingRoom == true && livingRoom.bookshelf.foundBook == true &&inputLine.contains("table") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            livingRoom.table.readMessage();
         } else if (inLivingRoom == false && inputLine.contains("table")){
            System.out.println("There is no table in this room.");
         }

         //couch interaction
         if(inLivingRoom == true && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            livingRoom.couch.pickUpCushions();
         } else if (inLivingRoom == false && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You can't see a couch here.");
         }

         //box interaction
         if(inLivingRoom == true && livingRoom.couch.lifted == true &&inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            livingRoom.box.pickUp();
         } else if (inLivingRoom == false && inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You can't see a box here.");
         }

         //key and bedroom door interaction
         if(inLivingRoom = true && livingRoom.box.open == true && inputLine.contains("key") && (inputLine.contains("unlock") || inputLine.contains("use"))){
            if(inputLine.contains(livingRoom.bedroomDoorKey.description)){
               System.out.println("You've now unlocked the bedroom door. You are now in the bedroom?");
               inLivingRoom = false;
               inBedroom = true;
            } else {
               System.out.println("You don't have a key that fits that door.");
            }
         } else if (inLivingRoom == false){
            System.out.println("The door has already been unlocked.");
         }


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


