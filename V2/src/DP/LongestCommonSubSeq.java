package DP;

public class LongestCommonSubSeq {

    static void subSequence(String s1, String s2){
        Integer[][] dp=new Integer[s1.length()][s2.length()];
        System.out.println(findSubsequence(s1, s2, dp, 0,0));
     }
    

    static int findSubsequence(String s1, String s2, Integer dp[][], int s1Index, int s2Index){

        if(s1Index==s1.length() || s2Index==s2.length()){
            return 0;
        }

        if(dp[s1Index][s2Index]==null){
            if(s1.charAt(s1Index)==s2.charAt(s2Index)){
                dp[s1Index][s2Index]=1+findSubsequence(s1, s2, dp, s1Index+1, s2Index+1);
            }else{
                int c1=findSubsequence(s1, s2, dp, s1Index+1, s2Index);
                int c2=findSubsequence(s1, s2, dp, s1Index, s2Index+1);
                dp[s1Index][s2Index]=Math.max(c1, c2);
            }
        }
        return dp[s1Index][s2Index];
    }
    public static void main(String[] args) {
       String s1="abdca";
       String s2="cbda";
        subSequence(s1, s2);
    }
}
