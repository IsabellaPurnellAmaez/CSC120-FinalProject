public class Mirror {
    boolean hasKey; 

    /**
     * Constructor for Mirror class
     */
    public Mirror(){
        this.hasKey = true;
    }

    /**
     * Method to pick up the key behind the mirror
     */
    public void pickUp(){// implement exact key
        if(hasKey){
            System.out.println("You have found a key behind the mirror.");
            hasKey = false;
        } else {
            System.out.println("There is no key behind the mirror."); //you've already picked up the key behind the mirror...
        }
    }
}


//if they have all the clues, then they can look behind the mirror. Otherwise, pick up should stop them. 