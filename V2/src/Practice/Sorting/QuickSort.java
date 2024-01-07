package Practice.Sorting;

public class QuickSort {
	
	public void sort(int arr[] ,int low , int high) {
		
		if(low <high) {
		int pIndex= partition(arr,low, high);
		sort(arr,low, pIndex-1);
		sort(arr, pIndex+1, high);
		}
		
	}
	
	int partition(int arr[], int low , int high) {
		int  pivot=high;
		int  pIndex=0;
		
		for(int i=0;i<high;i++) {
			if(arr[i]<=	arr[pivot]) {
				int temp=arr[i];
				arr[i]=arr[pIndex];
				pIndex++;
			}
		}
		
		int temp=arr[pivot];
		arr[pivot]=arr[pIndex];
		arr[pIndex]=temp;
		
		return pIndex;
	}
	
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	
	public static void  main(String args[]) {
		
		int arr[]= {4, 2,1, 5};
		QuickSort sort=new QuickSort();
		
		sort.sort(arr,0,arr.length-1);
		
		printArray(arr);
	}

}
