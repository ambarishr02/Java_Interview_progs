package Mise;

public class NumberWithoutConsegativeOnes {
	
	public static void main(String args[]) {
		
		System.out.println(countStrings(2));
		
	}

	static int countStrings(int n){
		int[] a=new int[n];
		int[] b=new  int[n];
		
		a[0]=1; b[0]=1;
		for(int i=1;i<n;i++) {
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1];
		}
		
		return (a[n-1]+b[n-1]);
	}
}
