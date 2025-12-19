import java.util.Scanner;
import java.util.ArrayList;


public class Main { 
   
   //set up the rooms:
   static LivingRoom livingRoom = new LivingRoom();
   static Bedroom bedroom = new Bedroom();

   private ArrayList<String> inventory = new ArrayList<String>(); //string of all the objects you've already collected
   private String location = ""; //string that says where you are. *********in "where am i" add location in room**********

   //valid commands and objects that the user can say
   private static ArrayList<String> commands = new ArrayList<String>();
   private static boolean commandRecognized = false;
   private static boolean objectRecognized = false;

   //objects in the rooms
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

      //starting location and boolean of whether you're still playing or not
      Boolean inLivingRoom = true;
      Boolean inBedroom = false;
      Boolean stillPlaying = true;

      //list of valid commands
      commands.add("go to");
      commands.add("pick up");
      commands.add("use");
      commands.add("open");
      commands.add("look at");
      commands.add("look under");
      commands.add("look behind");
      commands.add("flip");
      commands.add("look around");
      commands.add("print inventory");
      commands.add("which room am I in");
      commands.add("Where am I");

      //list of objects in the living room
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

      //list of objects in the bedroom
      bedroomObjects.add("bed");
      bedroomObjects.add("nightstand");
      bedroomObjects.add("dresser");
      bedroomObjects.add("puzzle");
      bedroomObjects.add("mirror");
      bedroomObjects.add("key"); // outside door key


      //starting game messages. Prints out all the valid commands and then the game introductions
      System.out.println("****************************\nPOSSIBLE COMMANDS:\n****************************");
      for(String commands : commands){
         System.out.println("- " +commands);
      }
      System.out.println( "****************************\n");
      System.out.println("\nyou are locked inside a room. The room has two doors, the one you entered through and another that\nyou don't know where it leads. both are locked. inside the room with you is a table with three\ndifferent colored cups, a couch, and a bookshelf.");
      Scanner playGame = new Scanner(System.in);
      String inputLine = "";
      
