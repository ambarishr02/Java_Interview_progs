package Array;

public class PivotEleInRorateMatrix {
	
	/* Pivot element : whose right side element is less.
	 */
	
	static int findThePivotElement(int arr[],int low,int high){
		int mid=low+high/2;
		
		if(mid<high && arr[mid]>arr[mid+1]) {
			return arr[mid];
		}
		if(mid>low && arr[mid]<arr[mid-1]) {
			return arr[mid-1];
		}
		
		if(arr[mid]>arr[low])
		 return	findThePivotElement(arr, mid+1, high);
		else
		 return	findThePivotElement(arr, low, mid-1);
	}
	
	public static void main(String args[]) {
		
		int arr[]= {4, 5,6,1,2, 3} ; //output  : 6
		
		findThePivotElement(arr, 0, arr.length-1);
		
	}

}
