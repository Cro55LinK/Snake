import java.awt.*;
import java.util.Random;

public class Mar {


    public static Random random = new Random();
    public static Point mar = new Point(200, 100);

    RenderPanel renderPanel;

    public static Point MarNou() {
        // this.mar = new Point(200, 100);


        mar.setLocation(random.nextInt(470 / Game.GRIDSIZE) * Game.GRIDSIZE, random.nextInt(440 / Game.GRIDSIZE) * Game.GRIDSIZE);
        return mar;
        //mar.setLocation(Randomix.getIntegerInRangeMultipleOf(0, 470, Game.GRIDSIZE), Randomix.getIntegerInRangeMultipleOf(0, 440, GRIDSIZE));
        //System.out.println("mar" + mar);


    }


}
