package Array;

import java.util.HashMap;
import java.util.Map;

public class PairOfSum {
	
	
	public static int[] pair(int[] arr, int sum) {
		
		Map<Integer, Integer> map=new HashMap<>();
		
		for(int i=0; i < arr.length;i++) {
			
			if(map.containsKey(sum-arr[i])) {
				return new int[] { map.get(sum-arr[i]),i};
			}else {
				map.put(arr[i], i);
			}
		}
		
		return new int[] {-1, -1};
		
	}

	public static void main(String[] args) {
		int arr[]= {1, 2, 3 ,4, 5, 6};
		int [] result =pair(arr,6);
		System.out.println(result[0]+","+result[1]);;
	}
}