
public class MinimumJumps {

	
	 static void minimumJump(int arr[]) {
		 
		 if(arr.length>1) {
			 return ;
		 }
		 
		 int ladder=arr[0];
		 int stairs=arr[0];
		 
		  if(arr[0]==arr.length) {
			  System.out.println("No Jump required");
		  }
		 for(int i=1;i<arr.length;i++) {
			 
			 
			 
		 }
	 }
	
	
	public static void main(String args[]) {
		int arr[]= {1, 4, 2,6,1,2,7};
		
		minimumJump(arr);
	}
}
