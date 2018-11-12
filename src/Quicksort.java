import java.util.Arrays;

public class Quicksort {
		int count = 0;

		public void quicksort(int array[], int first, int last) {
			if (first < last) {			// first index must be less than the last index
					int q = partition(array, first, last);		// Retrieve pivot value [ ... < pivot > ... ]
					quicksort(array, first, q - 1);			// Call quicksort on first half
					quicksort(array, q + 1, last);			// Call quicksort on second half
			}
		}

		public int partition(int array[], int first, int pivotIndex) {
			int pivotValue = array[pivotIndex];		// Store pivot value to compare elements
			int i = first - 1;			// Index comparator
			for (int j = first; j < pivotIndex; j++) {		// From first element to r-1 (element before pivot)
					count += 1;			// Count for Big-O
					if (array[j] <= pivotValue) {			// If array value is less than pivot, increment i and swap i and j
						i += 1;
						int temp = array[i];		// swap
						array[i] = array[j];
						array[j] = temp;
					}
			}

			int temp = array[i + 1];			// Swap the pivot to its right place
			array[i + 1] = array[pivotIndex];
			array[pivotIndex] = temp;

			return i + 1;		// Return index of pivot
		}

		public static void main(String[] args) {
			int randomArray[] = { 2, 6, 3, 90, 42, 64, 52, 29, 41, 53, 56, 67, 25, 46, 78, 51, 68, 35, 73, 22 };
			int sortedArray[] = { 2, 3, 6, 22, 25, 29, 35, 41, 42, 46, 51, 52, 53, 56, 64, 67, 68, 73, 78, 90 };
			int halfSorted[] = {2, 3, 6, 22, 25, 29, 35, 41, 42, 46, 51, 90, 78, 73, 68, 67, 64, 56, 53, 52};
			
			System.out.println("\nQuick Sort O(n^2)");
			
			System.out.println("\n--- Best Case- O(n lgn) Random Array --");
			Quicksort qsort = new Quicksort();
			System.out.println("Unsorted array: " + Arrays.toString(randomArray));
			qsort.quicksort(randomArray, 0, 19);
			System.out.println("final array: " + Arrays.toString(randomArray));
			System.out.println("QuickSort count: " + qsort.count);

			System.out.println("\n--- Worst Case O(n^2) Sorted Array ---");
			Quicksort qsort2 = new Quicksort();
			System.out.println("Sorted array: " + Arrays.toString(sortedArray));
			qsort2.quicksort(sortedArray, 0, 19);
			System.out.println("final array: " + Arrays.toString(sortedArray));
			System.out.println("QuickSort count: " + qsort2.count);
			
			System.out.println("\n--- Average Case O(n lgn) Half sorted ---");
			Quicksort qsort3 = new Quicksort();
			System.out.println("intial array: " + Arrays.toString(halfSorted));
			qsort3.quicksort(halfSorted, 0, 19);
			System.out.println("final array: " + Arrays.toString(halfSorted));
			System.out.println("QuickSort count: " + qsort3.count);
		}
}
