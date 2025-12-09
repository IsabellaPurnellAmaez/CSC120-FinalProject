import java.util.Scanner;


public class Main { //im wondering if theres a way to make a list of all the objects in each room. That way if someone is trying to go to an object it first checks that they're in the appropriate room first? I think it'd be more efficient to do that in main rather than have each object have a Boolean attribute that's 'inLivingRoom' or 'inBedroom'...

   static LivingRoom livingRoom = new LivingRoom();
   static Bedroom bedroom = new Bedroom();
   
   public void checkBookshelf(){ //need a bunch of methods to access object methods and reset booleans about whether or not clues can be accessed yet
      if(livingRoom.redCup.foundCup){ 
         livingRoom.bookshelf.foundBook = true;
      }
      livingRoom.bookshelf.approachBookshelf();
   }

    public static void main (String[] args){ //idk what this duplicate modifier error means. Is it bc the object is named Main as well? 
      Boolean inLivingRoom = true;
      Boolean inBedroom = false;
      Boolean stillPlaying = true;
   
      System.out.println("\nYou are locked inside a room. The room has two doors, the one you entered through and another that\nyou don't know where it leads. Both are locked. Inside the room with you is a table with three\ndifferent colored cups, a bookshelf, and a couch.");
      Scanner playGame = new Scanner(System.in);
      String inputLine = "";
      
      do{
         System.out.println("");
         inputLine = playGame.nextLine();
         System.out.println("");
         System.out.println(inLivingRoom);
        //cups interaction
         if(inLivingRoom == true && inputLine.contains("cup") && (inputLine.contains("approach") ||  inputLine.contains("go to"))){ //starting to write code interacting with the player. Not sure if it should be in main or in the methods above...
            System.out.println("You approach the cups. There is a red cup, a blue cup, and a green cup. \n");   
            if(inputLine.contains("lift") || inputLine.contains("pick up")){
               if(inputLine.contains("red")){ 
                  livingRoom.redCup.pickUp();
               } else if(inputLine.contains("blue")){
                  livingRoom.blueCup.pickUp();
               } else if(inputLine.contains("green")){
                  livingRoom.greenCup.pickUp();
               } else{
                  System.out.println("What color cup do you want to pick up? red, blue, or green?\n");
                  String colorChoice = playGame.nextLine();
                  System.out.println("");
                  if(colorChoice.contains("red")){ 
                     livingRoom.redCup.pickUp();
                  } else if(colorChoice.contains("blue")){
                     livingRoom.blueCup.pickUp();
                  } else if(colorChoice.contains("green")){
                     livingRoom.greenCup.pickUp();
                  }
               }
            }
         } else if (inLivingRoom == false && inputLine.contains("cup")){
            System.out.println("There are no cups in this room.");
         } 

         //bookshelf interaction
         if(inLivingRoom == true && livingRoom.redCup.foundCup == true && inputLine.contains("bookshelf") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            livingRoom.bookshelf.approachBookshelf();
            if(inputLine.contains("book") && (inputLine.contains("pick up") || inputLine.contains("look at"))){
               livingRoom.bookshelf.pickUpBook();
            }
         } else if(inLivingRoom == true && inputLine.contains("book") && inputLine.contains("use")){
            System.out.println("You can now read the page in the book. It has two numbers on it: 3 and 1");
         } else if (inLivingRoom == false && inputLine.contains("bookshelf")){
            System.out.println("There is no bookshelf in this room.");
         }
         //there may be bugs here. said we had already been to bookshelf and then printed the book message again...

         //table interaction
         if(inLivingRoom == true && livingRoom.bookshelf.foundBook == true && inputLine.contains("table") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            livingRoom.table.readMessage(); // put in a use cipher method later******
         } else if (inLivingRoom == false && inputLine.contains("table")){
            System.out.println("There is no table in this room.");
         }

         //couch interaction
         if(inLivingRoom == true && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            livingRoom.couch.pickUpCushions();
         } else if (inLivingRoom == false && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You can't see a couch here.");
         }

         //box interaction
         if(inLivingRoom == true && livingRoom.couch.lifted == true && livingRoom.blueCup.foundCup == true && livingRoom.greenCup.foundCup == true && inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("open"))){
            livingRoom.box.openBox(); //need to fix scanner issues here, need to take out scanner in box and get this to still work  
         } else if (inLivingRoom == false && inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You can't see a box here.");
         }

         //key and bedroom door interaction
         if(inLivingRoom == true && livingRoom.box.open == true && inputLine.contains("key") && (inputLine.contains("unlock") || inputLine.contains("use"))){
            if(inputLine.contains(livingRoom.bedroomDoorKey.description)){
               System.out.println("You've now unlocked the bedroom door. You are now in the bedroom?");
               inLivingRoom = false;
               inBedroom = true;
            } else {
               System.out.println("You don't have a key that fits that door.");
            }
         } else if (inLivingRoom == true && inputLine.contains("key") && !inputLine.contains(livingRoom.bedroomDoorKey.description)){
            System.out.println("What door do you want to open? Bedroom or outside.");
         } else if (inLivingRoom == false && inputLine.contains("key")){
            System.out.println("The door has already been unlocked.");
         }
         //-----------

         //nightstand interaction
         if(inBedroom == true && inputLine.contains("nightstand") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You approach the nightstand. It has two drawers.");
            if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
               bedroom.nightstand.open(1);
            } else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("bottom")){
               bedroom.nightstand.open(2);
            }
         }else if (inBedroom == false && inputLine.contains("nightstand")){
            System.out.println("There is no nightstand in this room.");
         }
         

         //dresser interaction

         if(inBedroom == true && inputLine.contains("dresser") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You approach the dresser. It has three drawers.");
            if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
               bedroom.dresser.open(1);
            } else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("middle")){
               bedroom.dresser.open(2);
            }
            else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("3") || inputLine.contains("third") || inputLine.contains("three") || inputLine.contains("bottom")){
               bedroom.dresser.open(3);
            }
         } else if (inBedroom == false && inputLine.contains("dresser")){
            System.out.println("There is no dresser in this room.");
         }

         //bed interaction

         if(inBedroom == true && inputLine.contains("bed") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            System.out.println("You approach the bed.");
            if((inputLine.contains("lift") || inputLine.contains("pick up")) && (inputLine.contains("covers") || inputLine.contains("blanket") || inputLine.contains("sheets"))){
               bedroom.bed.liftCovers();
               if((inputLine.contains("pick up") || inputLine.contains("look at")) && (inputLine.contains("note") || inputLine.contains("paper"))) {
                  bedroom.bed.pickUp();
               }
            }  
         } else if (inBedroom == false && inputLine.contains("bed")){
            System.out.println("There is no bed in this room.");
         }

         //









         //room location check

         if(inputLine.contains("room") && inputLine.contains("in") && (inputLine.contains("which") || inputLine.contains("what")) || inputLine.contains("where am i")){
                     if(inLivingRoom == true){
               System.out.println("You are currently in the living room.");
            } else if (inBedroom == true){
               System.out.println("You are currently in the bedroom.");
            }
            else{
               System.out.println("You are not in a room. You've escaped!");
            }
         }







         




         












































   












         //-----------
      } while (stillPlaying);

      
      if(inLivingRoom == false && inBedroom == false){
         stillPlaying = false;
         System.out.println("Congrats! You've have escaped the room!");
         playGame.close();
      }
   }

}