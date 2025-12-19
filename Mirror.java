public class Mirror {
    private Boolean hasKey; 

    /**
     * Constructor for Mirror class
     */
    public Mirror(){
        this.hasKey = false;
    }

    /**
     * getter for hasKey attribute
     */

    public Boolean getHasKey(){
        return this.hasKey;
    }

    /**
     * Method to pick up the key behind the mirror
     */
    public void pickUp(){// implement exact key
        if(!hasKey){
            System.out.println("You have found a key behind the mirror.");
            hasKey = true;
        } else {
            System.out.println("There is no key behind the mirror."); //you've already picked up the key behind the mirror...
        }
    }
}


//if they have all the clues, then they can look behind the mirror. Otherwise, pick up should stop them. 