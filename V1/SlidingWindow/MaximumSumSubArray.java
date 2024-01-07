package SlidingWindow;

public class MaximumSumSubArray {
	
	public static void maxsubarray(int arr[]) {
		int maxsofar=0;
		int currentSum=maxsofar=
				arr[0];
		for(int i=1;i<arr.length;i++) {
			currentSum+=arr[i];
			if(maxsofar<=currentSum) {
				maxsofar=currentSum;
				System.out.println(i);
			}else
				currentSum-=arr[i]; 
			
		}
		System.err.println(maxsofar);
	}
	
	public static void main(String[] args) {
	
		int arr[]= {2, -1, 5, 1, 3, 2};
		maxsubarray(arr);
		
	}

}
