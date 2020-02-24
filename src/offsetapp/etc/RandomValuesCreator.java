package offsetapp.etc;

import java.util.Random;

public class RandomValuesCreator {

    private static final Random RANDOM = new Random();

    public static int getRandomOffset(int maxOffset) {
        if (maxOffset > 1) return  RANDOM.ints(1, maxOffset).limit(1).sum();
        else return 1;
    }

    public static int[] getRandomIntegerArray(int minSize, int maxSize) {
        int size;
        if (minSize != maxSize) size = RANDOM.ints(minSize, maxSize).limit(1).sum();
        else size = minSize;
        return RANDOM.ints(1, 100).limit(size).toArray();
    }

}

