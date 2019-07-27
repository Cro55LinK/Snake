import javax.swing.*;
import java.awt.*;


public class Game {


    public static Timer timer;
    public RenderPanel renderPanel;
    public static final int GRIDSIZE = 10;
    private static final int WIDTH = GRIDSIZE * 50 - 14;
    private static final int HEIGHT = GRIDSIZE * 50 - 21;


    public JFrame f;
    public static int score = 0;


    public Game() {


        Snake snakeO = new Snake();
        renderPanel = new RenderPanel();
        Controller controllerO = new Controller(snakeO, renderPanel);


        this.timer = new Timer(10, controllerO);
        this.f = new JFrame();
        f.setSize(WIDTH, HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setTitle("Snake, a game by Seba");
        f.setResizable(false);
        JPanel p = new JPanel();
        p.setBackground(Color.cyan);


        f.setVisible(true);
        f.add(p);


        f.add(renderPanel);

        f.revalidate();

        timer.start();


        f.addKeyListener(controllerO);


    }

    public static void score() {
        score++;
        String msgScor = "Scor =" + score;
        System.out.println(msgScor);
    }


}