      do{
         System.out.println("");
         inputLine = playGame.nextLine().toLowerCase(); //convert all input strings to lower case 
         System.out.println("");
    
         //table/cup interaction
         if(inLivingRoom == true  &&  inputLine.contains("go to") && (inputLine.contains("table") || inputLine.contains("cup"))){ //going to the table
            gameMain.location = "table";
            System.out.println("you're at the table, there are three cups on top. a red cup, a blue cup, and a green cup.");
         } else if (inLivingRoom == false && inputLine.contains("table")){
            System.out.println("there is no table in this room.\n");
         }
         
         //pick up cups 
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
            } else if( inputLine.contains("look under") && inputLine.contains("table")){ //get the cipher 
               if(gameMain.inventory.contains("book")){
                livingRoom.getTable().readMessage();
                gameMain.inInventory("cipher");
               } else {
                  System.out.println("something feels weird but you don't know what. keep looking for clues.");
               }
            } 
         }

         //using the cipher
         if(inputLine.contains("use") && inputLine.contains("cipher") && gameMain.inventory.contains("cipher") && gameMain.inventory.contains("book")){
            System.out.println("you can now read the page in the book. it has two numbers on it: 3 and 1. it also says to look under the couch cushions..."); //cipher to read book
            gameMain.inInventory("book page");
         } 
         
         //bookshelf interaction
         if(inLivingRoom == true &&  inputLine.contains("bookshelf") && inputLine.contains("go to") && gameMain.getInventory().contains("red cup note")){ //what about approaching the bookshelf if you haven't been to the cups yet.
            System.out.println("you're at the bookshelf. you notice there's one book that has it's spine turned in.");
            gameMain.location = "bookshelf";
         } else if(inLivingRoom == true && inputLine.contains("bookshelf") &&  inputLine.contains("go to")){
            System.out.println("the bookshelf looks weird, we dont know why. keep looking around.");
            gameMain.location = "bookshelf";
         } else if (inLivingRoom == false && inputLine.contains("bookshelf")){
            System.out.println("there is no bookshelf in this room.\n");//no bookshelf in room 
         } else if (inLivingRoom == true && gameMain.getInventory().contains("book") && inputLine.contains("bookshelf")){
            System.out.println("you've already found the weird looking book, nothing else to see here.");
         }

         //pick up book
         if(gameMain.location == "bookshelf"){
            if(inputLine.contains("book") && (inputLine.contains("pick up") || inputLine.contains("look at"))){
               gameMain.inInventory("book"); //put down book?
               livingRoom.getBookshelf().pickUpBook();
            } 
         } 

         //couch interaction
         if(inLivingRoom == true && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            gameMain.location = "couch";
            System.out.println("you're at the couch");
          } else if (inLivingRoom == false && inputLine.contains("couch") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("you can't see a couch here.");
          }
         
          //lift cushions
         if(gameMain.location == "couch" && inputLine.contains("cushion") && (inputLine.contains("pick up")   || inputLine.contains("look under"))){
            livingRoom.getCouch().pickUpCushions();
            gameMain.inInventory("box");
         }
   

         //box interaction
         if(inLivingRoom == true && livingRoom.getCouch().getLifted() == true && inputLine.contains("box") && (inputLine.contains("look at") || inputLine.contains("open") || inputLine.contains("unlock"))){
            livingRoom.getBox().tryToOpen = true;   
            while(livingRoom.getBox().tryToOpen){ 
               if(!(livingRoom.getBlueCup().getFoundCup() == true && livingRoom.getGreenCup().getFoundCup() == true)){  //if try to open box w/out all the necessary info
                  System.out.println("the box requires a 4 digit code. you don't have all the information needed to open it yet, keep looking around.");
                  livingRoom.getBox().tryToOpen = false;
               } else{
                  System.out.println("enter the 4 digit code to open the box: (hint, start with the 3...)" + "\n"); //input code
                  String codeTry = playGame.nextLine();
                     if(codeTry.equals(livingRoom.getBox().boxCode)){
                        System.out.println("\nyou've opened the box! inside is a key.");
                        gameMain.inInventory("key to bedroom");
                        livingRoom.getBox().tryToOpen = false;
                        livingRoom.getBox().open = true;
                     } else{
                        Boolean stillTrying = true;
                        while(stillTrying){ //loop to keep trying codes 
                           System.out.println("\nnot quite right, care to try again? \n");    
                           String endTry = playGame.nextLine().trim();
                           if (endTry.contains("no")){ 
                              livingRoom.getBox().open = true;
                              System.out.println("ok, now what will you do? \n"); 
                              stillTrying = false;
                           } else if (endTry.contains(livingRoom.getBox().boxCode)){
                              System.out.println("\nyou've opened the box! inside is a key. \n");
                              gameMain.inInventory("key to bedroom");
                              livingRoom.getBox().open = true;
                              livingRoom.getBox().tryToOpen = false;
                              stillTrying = false;
                        }
                     }
                  }       
               }
            }
         } else if (inLivingRoom == false && inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("you can't see a box here.");
         }


         //nightstand interaction
         if(inBedroom == true && inputLine.contains("nightstand") && (inputLine.contains("go to") || inputLine.contains("look at"))){
            System.out.println("You approach the nightstand. It has two drawers.");
            gameMain.location = "nightstand";
         }

         //opening the nightstand drawer
         if(gameMain.location == "nightstand"){
            if(inputLine.contains("open") || inputLine.contains("look at")){
               if(inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
                  bedroom.getNightstand().open(1);
                  gameMain.inInventory("puzzle piece 1");
                  gameMain.inInventory("nightstand note");
               }else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("bottom")){
                  bedroom.getNightstand().open(2);
                  Boolean openNightstand = true;
                  while(openNightstand){ 
                     if(!(gameMain.inventory.contains("top dresser drawer note: SC") && gameMain.inventory.contains("bed note: TUK"))){
                        System.out.println("this drawer needs a 5 letter code to open. you don't have all the information needed to open it yet, keep looking around.");
                        openNightstand = false;
                     } else{
                        System.out.println("enter the 5 letter code to open the box: " + "\n");
                        String codeTry = playGame.nextLine();
                        if(codeTry.equals("stuck")){
                           System.out.println("you've opened the drawer and found the final puzzle piece");
                           gameMain.inInventory("puzzle piece 3");
                           openNightstand = false;
                        } else{
                           Boolean stillTrying = true;
                           while(stillTrying){
                              System.out.println("not quite right, care to try again? \n");    
                              String endTry = playGame.nextLine().trim();
                              if (endTry.contains("no")){ 
                                 openNightstand = false;
                                 System.out.println("ok, now what will you do? \n"); 
                                 stillTrying = false;
                              } else if (endTry.equals("stuck")){
                                 System.out.println("you've opened the drawer and found the final puzzle piece \n");
                                 gameMain.inInventory("puzzle piece 3");
                                 openNightstand = false;
                                 stillTrying = false;
                              }
                           }
                        }       
                     }
                  }
                  
               } else {
               System.out.println("specify which drawer you want to open");
               }
            }  
         } else if (inBedroom == false && inputLine.contains("nightstand")){
            System.out.println("there is no nightstand in this room.\n");
         }
         

         //dresser interaction

         if(inBedroom == true && (inputLine.contains("dresser") || inputLine.contains("puzzle")) && (inputLine.contains("go to") || inputLine.contains("look at"))){
            System.out.println("you approach the dresser. it has three drawers and a slightly unfinished puzzle on top that's missing three pieces.");
            gameMain.location = "dresser";
         } else if (inBedroom == false && inputLine.contains("puzzle")){
            System.out.println("there is no puzzle in this room.\n");
         } else if (inBedroom == false && inputLine.contains("dresser")){
            System.out.println("there is no dresser in this room.\n");
         }

         //opening dresser drawers
         if (gameMain.location == "dresser"){
            if((inputLine.contains("open") ) && inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
               bedroom.getDresser().open(1);
               gameMain.inInventory("top dresser drawer note: SC");
            } else if((inputLine.contains("open") ) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("middle")){
               bedroom.getDresser().open(2);
               gameMain.inInventory("middle dresser drawer note: check under the covers of the bed");
            }
            else if((inputLine.contains("open") ) && inputLine.contains("3") || inputLine.contains("third") || inputLine.contains("three") || inputLine.contains("bottom")){
               bedroom.getDresser().open(3);
               gameMain.inInventory("puzzle piece 2");
            } else if ((inputLine.contains("open")  )){
               System.out.println("specify which drawer you want to open");
            }
            
            //placing puzzle pieces
            if(((inputLine.contains("place")|| inputLine.contains("put") || inputLine.contains("use")) && inputLine.contains("piece")) || (inputLine.contains("finish") && inputLine.contains("puzzle") )){
               if(gameMain.inventory.contains("puzzle piece 1")){
                  bedroom.getPuzzle().placePiece("puzzle piece 1");
               }
               if(gameMain.inventory.contains("puzzle piece 2")){
                  bedroom.getPuzzle().placePiece("puzzle piece 2");
               }
               if(gameMain.inventory.contains("puzzle piece 3")){
                  bedroom.getPuzzle().placePiece("puzzle piece 3");
               }
            }

            //flipping the puzzle
            if(inputLine.contains("flip")){  
               bedroom.getPuzzle().flipPuzzle();
            }
         }
         
         //bed interaction
         if(inBedroom == true && inputLine.contains("bed") && !inputLine.contains("bedroom") && (inputLine.contains("look at") || inputLine.contains("go to"))){
            System.out.println("you approach the bed.");
            gameMain.location = "bed";
         }

         //look under bed
         if(gameMain.location == "bed"){
            if((inputLine.contains("look under") || inputLine.contains("pick up")) && (inputLine.contains("cover") || inputLine.contains("blanket") || inputLine.contains("sheet"))){
               bedroom.getBed().liftCovers();
               gameMain.inInventory("bed note: TUK");
               } 
         } else if (inBedroom == false && inputLine.contains("bed") && !inputLine.contains("bedroom")){
            System.out.println("there is no bed in this room.\n");
         } 
          

         //mirror interaction
         if(inputLine.contains("mirror") && (inputLine.contains("go to") || inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("you're now standing in front of the mirror");
            gameMain.location = "mirror";
         }

         //look behind mirror
         if(gameMain.location == "mirror"){
            if(!bedroom.getPuzzle().getFlipped()){
               System.out.println("something looks off about the mirror to you but you can't quite tell what...keep looking around the room");
            } else if (inputLine.contains("mirror") && (inputLine.contains("look behind") || inputLine.contains("pick up"))){
               bedroom.getMirror().pickUp();   
            }
         }
            
         //picking up bedroom door key
         if (inLivingRoom == true && livingRoom.getBox().open == true && (inputLine.contains("key") && inputLine.contains("pick up"))){
            System.out.println("you have picked up a door key");
            gameMain.inInventory("bedroom door key");
         } 

         //using bedroom door key
         if(gameMain.location == "bedroom door" && inputLine.contains("use") && inputLine.contains("key")){
            if (gameMain.getInventory().contains("bedroom door key")){
               inLivingRoom = false;
               inBedroom = true;
               livingRoom.getBedroomDoor().isLocked = false;
               System.out.println("you have now entered the bedroom. in here there's a bed, a nightstand, a mirror and a dresser with a puzzle on it");
            } else if (!gameMain.getInventory().contains("bedroom door key")){
               System.out.println("you don't have the key to this the door yet.");
            }
         }

         //pick up key behind mirror
         if (inBedroom == true && bedroom.getMirror().getHasKey() == true && (inputLine.contains("key") && inputLine.contains("pick up"))){
            System.out.println("you have picked up a door key");
            gameMain.inInventory("outside door key");
         } 
         
         //checking you're at a door before you try to unlock one
         if (inLivingRoom == true && !gameMain.location.equals("bedroom door") && !gameMain.location.equals("outside door") &&  inputLine.contains("use") && inputLine.contains("key") && gameMain.getInventory().contains("bedroom door key")){
            System.out.println("you cannot use a key without going to a door first.");
         }
       
         //approaching a door
         if (inLivingRoom == true && inputLine.contains("bedroom") && inputLine.contains("door") && (inputLine.contains("go to") || (inputLine.contains("unlock")))){
            System.out.println("you approach the bedroom door.");
            gameMain.location = "bedroom door";
         } else if(inLivingRoom == true && inputLine.contains("outside") && inputLine.contains("door") && (inputLine.contains("go to") || (inputLine.contains("unlock")))){
            System.out.println("you approach the outside door.");
            gameMain.location = "outside door";
         }else if (inLivingRoom == true && inputLine.contains("door") && (inputLine.contains("go to") || (inputLine.contains("unlock")))){
            System.out.println("which door do you want to go to? Bedroom or outside\n");
            String doorChoice = playGame.nextLine();
            System.out.println("");
            if (doorChoice.contains("bedroom")){
               System.out.println("you approach the bedroom door.");
               gameMain.location = "bedroom door";
            } else if (doorChoice.contains("outside")){
               System.out.println("you approach the outside door.");
               gameMain.location = "outside door";
            }
         }

         //leaving the room with outside door key
         if(gameMain.location == "outside door" && inputLine.contains("use") && inputLine.contains("key")){
            if (gameMain.getInventory().contains("outside door key")){
               inLivingRoom = false;
               inBedroom = false;
               livingRoom.getOutsideDoor().isLocked = false;
               System.out.println("you've unlocked the door and stepped outside!\n");
            } else if (!gameMain.getInventory().contains("outside door key")){
               System.out.println("you don't have the key to this the door yet.");
            }
         }

         //going into living room from bedroom
         if(livingRoom.getBedroomDoor().isLocked == false && inputLine.contains("go to") && inputLine.contains("living room")){
            inLivingRoom = true;
            inBedroom = false;
            System.out.println("you have now entered the living room.");
         }

         //going into bedroom from livingroom
         if(livingRoom.getBedroomDoor().isLocked == false && inputLine.contains("go to") && inputLine.contains("bedroom")){
            inLivingRoom = false;
            inBedroom = true;
            System.out.println("you have now entered the bedroom.");
         }  


         //room location check
         if(inputLine.contains("where am i") || inputLine.contains("which room am i in")){
               if(inLivingRoom == true){
               System.out.println("you are currently in the living room by the " + gameMain.location);
            } else if (inBedroom == true){
               System.out.println("you are currently in the bedroomby the " + gameMain.location);
            }
            else{
               System.out.println("you are not in a room. you've escaped!");
            }
         }


         //look around
         if(inputLine.contains("look around")){
            if(inLivingRoom){
               System.out.println(livingRoom.getRoomMessage());
            } else if(inBedroom){
               System.out.println(bedroom.getRoomMessage());
            } else{
               System.out.println("you've escaped the house!");
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
            System.out.println("your inventory is empty.");
         }

         for(String command : commands){ //converts the list of commands into a string and checks if the inputLine contains any of them
            if(inputLine.contains(command)){
               commandRecognized = true;
               break;
            }
         }
         
         for(String object : livingRoomObjects){ //converts the list of livingRoomObjects into a string and checks if the inputLine contains any of them
            if(inputLine.contains(object) && inLivingRoom == true){
               objectRecognized = true;
               break;
            } 
         }

         for(String object : bedroomObjects){ //converts the list of bedroomObjects into a string and checks if the inputLine contains any of them
            if(inputLine.contains(object) && inBedroom == true){
               objectRecognized = true;
               break;
            }
         }
         
         if(commandRecognized == false){ //check if command exists
            System.out.println("\nyour command is not recognized. please try again.\n");
         }

         if(objectRecognized == false){ //check if object exists
            System.out.println("\nthere is no such object in this room. please try again.\n");
         }

         //end game when not in a room
         if(inLivingRoom == false && inBedroom == false){
            stillPlaying = false;
         }
      } while (stillPlaying);

      //you win!
      System.out.println("congrats! you've have escaped the room!");
      playGame.close();
   }

}