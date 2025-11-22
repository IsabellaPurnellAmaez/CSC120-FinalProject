import java.util.ArrayList;
public class Dresser extends Storage {

    public Dresser() {
        this.numOfDrawers = 3;
        this.drawer = new ArrayList<>();
        for (int i = 0; i < numOfDrawers; i++) {
            drawer.add(i);
        }
        //need to figure out how to speficy which drawer is locked
    }
}
