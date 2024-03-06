package strategy;

public class Main {
    
    public static void main(String[] args) {
        
        // Generate a moderately large array of random integers
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }

        // Test the sorting algorithms
        testSortingAlgorithm(new BubbleSort(), arr);
        testSortingAlgorithm(new MergeSort(), arr);
        testSortingAlgorithm(new QuickSort(), arr);
        
    }
    
    static void testSortingAlgorithm(SortingAlgorithm sortingAlgorithm, int arr[]) {
        
        // Scramble the array
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }

        // Start timer
        long startTime = System.nanoTime();

        sortingAlgorithm.sort(arr);

        // End timer
        long endTime = System.nanoTime();

        // Print time taken in ns
        System.out.println(sortingAlgorithm.getClass().getSimpleName() + " took " + (endTime - startTime) + " ns to sort the array.");
    }
}
