import java.util.Scanner;
import java.util.ArrayList;


public class Main { //im wondering if theres a way to make a list of all the objects in each room. That way if someone is trying to go to an object it first checks that they're in the appropriate room first? I think it'd be more efficient to do that in main rather than have each object have a Boolean attribute that's 'inLivingRoom' or 'inBedroom'...

   static LivingRoom livingRoom = new LivingRoom();
   static Bedroom bedroom = new Bedroom();

   private ArrayList<Object> inventory = new ArrayList<Object>();
   private String location = ""; //string that says where you are. If you're already in a location you don't have to say "go to" like for cups? 


   private void inInventory(String item){
      inventory.add(item);
   }

   //private void removeInventory(String item){
    //  inventory.remove(item);
   //}

    public static void main (String[] args){
      Main gameMain = new Main();

      Boolean inLivingRoom = true;
      Boolean inBedroom = false;
      Boolean stillPlaying = true;
   
      System.out.println("\nYou are locked inside a room. The room has two doors, the one you entered through and another that\nyou don't know where it leads. Both are locked. Inside the room with you is a table with three\ndifferent colored cups, a couch, and a bookshelf.");
      Scanner playGame = new Scanner(System.in);
      String inputLine = "";
      
      do{
         System.out.println("");
         inputLine = playGame.nextLine().toLowerCase();
         System.out.println("");
         //System.out.println(inLivingRoom);
         //System.out.println(inBedroom);


        //cups interaction --> fix b/c you have to keep saying "go to cups" if you want to pick up another cup (also you can pick up the same cup over and over again. I think we want to be able to pick it up once and then have the note in an inventory)
        
        //go to cups
        if(inLivingRoom == true && inputLine.contains("cup") && (inputLine.contains("approach") ||  inputLine.contains("go to"))){ //starting to write code interacting with the player. Not sure if it should be in main or in the methods above...
            gameMain.location = "cups";
            System.out.println("You approach the cups. There is a red cup, a blue cup, and a green cup. \n");   
            //System.out.println("Which cup would you like to pick up?"); // idk if we need this line? I know we have to get them to pick up the cups but I wonder if there's a less overt way to prompt the player
            System.out.println("");
         }else if (inLivingRoom == false && inputLine.contains("cup")){
            System.out.println("There are no cups in this room.");
         }
         
         //interact with cups 
         if(gameMain.location == "cups"){ 
            String nextLine = playGame.nextLine(); //why change this variable? why not use inputLine? Is it just for clarity?
            if(nextLine.contains("cups") && (inputLine.contains("approach") ||  inputLine.contains("go to"))){
               System.out.println("You're already at the cups");
            }
            if(nextLine.contains("lift") || nextLine.contains("pick up") || nextLine.contains("look at")||nextLine.contains("go to")){
               if(nextLine.contains("red")){ 
                  livingRoom.redCup.pickUp();
                  gameMain.inInventory("red cup note");
               } else if(nextLine.contains("blue")){
                  livingRoom.blueCup.pickUp();
                  gameMain.inInventory("blue cup note");
               } else if(nextLine.contains("green")){
                  livingRoom.greenCup.pickUp();
                  gameMain.inInventory("green cup note");
               } else{
                  System.out.println("What color cup do you want to pick up? red, blue, or green?\n");
                  String colorChoice = playGame.nextLine();
                  System.out.println("");
                  if(colorChoice.contains("red")){ 
                     livingRoom.redCup.pickUp();
                     gameMain.inInventory("red cup note");
                  } else if(colorChoice.contains("blue")){
                     livingRoom.blueCup.pickUp();
                     gameMain.inInventory("blue cup note");
                  } else if(colorChoice.contains("green")){
                     livingRoom.greenCup.pickUp();
                     gameMain.inInventory("green cup note");
                  }
               }
            }
         } 
    

         

         //bookshelf interaction
         if(inLivingRoom == true &&  inputLine.contains("bookshelf") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){ //what about approaching the bookshelf if you haven't been to the cups yet. 
             if(!livingRoom.redCup.foundCup){
               System.out.println("Bookshelf looks weird, we dont know why. Keep looking around.");
             } else{
               livingRoom.bookshelf.approachBookshelf();
               String nextLine = playGame.nextLine();
               System.out.println("\n");
               if(nextLine.contains("book") && (nextLine.contains("pick up") || nextLine.contains("look at"))){
                  gameMain.inInventory("book"); //put down book?
                  livingRoom.bookshelf.pickUpBook();
               } 
            }
         } else if (inLivingRoom == false && inputLine.contains("bookshelf")){
               System.out.println("There is no bookshelf in this room.");//no bookshelf in room
         }
      
         //using the cipher
         if(inputLine.contains("use") && inputLine.contains("cipher") && gameMain.inventory.contains("cipher") && gameMain.inventory.contains("book")){
            System.out.println("You can now read the page in the book. It has two numbers on it: 3 and 1"); //cipher to read book
         } 
            


         //table interaction
         if(inLivingRoom == true && livingRoom.bookshelf.foundBook == true && inputLine.contains("table") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            gameMain.inInventory("cipher");
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
            livingRoom.box.tryToOpen = true; //need to fix scanner issues here, need to take out scanner in box and get this to still work  
            while(livingRoom.box.tryToOpen){ 
               System.out.println("Enter the 4 digit code to open the box:");
               String codeTry = playGame.nextLine();
               if(codeTry.equals(livingRoom.box.boxCode)){
                     System.out.println("You've opened the box! Inside is a key.");
                     livingRoom.box.tryToOpen = false;
                     livingRoom.box.open = true;
               }  else{
                     System.out.println("Not quite right, care to try again?"); // need a way for them to maybe leave and come back? this whole section needs a lot of work. 
                     String endTry = playGame.nextLine().trim();
                     if (endTry.contains("no") || endTry.contains("No")){ //this needs work. Need to slice the string and check for some sort of affirmative/negative statement and then proceed. Also how to do or statements in java? Google said || but that does not seem to be working.
                        livingRoom.box.tryToOpen = false;
                        livingRoom.box.open = true;
                        System.out.println("Ok, now what will you do?"); 
                     } else if (endTry.contains(livingRoom.box.boxCode)){
                        System.out.println("You've opened the box! Inside is a key.");
                        livingRoom.box.open = true;
                        livingRoom.box.tryToOpen = false;
                     }
               }
            }
         } else if (inLivingRoom == false && inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You can't see a box here.");
         }

         //key and bedroom door interaction
         if(inLivingRoom == true && livingRoom.box.open == true && inputLine.contains("key") && inputLine.contains("bedroom") &&(inputLine.contains("unlock") || inputLine.contains("use"))){
            System.out.println("What key do you want to use? Bedroom or outside?");
            String keyInput = playGame.nextLine();
            if(keyInput.equals(livingRoom.bedroomDoorKey.description)){ 
                  if(livingRoom.bedroomDoorKey.usage.equals(livingRoom.bedroomDoor.name)){
                     livingRoom.bedroomDoor.isLocked = false;
                  } else {
                     livingRoom.bedroomDoor.isLocked = true;
                     System.out.println("This key does not unlock " + livingRoom.bedroomDoor.name);
                  }
            } else {
                  System.out.println("You don't have that key for this door.");
            }
         } else if (inLivingRoom == true && inputLine.contains("key")){
            System.out.println("What door do you want to open? Bedroom or outside.");
            String doorChoice = playGame.nextLine();
            System.out.println("");
            if (doorChoice.contains("bedroom")){
               inLivingRoom = false;
               inBedroom = true;
               System.out.println("You have now entered the bedroom. In here there's a bed, a nightstand, a mirror and a dresser with a puzzle on it");
            } else {
               System.out.println("You don't have the key to this the door yet.");
            }
         } else if (inLivingRoom == false && inputLine.contains("key")){
            System.out.println("The door has already been unlocked.");
         }

         //-----------

         //nightstand interaction
         if(inBedroom == true && inputLine.contains("nightstand") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You approach the nightstand. It has two drawers.");
            if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
               bedroom.nightstand.open(1);
               gameMain.inInventory("puzzle piece 1");
               gameMain.inInventory("nightstand note");
            } else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("bottom")){
               bedroom.nightstand.open(2);
               gameMain.inInventory("puzzle piece 3");
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
         

         //puzzle interaction

         if((inputLine.contains("place")|| inputLine.contains("put")) && inputLine.contains("piece")){
               if(gameMain.inventory.contains("puzzle piece 1")){
               }
         } else if (inBedroom == false && inputLine.contains("puzzle")){
            System.out.println("There is no puzzle in this room.");
         }

         //mirror interaction

         if(inputLine.contains("mirror") && (inputLine.contains("go to") || inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("you're now standing in front of the mirror");
            if(!bedroom.puzzle.getFlipped()){
               System.out.println("something looks off about the mirror to you but you can't quite tell what...keep looking around the room");
            } else if (inputLine.contains("mirror") && (inputLine.contains("look behind") || inputLine.contains("move") || inputLine.contains("pick up"))){
               bedroom.mirror.pickUp();
               if (inputLine.contains("key") && inputLine.contains("pick up")){
                  gameMain.inInventory("key to outside");
               }
               }
         }
            

         














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
