package Array;

public class FIndTheElementInTheSortedInfinteArray {
	
	
	 static int findPos(int arr[], int k) {
		 int l=0 ,h=1;
		 int mid=0;
		 while(l<h) {
			 mid= (l+h)/2;
			 
			 if(arr[mid]==k)
				 return mid;
			 
			 if(k-arr[mid]>0)
				 h=h+1;
			 else
				l=h; 
		 }
		 
		 return mid;
	 }
	 
	static int binarySearch(int arr[], int low ,int high,int key){
		 while(low<high) {
			 int mid=(low+high)/2;
			 
			 if(arr[mid]==key) return mid;
			 
			 if(key >arr[mid]) {binarySearch(arr,mid+1, high,key);
			 } else {
		 		binarySearch(arr,low, mid-1,key);
			 }
		 }
		return -1;
	 }
	 
	 static int findPosV2(int arr[], int k) {
		 int  value=arr[0];
		 int h=1,l=0;
		 
		 while(value<k) {
			 l=h;
			 
			 if(2*h<arr.length-1) {
				 h=2*h;
			 }else {
				 h=arr.length-1;
			 }
			 
			 value=arr[h];
		 }
		 
		return binarySearch(arr,l,h,k);
	 }
	 
	
	// Driver method to test the above function 
    public static void main(String[] args)  
    { 
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,  
                            100, 130, 140, 160, 170, 200,500, 800,1000}; 
        long start= System.currentTimeMillis();
        int ans = findPos(arr,200); 
         System.out.println("time taken:"+(System.currentTimeMillis()-start)); 
        System.out.println("Element found at index " + ans); 
         
         start= System.currentTimeMillis();
         ans = findPosV2(arr,200); 
         System.out.println("time taken-2:"+(System.currentTimeMillis()-start)); 
       
         if (ans==-1) 
            System.out.println("Element not found"); 
        else
            System.out.println("Element found at index " + ans); 
    } 

}
