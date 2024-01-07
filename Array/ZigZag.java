package Array;

import java.util.Arrays;

public class ZigZag {
	
	 public static void  zigzag(int arr[]) {
		 
		 boolean flag=true;
		 
		 for (int i=0;i<arr.length-1;i++) {
			 if(flag) {
				 if(arr[i]>arr[i+1]) {
					int temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				 }
			 }else {
				 if(arr[i]<arr[i+1]) {
					 int temp=arr[i];
						arr[i]=arr[i+1];
						arr[i+1]=temp; 
				 }
				 
			 }
			 flag=!flag;
		 }
		 
		 Arrays.stream(arr).forEach(s -> System.out.println(s)); 
	 }
	 
	
	public static void main(String[] args) {
		int arr[]= {4, 3, 7, 8, 6, 2, 1};
		zigzag(arr);
	}

}
