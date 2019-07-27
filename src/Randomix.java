import java.util.concurrent.ThreadLocalRandom;

public class Randomix {

    public static int getIntegerInRangeMultipleOf(int minInclusive, int maxInclusive, int multiplier) {
//        minInclusive = 0;
//        maxInclusive = 400;
//        multiplier = 10;
        int minMultiplier = minInclusive <= multiplier ? 1 : (int) Math.ceil((double) minInclusive / multiplier);
        int maxMultiplier = maxInclusive / multiplier;
        return multiplier * ThreadLocalRandom.current().nextInt(minMultiplier, maxMultiplier + 1);
    }
}
