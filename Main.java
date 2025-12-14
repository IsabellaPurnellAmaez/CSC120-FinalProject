import java.util.Scanner;
import java.util.ArrayList;


public class Main { //im wondering if theres a way to make a list of all the objects in each room. That way if someone is trying to go to an object it first checks that they're in the appropriate room first? I think it'd be more efficient to do that in main rather than have each object have a Boolean attribute that's 'inLivingRoom' or 'inBedroom'...

   static LivingRoom livingRoom = new LivingRoom();
   static Bedroom bedroom = new Bedroom();

   private ArrayList<String> inventory = new ArrayList<String>();
   private String location = ""; //string that says where you are. If you're already in a location you don't have to say "go to" like for cups? 

   private static ArrayList<String> commands = new ArrayList<String>();

   private void inInventory(String item){
      inventory.add(item);
   }

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
      commands.add("look at");
      commands.add("pick up");
      commands.add("use");
      commands.add("look under");
      commands.add("look behind");
      commands.add("look around");
      commands.add("print inventory");
      commands.add("which room am I in?");
      commands.add("Where am I?");
      
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
                  livingRoom.getRedCup().pickUp();
                  gameMain.inInventory("red cup note");
               } else if(nextLine.contains("blue")){
                  livingRoom.getBlueCup().pickUp();
                  gameMain.inInventory("blue cup note");
               } else if(nextLine.contains("green")){
                  livingRoom.getGreenCup().pickUp();
                  gameMain.inInventory("green cup note");
               } else{
                  System.out.println("What color cup do you want to pick up? red, blue, or green?\n");
                  String colorChoice = playGame.nextLine();
                  System.out.println("");
                  if(colorChoice.contains("red")){ 
                     livingRoom.getRedCup().pickUp();
                     gameMain.inInventory("red cup note");
                  } else if(colorChoice.contains("blue")){
                     livingRoom.getBlueCup().pickUp();
                     gameMain.inInventory("blue cup note");
                  } else if(colorChoice.contains("green")){
                     livingRoom.getGreenCup().pickUp();
                     gameMain.inInventory("green cup note");
                  }
               }
            }
         } 
    

         
 
         //bookshelf interaction
         if(inLivingRoom == true &&  inputLine.contains("bookshelf") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){ //what about approaching the bookshelf if you haven't been to the cups yet. 
             if(!livingRoom.getRedCup().foundCup){
               System.out.println("Bookshelf looks weird, we dont know why. Keep looking around.");
             } else{
               livingRoom.getBookshelf().approachBookshelf();
               String nextLine = playGame.nextLine();
               System.out.println("\n");
               if(nextLine.contains("book") && (nextLine.contains("pick up") || nextLine.contains("look at"))){
                  gameMain.inInventory("book"); //put down book?
                  livingRoom.getBookshelf().pickUpBook();
               } 
            }
         } else if (inLivingRoom == false && inputLine.contains("bookshelf")){
               System.out.println("There is no bookshelf in this room.");//no bookshelf in room
         }
      
            

