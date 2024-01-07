package Array;

public class FIrstIndexOfElmInSortedArray {
	
	static int findFirstIndex(int arr[],int low,int high) {
		int mid = 0;
		while (low<high) {
			mid=(low+high)/2;
			
			if(arr[mid]==1 && (mid==0 || arr[mid-1]==0))
				return mid;
			
			if(arr[mid]==1) {
				high=mid-1;
			}else 
				low=mid+1;
		}
		return mid;
	}
	
	public static void main(String args[]) {
		
		int arr[]= {0,0,0,0,0,0,0,0,1,1,1,1,1};
		
		System.out.println(""+findFirstIndex(arr,0, arr.length-1));
		
	}

}
