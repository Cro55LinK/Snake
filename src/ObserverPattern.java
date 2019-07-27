import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {  // asta este game
    private List<Listener> listeners = new ArrayList<>();

    public void addEventListener(Listener e){
        this.listeners.add(e);
    }

    public void removeEventListener(Listener e){
        this.listeners.remove(e);
    }

    public void move(int x, int y){
        //logica de move



        fireEvent();
    }

    private void fireEvent(){
        for (Listener l: this.listeners) {
            l.onEvent();
        }
    }

}
