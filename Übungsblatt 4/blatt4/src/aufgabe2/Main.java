package aufgabe2;

import java.util.ArrayList;
import java.util.List;

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
	 * @return 
	 */
	public static void mergeSort(double[] array) {
		// TODO: Implementation goes here. 
		comparisonsOfMergeSort = 0;
		mergeSort1(array);
	}
	
	private static double[] mergeSort1(double[]array) {
		if (array.length > 1) {
			comparisonsOfMergeSort++;
			double[] left = new double[array.length/2];
			double[] right = new double[array.length-left.length];
			System.arraycopy(array, 0, left, 0, left.length);
			System.arraycopy(array, left.length, right, 0, right.length);
			mergeSort1(left);
			mergeSort1(right);
			merge(left,right,array);
			return array;
		}else {
			return array;
		}
	}
	
	private static void merge(double[]left, double[]right, double[] sortedList){
		int indexSortedList = 0;
		int indexLeft = 0;
		int indexRight = 0;
		while(indexLeft < left.length && indexRight<right.length) {
			comparisonsOfMergeSort++;
			if(left[indexLeft]<=right[indexRight]) {
				comparisonsOfMergeSort++;
				sortedList[indexSortedList] = left[indexLeft];
				indexLeft++;
			}
			else {
				sortedList[indexSortedList] = right[indexRight];
				indexRight++;
			}
			indexSortedList++;
		}
		if(indexLeft<left.length) {
			comparisonsOfMergeSort++;
			System.arraycopy(left, indexLeft, sortedList, indexSortedList, left.length-indexLeft);
		}

		if(indexRight<right.length) {
			comparisonsOfMergeSort++;
			System.arraycopy(right, indexRight, sortedList, indexSortedList, right.length-indexRight);
		}
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
		quickSort1(array, 0,array.length-1);
	}
	private static void quickSort1(double[]array, int left, int right) {
		int index = teile(array, left, right);
		if (left < index -1) {
			comparisonsOfQuickSort++;
			quickSort1(array, left, index-1);
		}
		if(index < right) {
			comparisonsOfQuickSort++;
			quickSort1(array, index, right);
		}
	}
	private static int teile(double[] array, int left, int right) {
		int i = left;
		int k = right;
		double tmp;
		double pivot = array[(left+right)/2];
		while (i<=k) {
			comparisonsOfQuickSort++;
			while(array[i] < pivot) {
				comparisonsOfQuickSort++;
				i++;
			}
			while(array[k] > pivot) {
				comparisonsOfQuickSort++;
				k--;
			}
			if(i<=k) {
				comparisonsOfQuickSort++;
				tmp = array[i];
				array[i] = array[k];
				array[k] = tmp;
				i++;
				k--;
			}
		}
		
		return i;
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
