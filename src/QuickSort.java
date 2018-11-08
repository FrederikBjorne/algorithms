/**
 * A quicksort implementation for sorting an array of numbers.
 */

public class QuickSort extends AbstractSorter {

    public QuickSort() {
        super("quicksort");
    }

    static {
        SorterFactory.getInstance().register(new QuickSort()); // registers itself to the singleton factory
    }

    //public static final <T> void swap (T[] a, int i, int j) {
    public static void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    void sort(int[] unsortedArray) {
        sort(unsortedArray, 0, unsortedArray.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) { // sort left half
            sort(array, left, index - 1);
        }
        if (index < right) { // sort right half
            sort(array, index, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2]; // set pivot split value
        //int pivot = array[left]; // set pivot split value

        while (left <= right) { // continue splitting array until the markers pass each other
            while (array[left] < pivot) {
                left++; // keep moving left marker to the right until element > pivot
            }
            while (array[right] > pivot) {
                right--; // keep moving right marker to the left until element < pivot
            }

            if (left < right) {
                if (LOGGING_ON) {
                    System.out.println("pivot: " + pivot);
                    System.out.println("before left:" + left + " (" + array[left] + ") " + " right: " + right +
                            " (" + array[right] + ") ");
                }

                swap(array, left++, right--); // swap elements

                if (LOGGING_ON) {
                    System.out.println("after swap left:" + left + " (" + array[left] + ") " + " right: " + right +
                            " (" + array[right] + ") ");
                    ArrayUtils.printArray(array);
                }
            } else if (left == right) {
                left++; right--;
            }
        }
        return left;
    }
}
