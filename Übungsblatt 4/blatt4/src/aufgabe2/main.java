package aufgabe2;

public class Main 
{
	//Static variables to count the number of comparisons
	private static int comparisonsOfMergeSort;
	private static int comparisonsOfQuickSort;	

	/* START OF TESTING */
	public static void main(String[] args) {
		java.util.Random random = new java.util.Random();
		
		java.util.Map mergeSortComparisons = new java.util.TreeMap<Integer,Integer>();
		java.util.Map quickSortComparisons = new java.util.TreeMap<Integer,Integer>();
		
		for (int arraySize = 100; arraySize <= 2000; arraySize = arraySize + 100)
		{		
			//Create a new array with double values and fill it with random numbers.
			double[] doubleRandomArray = new double[arraySize];
			for (int i=0; i<doubleRandomArray.length; i++) {
				doubleRandomArray[i] = random.nextDouble();
			}
			
			//Sort with mergeSort
			double[] copy1 = java.util.Arrays.copyOf(doubleRandomArray, doubleRandomArray.length);
			mergeSort(copy1);
			mergeSortComparisons.put(arraySize,comparisonsOfMergeSort);
			for (int i=0; i<copy1.length-1; i++)
			{
				if (copy1[i] > copy1[i+1])
				{
					System.err.println("Error in mergeSort at position " + i);
					break;
				}
			}
			
			//Sort with quickSort
			double[] copy2 = java.util.Arrays.copyOf(doubleRandomArray, doubleRandomArray.length);
			quickSort(copy2);
			quickSortComparisons.put(arraySize,comparisonsOfQuickSort);
			for (int i=0; i<copy2.length-1; i++)
			{
				if (copy2[i] > copy2[i+1])
				{
					System.err.println("Error in quickSort at position " + i);
					break;
				}
			}
		}
		
		//Create a new array with integer values and fill it with random numbers.
		int[] intRandomArray = new int[1000];
		for (int i=0; i<intRandomArray.length; i++) {
			intRandomArray[i] = random.nextInt(100);
		}

/* Comment these lines in if you have implemented Counting Sort.
		
		//Sort with countingSort
		countingSort(intRandomArray);
		for (int i=0; i<intRandomArray.length-1; i++)
		{
			if (intRandomArray[i] > intRandomArray[i+1])
			{
				System.err.println("Error in countingSort at position " + i);
				break;
			}
		}
*/		
		System.out.println("If no errors have been printed, then you passed the test ");

		System.out.println("Merge Sort");		
		mergeSortComparisons.forEach((key,value) -> System.out.println(key + ": " + value));
		
		System.out.println();

		System.out.println("Quick Sort");
		quickSortComparisons.forEach((key,value) -> System.out.println(key + ": " + value));

    }
	/* END OF TESTING */
	
	/* START OF MERGESORT */
	/**
	 * Sorts an array with mergesort.
	 * @param array - the array to be sorted.
	 */
	public static void mergeSort(double[] array) {
		comparisonsOfMergeSort = 0;
		// TODO: Implementation goes here.    
	}
	
	// TODO: Put additional methods for mergeSort here.
	
	/* END OF MERGESORT */
	
	/* START OF QUICKSORT */
	/**
	 * Sorts an array with quicksort.
	 * @param array - the array to be sorted.
	 */
	public static void quickSort(double[] array) {
		comparisonsOfQuickSort = 0;
		// TODO: Implementation goes here. 
	}
	
	// TODO: Put additional methods for quicksort here.
	
	/* END OF QUICKSORT */
	
	/* START OF COUNTINGSORT */
	/**
	 * Sorts an array of integers with countingsort.
	 * @param array - the array to be sorted.
	 */
	public static void countingSort(int[] array) {
		// TODO: Implementation goes here. 
	}
	
	// TODO: Put additional methods for countingsort here.
	
	/* END OF COUNTINGSORT */
}
