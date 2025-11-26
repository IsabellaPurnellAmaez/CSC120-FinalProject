public class Door {
    String name;
    boolean isLocked;
    Key key;

    public Door(String name){
        this.name = name;
        this.isLocked = true;
    }

    public void unlock(){
        if(key.usage == this.name){
            isLocked = false;
        } else if(key.usage != this.name){
            isLocked = true;
            System.out.println("This key does not unlock " + this.name);
        }
    }
}
