import java.util.Arrays;

public class TwoPivotQuickSort {
		// The two pivots used in this Quicksort method are the first and last elements
		public void twoPivotQuicksort(int array[], int first, int last) {
			if (first < last) {			// fiirst index must be less than last index
					int q[] = partition(array, first, last);		// Retrieve indices of both pivots in array
					if (q[0] == -1) {			// If -1 (error), exit
						return;
					}
					twoPivotQuicksort(array, first, q[0] - 1);			// Call quicksort on first third of array
					twoPivotQuicksort(array, q[0] + 1, q[1] - 1);		// Call quicksort on second third of array
					twoPivotQuicksort(array, q[1] + 1, last);			// Call quicksort on third third of array

			}
		}

		public int[] partition(int array[], int lowPivotIndex, int highPivotIndex) {
			if (highPivotIndex <= lowPivotIndex) {			// Make sure pivot 2 is greater than pivot 1
					int error[] = { -1 };
					return error;			// Error array contains -1
			}

			if (array[lowPivotIndex] > array[highPivotIndex]) {			// Make sure pivot 1 is less than pivot 2 - if not, swap
					swap(array, lowPivotIndex, highPivotIndex);
			}

			int lowPivot = array[lowPivotIndex];			// Store value of low pivot (p1)
			int highPivot = array[highPivotIndex];		// Store value of high pivot (p2)

			int lowI = lowPivotIndex + 1;		// Index of value after the low pivot (p1)
			int highI = highPivotIndex - 1;		// Index of value before the high pivot (p2)
			int index = lowPivotIndex + 1;		// Iterator

			while (index <= highI) {		// Start at index after low pivot (p1) and go until reach the high pivot (p2)
					if (array[index] < lowPivot) {		// If element is less than low pivot (p1)
						swap(array, index, lowI);		// Swap with low pivot (p1) iterator
						lowI++;					// Increment low pivot (p1) iterator 
						index++;				// Increment iterator
					} else if (array[index] > highPivot) {		// If element is greater than high pivot (p2)
						swap(array, index, highI);				// Swap with high pivot (p2) iterator
						highI--;			// Decrement high pivot (p2) iterator
					} else {
						index++;		// Go to next element in array
					}
			}

			swap(array, lowPivotIndex, lowI - 1);		// Put low pivot (p1) in its correct place
			swap(array, highI + 1, highPivotIndex);	// Put high pivot (p2) in its correct place

			int pivots[] = { --lowI, ++highI };			// Return array of low pivot (p1) index and high pivot (p2) index
			return pivots;

		}

		private void swap(int array[], int first, int second) {		// Basic swap method to swap elements in array
			int temp = array[first];
			array[first] = array[second];
			array[second] = temp;
		}

		public static void main(String[] args) {
			int randomArray[] = { 2, 6, 3, 90, 42, 64, 52, 29, 41, 53, 56, 67, 25, 46, 78, 51, 68, 35, 73, 22 };

			System.out.println("\nDouble Pivot Quick Sort");

			System.out.println("\n--- Random Array --");
			TwoPivotQuickSort qsort = new TwoPivotQuickSort();
			System.out.println("Unsorted array: " + Arrays.toString(randomArray));
			qsort.twoPivotQuicksort(randomArray, 0, 19);
			System.out.println("final array: " + Arrays.toString(randomArray));

		}
}
