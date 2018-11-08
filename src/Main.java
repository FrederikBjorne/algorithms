public class Main {
    static {
        try
        {
            // Somewhat ugly to ensure each object registers itself before SorterFactory is used, but effective.
            // It enables only this application to know about concrete sorters.
            Class.forName("QuickSort");
            Class.forName("MergeSort");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int ARRAY_SIZE = 100000;
        int MAX_VALUE = 100000;

        //int[] unsortedArray = new int[]{54, 26, 93, 17, 77, 31, 44, 55, 20, 66};
        int[] unsortedArray = ArrayUtils.createArray(ARRAY_SIZE, MAX_VALUE);
        ArrayUtils.printArray(unsortedArray);

        for (AbstractSorter sorter: SorterFactory.getInstance().getAllObjects()) {
            int[] copyArray = unsortedArray.clone(); // make another copy for next sorter
            System.out.println("\n" + sorter.name());
            sorter.do_sorting(copyArray);
            ArrayUtils.printArray(copyArray);
        }
    }
}