//livingRoom.bookshelf.foundBook == true &&

         //table interaction
         if(inLivingRoom == true && inputLine.contains("table") && inputLine.contains("go to")){
            gameMain.location = "table";
            System.out.println("you're at the table");
            gameMain.inInventory("table note");
         }else if (inLivingRoom == false && inputLine.contains("table")){
            System.out.println("There is no table in this room.");
         }


         if(gameMain.location == "table"){
            if( inputLine.contains("look under") && inputLine.contains("table")){
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
            if(inputLine.contains("pick up") && inputLine.contains("cushion")){
               livingRoom.getCouch().pickUpCushions();
               gameMain.inInventory("box");
            }
         }
        
         

         //box interaction
         if(inLivingRoom == true && livingRoom.getCouch().lifted == true && inputLine.contains("box") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("open"))){
            livingRoom.getBox().tryToOpen = true; //need to fix scanner issues here, need to take out scanner in box and get this to still work  
            while(livingRoom.getBox().tryToOpen){ 
                if(!(livingRoom.getBlueCup().foundCup == true && livingRoom.getGreenCup().foundCup == true)){
                  System.out.println("The box requires a 4 digit code. You don't have all the information needed to open it yet, keep looking around.");
                  livingRoom.getBox().tryToOpen = false;
                } else{
                  System.out.println("Enter the 4 digit code to open the box:");
                  String codeTry = playGame.nextLine();
                  if(codeTry.equals(livingRoom.getBox().boxCode)){
                        System.out.println("You've opened the box! Inside is a key.");
                        gameMain.inInventory("key to bedroom");
                        livingRoom.getBox().tryToOpen = false;
                        livingRoom.getBox().open = true;
                  }  else{
                        System.out.println("Not quite right, care to try again?"); // need a way for them to maybe leave and come back? this whole section needs a lot of work. 
                        String endTry = playGame.nextLine().trim();
                        if (endTry.contains("no") || endTry.contains("No")){ //this needs work. Need to slice the string and check for some sort of affirmative/negative statement and then proceed. Also how to do or statements in java? Google said || but that does not seem to be working.
                           livingRoom.getBox().tryToOpen = false;
                           livingRoom.getBox().open = true;
                           System.out.println("Ok, now what will you do?"); 
                        } else if (endTry.contains(livingRoom.getBox().boxCode)){
                           System.out.println("You've opened the box! Inside is a key.");
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
         if(inLivingRoom == true && livingRoom.getBox().open == true && inputLine.contains("key") && inputLine.contains("bedroom") &&(inputLine.contains("unlock") || inputLine.contains("use"))){
            System.out.println("What key do you want to use? Bedroom or outside?");
            String keyInput = playGame.nextLine();
            if(keyInput.equals(livingRoom.getBedroomDoorKey().description)){ 
                  if(livingRoom.getBedroomDoorKey().usage.equals(livingRoom.getBedroomDoor().name)){
                     livingRoom.getBedroomDoor().isLocked = false;
                  } else {
                     livingRoom.getBedroomDoor().isLocked = true;
                     System.out.println("This key does not unlock " + livingRoom.getBedroomDoor().name);
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
               bedroom.getNightstand().open(1);
               gameMain.inInventory("puzzle piece 1");
               gameMain.inInventory("nightstand note");
            } else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("bottom")){
               bedroom.getNightstand().open(2);
               gameMain.inInventory("puzzle piece 3");
            }
         }else if (inBedroom == false && inputLine.contains("nightstand")){
            System.out.println("There is no nightstand in this room.");
         }
         

         //dresser interaction

         if(inBedroom == true && inputLine.contains("dresser") && (inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("You approach the dresser. It has three drawers.");
            if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("1") || inputLine.contains("first") || inputLine.contains("one") || inputLine.contains("top")){
               bedroom.getDresser().open(1);
            } else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("2") || inputLine.contains("second") || inputLine.contains("two") || inputLine.contains("middle")){
               bedroom.getDresser().open(2);
            }
            else if((inputLine.contains("open") || inputLine.contains("look")) && inputLine.contains("3") || inputLine.contains("third") || inputLine.contains("three") || inputLine.contains("bottom")){
               bedroom.getDresser().open(3);
            }
         } else if (inBedroom == false && inputLine.contains("dresser")){
            System.out.println("There is no dresser in this room.");
         }

         //bed interaction

         if(inBedroom == true && inputLine.contains("bed") && (inputLine.contains("approach") || inputLine.contains("look at") || inputLine.contains("go to"))){
            System.out.println("You approach the bed.");
            if((inputLine.contains("lift") || inputLine.contains("pick up")) && (inputLine.contains("covers") || inputLine.contains("blanket") || inputLine.contains("sheets"))){
               bedroom.getBed().liftCovers();
               if((inputLine.contains("pick up") || inputLine.contains("look at")) && (inputLine.contains("note") || inputLine.contains("paper"))) {
                  bedroom.getBed().pickUp();
                  gameMain.inInventory("bed note");
               }
            }  
         } else if (inBedroom == false && inputLine.contains("bed")){
            System.out.println("There is no bed in this room.");
         } 
         

         //puzzle interaction

         if((inputLine.contains("place")|| inputLine.contains("put")) && inputLine.contains("piece")){
               if(gameMain.inventory.contains("puzzle piece 1")){
               }
               gameMain.inInventory("puzzle clue");
         } else if (inBedroom == false && inputLine.contains("puzzle")){
            System.out.println("There is no puzzle in this room.");
         }

         //mirror interaction
         /*
         if(inputLine.contains("mirror") && (inputLine.contains("go to") || inputLine.contains("approach") || inputLine.contains("look at"))){
            System.out.println("you're now standing in front of the mirror");
            if(!bedroom.getPuzzle().getFlipped()){
               System.out.println("something looks off about the mirror to you but you can't quite tell what...keep looking around the room");
            } else if (inputLine.contains("mirror") && (inputLine.contains("look behind") || inputLine.contains("move") || inputLine.contains("pick up"))){
               bedroom.getMirror().pickUp();
               if (inputLine.contains("key") && inputLine.contains("pick up")){
                  gameMain.inInventory("key to outside");
               }
               }
         }*/
            


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

            System.out.println(gameMain.getInventory());
            
            System.out.println("****************************");
         } else if(inputLine.contains("print inventory") && gameMain.getInventory().size() == 0){
            System.out.println("Your inventory is empty.");
         }

         if(!inputLine.equals(commands)){
            System.out.println("Command not recognized. Please try again.");
         }

      } while (stillPlaying);

      if(inLivingRoom == false && inBedroom == false){
         stillPlaying = false;
         System.out.println("Congrats! You've have escaped the room!");
         playGame.close();
      }
   }

}
