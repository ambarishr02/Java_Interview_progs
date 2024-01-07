package DP;

public class SubsetSum {

	void solution(int arr[], int sum) {

		Boolean dp[][] = new Boolean[arr.length][sum + 1];
		System.out.println(subsetUtil(arr, sum, 0, dp));
	}

	boolean subsetUtil( int arr[], int sum, int currentIndex, Boolean[][] dp ){
		
		if(sum==0)return true;
		
		if(arr.length==0 || currentIndex>= arr.length)
			return false;
		
		if(dp[currentIndex][sum]==null) {
		if(arr[currentIndex]<=sum) {
			if (subsetUtil(arr, sum-arr[currentIndex], currentIndex+1, dp)){
				 dp[currentIndex][sum]=true;
				 return true;
			 }
			}
		dp[currentIndex][sum]= subsetUtil(arr, sum, currentIndex+1, dp);
		}
		 
		return dp[currentIndex][sum];
	 }

	public static void main(String[] args) {

		int[] num = { 1, 2, 3, 7 };

		SubsetSum subset = new SubsetSum();
		subset.solution(num, 20);
	}

}
