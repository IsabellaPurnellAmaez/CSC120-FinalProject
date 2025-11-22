import java.util.ArrayList;
public class Nightstand extends Storage {

    public Nightstand() {
        this.numOfDrawers = 2;
        this.drawer = new ArrayList<>();
        for (int i = 0; i < numOfDrawers; i++) {
            drawer.add(i);
        }
        //need to figure out how to speficy which drawer is locked
    }
}
