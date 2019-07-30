import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class RenderPanel extends JPanel {


    private Point head, mar;
    private List<Point> tail;
    boolean gameOver = false;
    private int score = 0;

    private Image img;


    public RenderPanel(Snake snake) {

        this.head = snake.head;
        this.tail = snake.snakeParts;
       this.mar = Mar.mar;
        try {
            this.img = ImageIO.read(new File("Imagini/appleO.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void gameOver(int score) {
        gameOver = true;
        this.score = score;
    }


    @Override
    public void paint(Graphics g) {
        if (gameOver) {
            String msg = "Game over";
            g.setColor(Color.blue);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString(msg, 200, 200);

        } else {
            g.setColor(Color.CYAN); // it overrides Jpanel - suprascrie culoarea din clasa Game
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.red);
            g.fillRect(head.x, head.y, Game.GRIDSIZE, Game.GRIDSIZE);
            g.setColor(Color.BLACK);
            for (Point p : tail) {
                g.fillRect(p.x, p.y, Game.GRIDSIZE, Game.GRIDSIZE);
            }
            g.setColor(Color.CYAN);
            g.fillRect(mar.x, mar.y, 10, 10);
          g.drawImage(img, mar.x, mar.y, Game.GRIDSIZE, Game.GRIDSIZE, null);

            g.setColor(Color.BLUE);
            g.drawString("Score is " + score, 10, 10);


        }


    }
}
