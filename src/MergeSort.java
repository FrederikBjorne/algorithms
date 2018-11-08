/*
 * A mergesort implementation for sorting an array of numbers.
 */
public class MergeSort extends AbstractSorter {

    public MergeSort() {
        super("mergesort");
    }

    static {
        SorterFactory.getInstance().register(new MergeSort()); // registers itself to the singleton factory
    }

    void sort(int[] unsortedArray) {
        int[] helper = unsortedArray.clone();
        sort(unsortedArray, helper, 0, unsortedArray.length - 1);
    }

    private void sort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            sort(array, helper, low, middle); // sort left array
            sort(array, helper, middle + 1, high); // sort right array
            merge(array, helper, low, middle, high); // merge the halves
        }
    }

    private static int i = 0;
    private void merge(int[] array, int[] helper, int low, int middle, int high) {
        // copy both halves into the helper array
        System.arraycopy(array, low, helper, low, high - low + 1);

        int helperLeft = low;
        int current = low;
        int helperRight = middle + 1;

        if (LOGGING_ON) {
            System.out.println("(" + +MergeSort.i + ")" + "helperLeft:" + helperLeft + " current:" + current +
                               " helperRight:" + helperRight);
            MergeSort.i++;
        }

        // iterate through helper array. Compare left and right half. Copy back
        // the smaller element from the two halves into the original array.
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current++] = helper[helperLeft++];
            } else { // if right element is smaller than left element
                array[current++] = helper[helperRight++];
            }
        }

        // copy the rest of the left side back into the target array
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }

        if (LOGGING_ON) {
            System.out.println("remain: " + remaining);
            System.out.println("low:" + low + " middle:" + middle + " high:" + high);
            ArrayUtils.printArray(array);
        }
    }
}

