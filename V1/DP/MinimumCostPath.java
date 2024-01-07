package DP;

public class MinimumCostPath {

	static int min(int x, int y, int z) {
		if (x < y)
			return x < z ? x : z;
		else
			return y < z ? y : z;
	}

	static int minCost(int arr[][], int m, int n) {

		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		}

		if (m == 0 && n == 0) {
			return arr[m][n];
		}

		return (arr[m][n] + min(minCost(arr, m - 1, n - 1), minCost(arr, m, n - 1), minCost(arr, m - 1, n)));
	}

	public static void main(String args[]) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 2, 2));
	}

}
