package offsetapp.app;

import java.util.Arrays;

public class ArraysUtils {

    public static int[] getOffsetArrayClone(int[] array, int offset) {
        if (array == null) return null;
        else if (!canShiftArrayByOffset(array, offset)) return array;

        int[] arrayCopy = array.clone();
        int[] leftSide = getLeftSide(arrayCopy, offset);
        int[] rightSide = getRightSide(arrayCopy, offset);

        return concatenateSides(leftSide, rightSide);
    }

    private static boolean canShiftArrayByOffset(int[] array, int offset){
        return offset <= array.length && offset >=  0;
    }

    private static int[] getLeftSide(int[] array, int offset) {
        return Arrays.copyOfRange(array, array.length - offset, array.length);
    }

    private static int[] getRightSide(int[] array, int offset) {
        return Arrays.copyOfRange(array, 0, array.length - offset);
    }

    private static int[] concatenateSides(int[] leftSide, int[] rightSide) {
        int[] concatenatedArray = new int[leftSide.length + rightSide.length];

        System.arraycopy(leftSide, 0, concatenatedArray, 0, leftSide.length);
        System.arraycopy(rightSide, 0, concatenatedArray, leftSide.length, concatenatedArray.length - leftSide.length);

        return concatenatedArray;
    }

}

