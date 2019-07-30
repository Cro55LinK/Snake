import javax.swing.*;
import java.awt.*;


public class Game {


    public Timer timer;
    public static final int GRIDSIZE = 10;
    private static final int WIDTH = GRIDSIZE * 50 - 14;
    private static final int HEIGHT = GRIDSIZE * 50 - 21;


    public JFrame f;
    public int score = 0;


    public Game() {


        Snake snakeO = new Snake();

        RenderPanel renderPanel = new RenderPanel(snakeO);
        Controller controllerO = new Controller(snakeO);

        snakeO.addEventListener(new Listener() {
            @Override
            public void onEvent(String evt) {
                if(evt.equals("update"))
                    renderPanel.repaint();
            }
        });


        snakeO.addEventListener(new Listener() {
            @Override
            public void onEvent(String evt) {
                if(evt.equals("eat")) {
                    score();
                    if (score % 3 == 0) {
                        Controller.speed = Controller.speed - 1;
                    }
                    System.out.println(Controller.speed);
                }
            }
        });

        snakeO.addEventListener(new Listener() {
            @Override
            public void onEvent(String evt) {
                if(evt.equals("gameOver")) {
                    timer.stop();
                    renderPanel.gameOver(score);
//                    System.out.println("am prins coada" + head.x);
                }
            }
        });


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

    public void score() {
        score++;
        String msgScor = "Scor =" + score;
        System.out.println(msgScor);
    }


}
