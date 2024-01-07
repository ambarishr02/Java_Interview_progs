package Array;

public class FIndTheFirstNlastOcc {
	
	 public static int firstOccrence(int[] nums, int target) {
		 int high=nums.length-1;
		 int low=0;
		 int mid=-1;
		 while(low<=high) {
			 mid=(low+high)/2;
			 if(nums[mid]==target && (mid==0|| nums[mid-1]<target))
				 return mid;
			 if(nums[mid]<target) {
				 low=mid+1;
			 }else
				 high=mid-1;
		 	}
		 	return mid;
		 }
	 
	 public static int LasttOccrence(int[] nums, int target) {
		 int high=nums.length-1;
		 int low=0;
		 int mid=-1;
		 while(low<=high) {
			 mid=(low+high)/2;
			 if(nums[mid]==target && (mid==nums.length-1|| nums[mid+1]>target))
				 return mid;
			 if(nums[mid]<target) {
				 high=mid-1; 
			 }else
				 low=mid+1;
		 	}
		 	return mid;
		 }
	
	 public static void main(String args[]) {
		 int arr[]= {4,4,4,4,4,4,8};
		System.out.println(LasttOccrence(arr, 4));
	 }

}

