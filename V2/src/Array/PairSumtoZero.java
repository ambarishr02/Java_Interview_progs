package Array;

import java.util.Arrays;

public class PairSumtoZero {
	
	 static void printSubArraysWithZero(int arr[]){
		 
		 if (arr.length==0) return ;
		 
		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));
		int j =arr.length-1;
		for( int i=0;(i<arr.length && i<j);){
			if(arr[i]+arr[j]==0){
				System.out.println(arr[i]+""+arr[j]);
			}else if(arr[i]+arr[j]>0 && i<j){
				j--;
			}else if(arr[i]+arr[j]<0 && i<j){
				i++;
			}
		}
	 }

	public static void main(String[] args) {
		int arr[]= { 4, 2, -3, -1, 0, 6 };
		printSubArraysWithZero(arr);
	}
}
