package DP;

public class LongestSubString {

    static void findLongestSubString(String s1, String s2) {
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        int maxLength =0;
        for (int i = 1; i <=s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    maxLength=Math.max(maxLength,dp[i][j]);
                }
            }
        }
        System.out.println(maxLength);

      //  findLongestSubStringUtil(s1, s2, dp,0 ,0,0);
    }

    static int findLongestSubStringUtil(String s1, String s2, Integer dp[][],int i, int j,int count){
        if(i==s1.length() ||j==s2.length()){
            return count;
        }
        return 0;

    }

    public static void main(String[] args) {
        String s1 = "passport";
        String s2 = "passpt";
        findLongestSubString(s1, s2);
    }
}
