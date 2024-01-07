package Strings;

/**
 * Longest Common  Subsequence 
 * @author aramachandr
 *
 */
public class LCS {
	
	
	static void  printLCS(char[] X, char[] Y, int m, int n){
		int[][] lcs=new int[m+1][n+1];
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				
				if(i==0 || j==0) {
					lcs[i][j]=0;
				}
					else if(X[i-1]==Y[j-1]) {
						lcs[i][j]=lcs[i-1][j-1]+1;
					}else {
							lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
						}
					}
				}
		 int i=m;
		 int j=n;
		System.out.println(lcs[m][n]);
		 char[] finalString=new char[lcs.length+1];
		 int index=lcs.length+1;
		 
		 while( i>0 && j>0) {
			 
			 if(X[i-1]==Y[j-1]) {
				 finalString[i-1]=X[i-1];
				 
				 i--;j--; index--;
			 }
		 
			 else if(lcs[i-1][j]>lcs[i][j-1]) {
				i--;
			}else 
				j--;
			 
		 }
		
		 for(int k=0;k<finalString.length;k++) {
			 System.out.println(finalString[k]);
		 }
		 
	   }
		
		
	
	
	
	
	
	public static void main(String args[]) {
		
		String s1="ADBCEF", s2="BDF";
		
		printLCS(s1.toCharArray(),s2.toCharArray(),s1.length(), s2.length());
		
	}

}
