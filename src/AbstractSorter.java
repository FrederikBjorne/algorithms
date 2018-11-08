import java.time.Duration;
import java.time.Instant;

abstract class AbstractSorter {
    protected static boolean LOGGING_ON = false;
    private String name = "";

    AbstractSorter(String name) {
        this.name = name;
    }

    /*
     * Sorts an array of numbers in-place and prints the time consumed in nano seconds.
     * @param unsortedArray The array of unsorted numbers and arbitrary size to be sorted.
     */
    void do_sorting(int[] unsortedArray) {
        Instant start = Instant.now();
        sort(unsortedArray);
        System.out.println(Duration.between(start, Instant.now()).toNanos() + " ns");
    }

    /*
     * Returns the name of the algorithm for sorting.
     */
    String name() {
        return this.name;
    }

    /*
     * Sorts an array of numbers in-place.
     * @param unsortedArray The array of unsorted numbers and arbitrary size to be sorted.
     */
    abstract void sort(int[] unsortedArray);
}
