package strategy;

public class ArraySorter {
 
    private SortingAlgorithm sortingAlgorithm;

    public ArraySorter(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void setAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public int[] sort(int[] arr) {
        return sortingAlgorithm.sort(arr);
    }
}
