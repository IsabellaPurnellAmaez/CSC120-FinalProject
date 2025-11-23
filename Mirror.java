public class Mirror {
    boolean hasKey; 

    public Mirror(){
        this.hasKey = true;
    }

    public void pickUp(){// implement exact key
        if(hasKey){
            System.out.println("You have picked up the key from behind the mirror.");
            hasKey = false;
        } else {
            System.out.println("There is no key behind the mirror."); //you've already picked up the key behind the mirror...
        }
    }
}


//if they have all the clues, then they can look behind the mirror. Otherwise, pick up should stop them. 