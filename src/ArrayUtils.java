import java.util.Random;

public class ArrayUtils {
    final static int VALUES_PER_ROW = 20;

    /*
     * Returns a new array of random numbers.
     * @param size        Size of the array.
     * @param maxValue    The highest value in the range 0..maxValue
     */
    static int[] createArray(int size, int maxValue) {
        Random r = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = r.nextInt(maxValue);
        }
        return unsortedArray;
    }

    /*
     * Prints the first and the last VALUES_PER_ROW characters to the console for inspection.
     * @param array The array of numbers to printed to the console.
     */
    static void printArray(int[] array) {
        System.out.print('[');
        int index = 0;
        for (int i = 0; i < VALUES_PER_ROW && i < array.length; i++) {
            System.out.printf("%05d", array[i]);
            index = i;
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        if (index < array.length - 1) {
            System.out.println("\n    ....");
            System.out.print(" ");
            for (int i = array.length - VALUES_PER_ROW; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(']');
    }
}
