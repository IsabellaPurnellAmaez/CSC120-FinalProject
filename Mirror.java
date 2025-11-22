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
            System.out.println("There is no key behind the mirror.");
        }
    }
}
