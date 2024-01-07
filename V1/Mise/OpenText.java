package Mise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OpenText {
	
	public static int getRandomInteger(int maximum, int minimum){ return ((int) (Math.random()*(maximum - minimum))) + minimum; }

	

	public static int[] solution1(int n) {
		
		// ArrayList<Integer> list = new ArrayList<Integer>(n);
		 
		int arr[]=new int[n];
		 for( int i=0;i<n;i++) {
			 arr[i]=getRandomInteger(1000, 1);;
		 }
		 
		 for( int i=0;i<n;i++) {
			System.out.println(arr[i]);
		 }
		 return arr;
	}
	
	
	public static int solution2(int [] A) {
		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int max=0;
		for(Integer i=0;i<A.length;i++) {
			if(map.containsKey(A[i])) {
				Integer value=map.get(A[i]);
				 value+=1;;
				map.put(A[i],value);
				if(map.get(A[i])==A[i] && map.get(A[i])>max) {
					max=map.get(A[i]);
				}else  if(max==A[i]){
					max=0;
				}
				
			}else {
				map.put(A[i], 1);
				if(map.get(A[i])>max && map.get(A[i])==A[i]) {
					max=map.get(A[i]);
				}
			}
		}
		
		 return max;
    }
		
	
	
	
	public static void main(String[] args) {
		
		solution1(10);
		
		int arr[]= {3,1, 4,1, 5};
		
		System.out.println(solution2(arr));
	}
}
