import java.util.Scanner;
import java.util.ArrayList;


public class Main { //im wondering if theres a way to make a list of all the objects in each room. That way if someone is trying to go to an object it first checks that they're in the appropriate room first? I think it'd be more efficient to do that in main rather than have each object have a Boolean attribute that's 'inLivingRoom' or 'inBedroom'...

   static LivingRoom livingRoom = new LivingRoom();
   static Bedroom bedroom = new Bedroom();

   private ArrayList<String> inventory = new ArrayList<String>();
   private String location = ""; //string that says where you are. If you're already in a location you don't have to say "go to" like for cups? 

   private static ArrayList<String> commands = new ArrayList<String>();
   private static boolean commandRecognized = false;
   private static boolean objectRecognized = false;

   private static ArrayList<String> livingRoomObjects = new ArrayList<String>();
   private static ArrayList<String> bedroomObjects = new ArrayList<String>();

   /**
    * Method to add an item to the inventory
    * @param item the item being added to the inventory
    */
   private void inInventory(String item){
      inventory.add(item);
   }

   /**
    * Getter for inventory
    * @return the inventory list
    */
   public ArrayList<String> getInventory(){
      return this.inventory;
   }

   //private void removeInventory(String item){
    //  inventory.remove(item);
   //}

   public static void main (String[] args){
      Main gameMain = new Main();

      Boolean inLivingRoom = true;
      Boolean inBedroom = false;
      Boolean stillPlaying = true;

      commands.add("go to");
      commands.add("pick up");
      commands.add("use");
      commands.add("open");
      commands.add("look at");
      commands.add("look under");
      commands.add("look behind");
      commands.add("look around");
      commands.add("print inventory");
      commands.add("which room am I in");
      commands.add("Where am I");

      livingRoomObjects.add("cup");
      livingRoomObjects.add("table");
      livingRoomObjects.add("book");
      livingRoomObjects.add("cipher");
      livingRoomObjects.add("bookshelf");
      livingRoomObjects.add("couch");
      livingRoomObjects.add("box");
      livingRoomObjects.add("key"); // bedroom door key
      livingRoomObjects.add("bedroom door");
      livingRoomObjects.add("outside door");

      bedroomObjects.add("bed");
      bedroomObjects.add("nightstand");
      bedroomObjects.add("dresser");
      bedroomObjects.add("puzzle");
      bedroomObjects.add("mirror");
      bedroomObjects.add("key"); // outside door key


      
      System.out.println("****************************\nPOSSIBLE COMMANDS:\n****************************");
      for(String commands : commands){
         System.out.println("- " +commands);
      }
      System.out.println( "****************************\n");
      System.out.println("\nYou are locked inside a room. The room has two doors, the one you entered through and another that\nyou don't know where it leads. Both are locked. Inside the room with you is a table with three\ndifferent colored cups, a couch, and a bookshelf.");
      Scanner playGame = new Scanner(System.in);
      String inputLine = "";
      
      do{
         System.out.println("");
         inputLine = playGame.nextLine().toLowerCase();
         System.out.println("");

         

        

    
         //table/cup interaction
         if(inLivingRoom == true  &&  inputLine.contains("go to") && (inputLine.contains("table") || inputLine.contains("cup"))){
            gameMain.location = "table";
            System.out.println("you're at the table, there are three cups on top. A red cup, a blue cup, and a green cup.");
         }else if (inLivingRoom == false && inputLine.contains("table")){
            System.out.println("There is no table in this room.");
         }
         
         if(gameMain.location == "table"){
            if(inputLine.contains("pick up") && inputLine.contains("red cup")){
               livingRoom.getRedCup().pickUp();
               gameMain.inInventory("red cup note");
            } else if(inputLine.contains("pick up") && inputLine.contains("blue cup")){
               livingRoom.getBlueCup().pickUp();
               gameMain.inInventory("blue cup note");
            } else if(inputLine.contains("pick up") && inputLine.contains("green cup")){
               livingRoom.getGreenCup().pickUp();
               gameMain.inInventory("green cup note");
            } else if( inputLine.contains("look under") && inputLine.contains("table")){
               if(gameMain.inventory.contains("book")){
                livingRoom.getTable().readMessage();
                gameMain.inInventory("cipher");
               } else {
                  System.out.println("something feels weird but you don't know what. keep looking for clues.");
               }
            } 
         }


         
         
         //bookshelf interaction
         if(inLivingRoom == true &&  inputLine.contains("bookshelf") && inputLine.contains("go to") && gameMain.getInventory().contains("red cup note")){ //what about approaching the bookshelf if you haven't been to the cups yet.
            System.out.println("You're at the bookshelf. You notice there's one book that has it's spine turned in.");
            gameMain.location = "bookshelf";
         } else if(inLivingRoom == true && inputLine.contains("bookshelf") &&  inputLine.contains("go to")){
            System.out.println("Bookshelf looks weird, we dont know why. Keep looking around.");
            gameMain.location = "bookshelf";
         } else if (inLivingRoom == false && inputLine.contains("bookshelf")){
            System.out.println("There is no bookshelf in this room.");//no bookshelf in room 
         } else if (inLivingRoom == true && gameMain.getInventory().contains("book") && inputLine.contains("bookshelf")){
            System.out.println("You've already found the weird looking book, nothing else to see here.");
         }

         if(gameMain.location == "bookshelf"){
            if(inputLine.contains("book") && (inputLine.contains("pick up") || inputLine.contains("look at"))){
               gameMain.inInventory("book"); //put down book?
               livingRoom.getBookshelf().pickUpBook();
            } 
         } 

         

         
         //using the cipher
         if(inputLine.contains("use") && inputLine.contains("cipher") && gameMain.inventory.contains("cipher") && gameMain.inventory.contains("book")){
            System.out.println("You can now read the page in the book. It has two numbers on it: 3 and 1. It also says to look under the couch cushions..."); //cipher to read book
            gameMain.inInventory("book page");
         } 

         //couch interaction
         if(inLivingRoom == true && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            gameMain.location = "couch";
            System.out.println("You're at the couch");
          } else if (inLivingRoom == false && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You can't see a couch here.");
          }
         
          //lift cushions
         if(gameMain.location == "couch"){
            if(inputLine.contains("cushion") && (inputLine.contains("pick up")   || inputLine.contains("look under"))){
               livingRoom.getCouch().pickUpCushions();
               gameMain.inInventory("box");
            }
         }
        
   

         //box interaction
         if(inLivingRoom == true && livingRoom.getCouch().lifted == true && inputLine.contains("box") && (inputLine.contains("look at") || inputLine.contains("open"))){
            livingRoom.getBox().tryToOpen = true; //need to fix scanner issues here, need to take out scanner in box and get this to still work  
            while(livingRoom.getBox().tryToOpen){ 
               if(!(livingRoom.getBlueCup().foundCup == true && livingRoom.getGreenCup().foundCup == true)){
                  System.out.println("The box requires a 4 digit code. You don't have all the information needed to open it yet, keep looking around.");
                  livingRoom.getBox().tryToOpen = false;
               } else{
                  System.out.println("Enter the 4 digit code to open the box:" + "\n");
                  String codeTry = playGame.nextLine();
                  if(codeTry.equals(livingRoom.getBox().boxCode)){
                     System.out.println("You've opened the box! Inside is a key.");
                     gameMain.inInventory("key to bedroom");
                     livingRoom.getBox().tryToOpen = false;
                     livingRoom.getBox().open = true;
                  } else{
                     System.out.println("Not quite right, care to try again? \n"); // need a way for them to maybe leave and come back? this whole section needs a lot of work. 
                     String endTry = playGame.nextLine().trim();
                     if (endTry.contains("no")){ //this needs work. Need to slice the string and check for some sort of affirmative/negative statement and then proceed. Also how to do or statements in java? Google said || but that does not seem to be working.
                        livingRoom.getBox().tryToOpen = false;
                        livingRoom.getBox().open = true;
                        System.out.println("Ok, now what will you do? \n"); 
                     } else if (endTry.contains(livingRoom.getBox().boxCode)){
                        System.out.println("You've opened the box! Inside is a key. \n");
                        gameMain.inInventory("key to bedroom");
                        livingRoom.getBox().open = true;
                        livingRoom.getBox().tryToOpen = false;
                     }
                  }
               }
            }
         } else if (inLivingRoom == false && inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You can't see a box here.");
         }
      

         //key and bedroom door interaction
         if (inLivingRoom == true && livingRoom.getBox().open == true && (inputLine.contains("key") && inputLine.contains("pick up"))){
            System.out.println("You have picked up a door key");
            gameMain.inInventory("bedroom door key");
         } else if (inLivingRoom == true && !gameMain.inventory.contains("bedroom door key") && inputLine.contains("key")){
            System.out.println("You don't have any door keys yet.");
         }

         if(inLivingRoom == true && inputLine.contains("go to") && inputLine.contains("door")){
            System.out.println("Which door do you want to go to? Bedroom or outside\n");
            String doorChoice = playGame.nextLine();
            if (doorChoice.contains("bedroom")){
               System.out.println("\nYou approach the bedroom door.");
               gameMain.location = "bedroom door";
            } else{
               System.out.println("You approach the outside door.");
               gameMain.location = "outside door";
            }
         }

         if(gameMain.location == "bedroom door" && inputLine.contains("use") && inputLine.contains("key")){
            if (gameMain.getInventory().contains("bedroom door key")){
               inLivingRoom = false;
               inBedroom = true;
               System.out.println("You have now entered the bedroom. In here there's a bed, a nightstand, a mirror and a dresser with a puzzle on it");
            } else {
               System.out.println("You don't have the key to this the door yet. Try the other door. \n");
            }
         }

         //-----------

         //nightstand interaction
         if(inBedroom == true && inputLine.contains("nightstand") && (inputLine.contains("go to") || inputLine.contains("look at"))){
            System.out.println("You approach the nightstand. It has two drawers.");
            gameMain.location = "nightstand";
         }

         if(gameMain.location == "nightstand"){
            if(inputLine.contains("open") || inputLine.contains("look at")){
               if(inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
                  bedroom.getNightstand().open(1);
                  gameMain.inInventory("puzzle piece 1");
                  gameMain.inInventory("nightstand note");
               } else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("bottom")){
                  bedroom.getNightstand().open(2);
                  gameMain.inInventory("puzzle piece 3");
               } else {
               System.out.println("Specify which drawer you want to open");
               }
            }  
         } else if (inBedroom == false && inputLine.contains("nightstand")){
            System.out.println("There is no nightstand in this room.");
         }
         
           
      
         //dresser interaction

         if(inBedroom == true && inputLine.contains("dresser") && (inputLine.contains("go to") || inputLine.contains("look at"))){
            System.out.println("You approach the dresser. It has three drawers and a slightly unfinished puzzle on top that's missing three pieces.");
            gameMain.location = "dresser";
         }

         if (gameMain.location == "dresser"){
            if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
               bedroom.getDresser().open(1);
            } else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("middle")){
               bedroom.getDresser().open(2);
            }
            else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("3") || inputLine.contains("third") || inputLine.contains("three") || inputLine.contains("bottom")){
               bedroom.getDresser().open(3);
            } else if((inputLine.contains("open") || inputLine.contains("look"))){
               System.out.println("Specify which drawer you want to open");
            }
            
            if((inputLine.contains("place")|| inputLine.contains("put")) && inputLine.contains("piece")){
               if(gameMain.inventory.contains("puzzle piece 1")){
                  bedroom.getPuzzle().placePiece("puzzle piece 1");
               }
               if(gameMain.inventory.contains("puzzle piece 2")){
                  bedroom.getPuzzle().placePiece("puzzle piece 2");
               }
               if(gameMain.inventory.contains("puzzle piece 3")){
                  bedroom.getPuzzle().placePiece("puzzle piece 3");
               }
         } else if (inBedroom == false && inputLine.contains("puzzle")){
            System.out.println("There is no puzzle in this room.");
         }
         } else if (inBedroom == false && inputLine.contains("dresser")){
            System.out.println("There is no dresser in this room.");
         }
         
            

         //bed interaction

         if(inBedroom == true && inputLine.contains("bed") && (inputLine.contains("look at") || inputLine.contains("go to"))){
            System.out.println("You approach the bed.");
            gameMain.location = "bed";
         }

         if(gameMain.location == "bed"){
            if((inputLine.contains("look under") || inputLine.contains("pick up")) && (inputLine.contains("cover") || inputLine.contains("blanket") || inputLine.contains("sheets"))){
               bedroom.getBed().liftCovers();
               if((inputLine.contains("pick up") || inputLine.contains("look at")) && (inputLine.contains("note") || inputLine.contains("paper"))) {
                  bedroom.getBed().pickUp();
                  gameMain.inInventory("bed note");
               }
            }  
         } else if (inBedroom == false && inputLine.contains("bed")){
            System.out.println("There is no bed in this room.");
         } 
         
         


         

         //mirror interaction
      
         if(inputLine.contains("mirror") && (inputLine.contains("go to") || inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("you're now standing in front of the mirror");
            if(!bedroom.getPuzzle().getFlipped()){
               System.out.println("something looks off about the mirror to you but you can't quite tell what...keep looking around the room");
            } else if (inputLine.contains("mirror") && (inputLine.contains("look behind") || inputLine.contains("pick up"))){
               bedroom.getMirror().pickUp();
               gameMain.inInventory("key to outside");   
            }
         } 

         if (inLivingRoom == true && gameMain.getInventory().contains("outside door key") && inputLine.contains("key") && (inputLine.contains("use") || (inputLine.contains("unlock")))){
            System.out.println("Which door do you want to go to? Bedroom or outside");
            String doorChoice = playGame.nextLine();
            if (doorChoice.contains("bedroom")){
               System.out.println("You approach the bedroom door.");
               gameMain.location = "bedroom door";
            } else{
               System.out.println("You approach the outside door.");
               gameMain.location = "outside door";
            }
         }

         if(gameMain.location == "outside door"){
            if (gameMain.getInventory().contains("outside door key")){
               inLivingRoom = false;
               inBedroom = false;
               System.out.println("You've unlocked the door and stepped outside!");
            } else {
               System.out.println("You don't have the key to this the door yet.\n");
            }
         }

         if(livingRoom.getBedroomDoor().isLocked == false && inputLine.contains("go to") && inputLine.contains("living room")){
            inLivingRoom = true;
            inBedroom = false;
            System.out.println("You have now entered the living room.");
         }

         if(livingRoom.getBedroomDoor().isLocked == false && inputLine.contains("go to") && inputLine.contains("bedroom")){
            inLivingRoom = false;
            inBedroom = true;
            System.out.println("You have now entered the bedroom.");
         }
            


         //room location check

         if(inputLine.contains("where am i") || inputLine.contains("which room am i in")){
               if(inLivingRoom == true){
               System.out.println("You are currently in the living room.");
            } else if (inBedroom == true){
               System.out.println("You are currently in the bedroom.");
            }
            else{
               System.out.println("You are not in a room. You've escaped!");
            }
         }


         //look around
         if(inputLine.contains("look around")){
            if(inLivingRoom){
               System.out.println(livingRoom.getRoomMessage());
            } else if(inBedroom){
               System.out.println(bedroom.getRoomMessage());
            } else{
               System.out.println("You've escaped the house!");
            }
         }

         //print inventory
         if(inputLine.contains("print inventory") && gameMain.getInventory().size() > 0){
            System.out.println("****************************");
            System.out.println("INVENTORY:");
            System.out.println("****************************");

            for(String item : gameMain.getInventory()){
               System.out.println("- " + item);
            }
            
            System.out.println("****************************");
         } else if(inputLine.contains("print inventory") && gameMain.getInventory().size() == 0){
            System.out.println("Your inventory is empty.");
         }

         for(String command : commands){ //converts the list of commands into a string and checks if the inputLine contains any of them
            if(inputLine.contains(command)){
               commandRecognized = true;
               break;
            }
         }
         
         for(String object : livingRoomObjects){
            if(inputLine.contains(object)){
               objectRecognized = true;
               break;
            }
         }

         for(String object : bedroomObjects){
            if(inputLine.contains(object)){
               objectRecognized = true;
               break;
            }
         }
         
         if(commandRecognized == false){
            System.out.println("Your command is not recognized. Please try again.");
         }

         if(objectRecognized == false){
            System.out.println("There is no such object in this room. Please try again.");
         }

         if(inLivingRoom == false && inBedroom == false){
            stillPlaying = false;
         }
      } while (stillPlaying);

      System.out.println("Congrats! You've have escaped the room!");
      playGame.close();
   }

}
