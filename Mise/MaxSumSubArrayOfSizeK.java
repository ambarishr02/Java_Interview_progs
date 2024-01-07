package Mise;

class MaxSumSubArrayOfSizeK {
	  public static int findMaxSumSubArray(int k, int[] arr) {
	    int max=0;
	    if(arr.length==0 || k==0){
	      return -1;
	    }
	    int windowSum=0;
	    int windowStart=0;
	    for(int i=0;i<arr.length;i++){
	    	windowSum+=arr[i];
	    	
	    	if(i>=k-1) {
	    		max=Math.max(max, windowSum);
	    		windowSum-=arr[windowStart];
	    		windowStart++;
	    	}
	    }
	    return max;
	  }

	  public static void main(String[] args) {
		  int arr[]= {2, 1, 5, 1, 3, 2};
		  
		System.out.println(findMaxSumSubArray(3, arr));
	  }
	}