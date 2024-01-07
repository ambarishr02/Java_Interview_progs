package Array;

//Pivoit index  is the minimum element of  the array


/*
 * The minimum element is the only element whose previous is greater than it. If there is no previous element, then there is no rotation (the first element is minimum). We check this condition for the middle element by comparing it with (mid-1)’th and (mid+1)’th elements.
If the minimum element is not at the middle (neither mid nor mid + 1), then the minimum element lies in either the left half or right half. 
If the middle element is smaller than the last element, then the minimum element lies in the left half
Else minimum element lies in the right half.
 */



public class FindPivotInSortedRotatedArray {

//	// O(n) solution - Linear Search
//	public static int findPivotLinear(int[] array) {
//		int pivot = -1;
//
//		if (array != null && array.length > 0) {
//
//			pivot = 0;
//			for (int i = 0; i < array.length - 1; i++) {
//				if (array[i] > array[i + 1]) {
//					pivot = i + 1;
//					break;
//				}
//			}
//		}
//		return pivot;
//	}

	// O(log n) solution - Binary Search
	public static int findPivotBinarySearch(int[] array) {

		if (array == null || array.length == 0) {
			return -1;
		}

		// Case when array is not rotated. Then first index is the pivot
		if (array.length == 1 || array[0] < array[array.length - 1]) {
			return 0;
		}

		int start = 0, end = array.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;
			// check if mid+1 is pivot
			if (mid < array.length - 1 && array[mid] > array[mid + 1]) {
				return (mid + 1);
			} else if (array[start] <= array[mid]) {
				// If array[start] <= array[mid],
				// it means from start to mid, all elements are in sorted order,
				// so pivot will be in second half
				start = mid + 1;
			} else {
				// else pivot lies in first half, so we find the pivot in first half
				end = mid - 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {

		int array[] = { 5, 4 };
		findPivotBinarySearchTest(array);
	}

//	public static void findPivotLinearTest(int array[]) {
//		int index = findPivotLinear(array);
//		System.out.println("Pivot " + (index >= 0 ? (" found at index " + index) : " not found!"));
//	}

	public static void findPivotBinarySearchTest(int array[]) {
		int index = findPivotBinarySearch(array);
		System.out.println("Pivot " + (index >= 0 ? (" found at index " + index) : " not found!"));
	}
}