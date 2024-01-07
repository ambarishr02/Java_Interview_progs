package Practice.Sorting;

public class HeapSort {
	
	/**
	 * Divide array iteration frm n/2-1  till 0
	 *  Heapify the such that max element at the root (heapify) 
	 *  if 
	 */
	
	public void sort(int arr[], int n) {
		
		for(int i=n/2-1;i>=0;i--) {
			heapify(i, arr,n);
		}

		for (int i = n-1; i >0; i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(0, arr, i);
		}

	}
	
	
	
	public void heapify(int i, int[] arr, int n) {
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		
		if(l<n && arr[l]>arr[largest]) {
			largest=l;
		}
		if(r<n && arr[r]>arr[largest]) {
			largest=r;
		}
		if(largest!=i) {
			int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  			heapify(largest, arr,n);
		}
	}
	
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	
	public static void main(String args[]) {
		
		int arr[]= {3,6,1, 2, 4};
		HeapSort heapSort=new HeapSort();
		heapSort.sort(arr, arr.length);
		printArray(arr);
	}

}
