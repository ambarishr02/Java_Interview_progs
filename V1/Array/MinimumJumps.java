package Array;

public class MinimumJumps {

	static int jumps(int arr[]){
	
		if(arr.length<=1) {
			return 1;
		}
			/*
			 *   3 2 4
			 *   --
			 */
	int ladder=arr[0];
	int stairs=arr[0];
	int jump=1;
	for (int i=1;i<arr.length;i++) {
		
		if(i==arr.length-1) {
			return jump;
		}
		if(i+arr[i]>ladder ) {
			ladder=arr[i];
			}
		stairs--;
		
		if(stairs==0) {
			jump++;
			stairs=ladder-i;
			if(i+stairs>=arr.length-1)
				return jump;
		}
		
		}
		return jump;
	}
	
	public static void main(String[] args) {
		int arr[]= { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		System.out.println(jumps(arr));
	}
}
