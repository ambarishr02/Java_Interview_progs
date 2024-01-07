package Matrix;

public class SubsetSum {
	
	boolean findTheSubsetSum(int arr[],int sum){
	 int n = arr.length; 
	 boolean dp[][]=new boolean[n+1][sum+1];
	 
	 for(int i=0; i< dp[0].length;i++) {
		 dp[i][0]=true;
	 }
	 
	 for (int i=1;i<n+1;i++) {
		 for(int j=1; j<sum+1;j++) {
			 if(j-arr[i-1]>=0) {
				 dp[i][j]=dp[i-1][j]|dp[i-1][j-arr[i-1]];
				 
			 }else {
				 dp[i][j]=dp[i-1][j];
			 }
		 }
	 }
	 
	 return dp[n][sum];
	 
	 
	}
	
	
	
	public void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5}; 
		
		int sum = 10; 
	
		
		findTheSubsetSum(arr,sum);
	}

}
