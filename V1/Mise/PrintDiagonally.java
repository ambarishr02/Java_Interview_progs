
public class PrintDiagonally {
	
	
	static void printMatrixDiagonal(int arr[][], int n) {
		
	   int i, j,k;
//		for(k=0;k<n;k++) {
//			
//			i=k;
//			j=0;
//			while(i>=0) {
//				System.out.println(""+arr[i][j]);
//				i--;
//				j++;
//			}
//		
//		}
	 
	  for (k=1;k<n;k++) {
		  j=k;
		  i=n-1;
		  while(j<n) {
			  System.out.println(""+arr[i][j]);
				i--;
				j++;
		  }
		  
	  	}
	
	
	}
	
	public static void main(String[] args) 
    { 
        int mat[][] = { { 1, 2, 3, 4, 5}, 
                        { 6, 7, 8,9,10}, 
                        { 11,12,13,14,15},
                        { 16,17,18,19,20},
                        { 21,22,23,24,25}
                        }; 
  
        int n = 5; 
        printMatrixDiagonal(mat, n); 
    } 

}
