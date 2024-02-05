package Strings;


public class LongCommonSubstring {

	
	static String commonSubstring(char[] s1, char[] s2, int m, int n) {
		
		if(m==0 || n==0) {
			return null;
		}
		
		int dp[][]=new int[m+1][n+1];
		int maxLength=0;
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
					
				}	
				else if(s1[i-1]==s2[j-1]) {
					dp[i][j]=1+ dp[i-1][j-1];
					maxLength= Math.max(maxLength, dp[i][j]);
				}
			}
			
		}
		
		System.out.println(maxLength);
		
		return null;
		
	}
	
	public static void main(String[] args) {
		String s1="ABDC"; String s2="BC";
		commonSubstring(s1.toCharArray(),s2.toCharArray(), s1.length(), s2.length());
	}

}
