package offsetapp.test;

import java.util.Arrays;

import offsetapp.app.ArraysUtils;
import static offsetapp.etc.RandomValuesCreator.*;



public class TestClass {

    private static int offset;
    private static int[] originalArray;
    private static int[] offsetArray;

    public static void main(String[] args) {

        System.out.println();
        System.out.println("--------------------------- Test przesunięć ---------------------------");
        for (int i = 0; i < 6; i++) {
            setFields(2, 12);
            printInfo();
        }

        System.out.println("------------------------ Test przesunięcia o 0 ------------------------");
        setFields(2, 10, 0);
        printInfo();

        System.out.println("----------------- Test przesunięcia o długość tablicy -----------------");
        setFields(9);
        printInfo();

        System.out.println("-------------------- Test przekazania tablicy null --------------------");
        originalArray = null;
        offsetArray = ArraysUtils.getOffsetArrayClone(originalArray, 10);
        printInfo();


    }

    private static void printInfo() {
        if (originalArray != null) {
            System.out.println("Oryginalna tablica o dlugosci - " + originalArray.length + ":");
            System.out.println(Arrays.toString(originalArray));
            System.out.println("Przesuwam o - " + offset);
            System.out.println(Arrays.toString(offsetArray));
            System.out.println();
        } else {
            System.out.println("Oryginalna tablica - " + Arrays.toString(originalArray));
            System.out.println("Po przesunięciu - " + Arrays.toString(offsetArray));
        }
    }

    private static void setFields(int minArraySize, int maxArraySize) {
        originalArray = getRandomIntegerArray(minArraySize, maxArraySize);
        offset = getRandomOffset(originalArray.length - 1);
        offsetArray = ArraysUtils.getOffsetArrayClone(originalArray, offset);
    }

    private static void setFields(int minArraySize, int maxArraySize, int exactOffset) {
        originalArray = getRandomIntegerArray(minArraySize, maxArraySize);
        offset = exactOffset;
        offsetArray = ArraysUtils.getOffsetArrayClone(originalArray, offset);
    }

    private static void setFields(int arraySize) {
        originalArray = getRandomIntegerArray(arraySize, arraySize);
        offset = arraySize;
        offsetArray = ArraysUtils.getOffsetArrayClone(originalArray, offset);
    }

}

