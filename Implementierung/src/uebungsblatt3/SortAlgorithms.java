package uebungsblatt3;

public class SortAlgorithms {

    public static void main(String[] args) {
        int[] unsorted = {8, 2, 6, 9, 1, 0, 7, 5, 3, 4};
        int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] sortedDesc = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] sortedTest = {6, 5, 4, 7, 3, 8, 2, 9, 1};

        selectionSort(sortedDesc);
        insertionSort(sortedDesc);
    }

    private static int[] insertionSort(int[] toSort) {
        int[] copy = toSort.clone();

        int amountComparisons = 0;
        int amountSwaps = 0;

        for (int i = 1; i < copy.length; i++) {
            int j = i;
            while ((j > 0) && (copy[j - 1] > copy[j])) {
                int tmp = copy[j - 1];
                copy[j-1] = copy[j];
                copy[j] = tmp;
                j--;
            }
        }

        System.out.println("IS - Amount comparisons: " + amountComparisons);
        System.out.println("IS - Amount swaps: " + amountSwaps);

        return copy;
    }

    private static int[] selectionSort(int[] toSort) {
        int[] copy = toSort.clone();

        int amountComparisons = 0;
        int amountSwaps = 0;

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                amountComparisons++;
                if (copy[i] > copy[j]) {
                    amountSwaps++;
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }

        System.out.println("SS - Amount comparisons: " + amountComparisons);
        System.out.println("SS - Amount swaps: " + amountSwaps);

        return copy;
    }
}
