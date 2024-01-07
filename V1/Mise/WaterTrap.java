package Mise;

public class WaterTrap {

	static int findWater(int arr[], int size) {
		int leftMaxima = 0;
		int rightMaxima = 0;
		int lo = 0;
		int high = size - 1;
		int result = 0;
		while (lo <= high) {
			if (arr[lo] < arr[high]) {
				if (arr[lo] > leftMaxima) {
					leftMaxima = arr[lo];
				} else {
					result = result + leftMaxima - arr[lo];
				}
				lo++;
			} else {
				if (arr[high] > rightMaxima) {
					rightMaxima = arr[high];
				} else {
					result = result + rightMaxima - arr[high];
				}
				high--;
			}

		}

		return result;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;

		System.out.println("Maximum water that " + "can be accumulated is " + findWater(arr, n));
	}

}
