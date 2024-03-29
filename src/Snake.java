import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    private List<Listener> listeners = new ArrayList<>();


    public Point head;
    public ArrayList<Point> snakeParts = new ArrayList<Point>();
    private Mar marO = new Mar();


    public Snake() {
        head = new Point(100, 100);
        snakeParts.add(new Point(-100, 90));
        snakeParts.add(new Point(-100, 80));
    }


    private void moveSnake(int dirX, int dirY) {
        int prevX = head.x;
        int prevY = head.y;
        head.setLocation(prevX + Game.GRIDSIZE * dirX, prevY + Game.GRIDSIZE * dirY);
        for (Point p : snakeParts) {
            int x = p.x;
            int y = p.y;
            p.setLocation(prevX, prevY);
            prevX = x;
            prevY = y;
        }
    }


    public void update(int direction) {
        if (direction == UP) {
            moveSnake(0, -1);
        }
        if (direction == DOWN) {
            moveSnake(0, 1);
        }
        if (direction == LEFT) {
            moveSnake(-1, 0);
        }
        if (direction == RIGHT) {
            moveSnake(1, 0);
        }

        if (marO != null) {

            if (head.x == Mar.mar.x && head.y == Mar.mar.y) {
                Mar.MarNou();
                snakeParts.add(new Point(-100, -100));
                for (Listener l: this.listeners) {
                    l.onEvent("eat");
                }



            }
            if (snakeParts.contains(head) || head.x == -10 || head.x == 480 || head.y == -10 || head.y == 450) {
                for (Listener l: this.listeners) {
                    l.onEvent("gameOver");
                }
            }

        }
        for (Listener l: this.listeners) {
            l.onEvent("update");
        }
    }

    public void addEventListener(Listener l){
        this.listeners.add(l);
    }

}
