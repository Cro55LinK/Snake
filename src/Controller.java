import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener, ActionListener {
    private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    private double ticks = 0;
    private int direction = RIGHT;
    public static double speed = 20;

    boolean handledInput = false;
    private Snake snake;


    public Controller(Snake snake) {
        this.snake = snake;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (handledInput) {
            if (key == KeyEvent.VK_LEFT && direction != RIGHT) {
                direction = LEFT;
            } else if (key == KeyEvent.VK_RIGHT && direction != LEFT) {
                direction = RIGHT;
            } else if (key == KeyEvent.VK_UP && direction != DOWN) {
                direction = UP;
            } else if (key == KeyEvent.VK_DOWN && direction != UP) {
                direction = DOWN;
            }
            handledInput = false;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;

        if (ticks % speed == 0) {
            handledInput = true;
            snake.update(direction);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}
