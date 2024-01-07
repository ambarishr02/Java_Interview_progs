package DP;

public class Sebset {

    private static boolean subsetsum(int arr[], int sum){
        Boolean dp[][]=new Boolean[arr.length][sum+1];
        return checkSubsetSum(arr, dp, sum, 0);
    }

    private static boolean checkSubsetSum(int arr[], Boolean dp[][], int sum, int currentIndex){
        if(sum==0) return true;
        if(arr.length==0 || currentIndex>=arr.length){
            return false;
        }
        
        if(dp[currentIndex][sum]==null) {
            if(arr[currentIndex]<=sum){
               if(checkSubsetSum(arr, dp, sum-arr[currentIndex], currentIndex+1)){
                 dp[currentIndex][sum]=true;
                 System.out.println("=="+arr[currentIndex]);
                 return true;
               }
            }
            dp[currentIndex][sum]=checkSubsetSum(arr, dp, sum, currentIndex+1);
        }
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        int arr[]={1, 4, 3,7};
        System.out.println(subsetsum(arr, 10));
    }
}
