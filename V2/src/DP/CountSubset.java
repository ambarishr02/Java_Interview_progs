package DP;

/**Given a set of positive numbers, find the total number of subsets whose
sum is equal to a given number ‘S’.*/
public class CountSubset {
    
   static int countSubsetSum(int arr[],int sum){
        Integer dp[][]=new Integer[arr.length][sum+1];
       return dpUtil(arr, sum, 0, dp);
    }

   static Integer dpUtil(int arr[], int sum, int currentIndex, Integer dp[][]){
       if(sum==0)
        return 1;
       if(currentIndex>=arr.length || arr.length ==0){
           return 0;
       } 

       if(dp[currentIndex][sum]!=null){
           return dp[currentIndex][sum];
       }
       int sum1=0;
       if(arr[currentIndex]<=sum){
         sum1= dpUtil(arr, sum-arr[currentIndex], currentIndex+1, dp);
       }
       int sum2=dpUtil(arr, sum, currentIndex+1, dp);
       dp[currentIndex][sum]=sum1+sum2;
       return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        int arr[] ={1,1,2};
      System.out.println(countSubsetSum(arr,2));
    }
}
