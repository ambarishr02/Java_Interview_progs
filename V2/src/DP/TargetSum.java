package DP;
// Given a set of positive numbers (non zero) and a target sum ‘S’. Each
//number should be assigned either a ‘+’ or ‘-’ sign. We need to find out total
//ways to assign symbols to make the sum of numbers equal to target ‘S’.
public class TargetSum {
    

    static int  targetSum(int arr[], int sum){
        int totalSum=0;
        for(int n:arr){
            totalSum+=n;
            if(n<1) return -1;
        }

        if(totalSum<sum || (sum+totalSum)%2 ==1){
            return 0;
        }

        return countSubset(arr, sum+totalSum/2);
      
    }

     static int countSubset(int arr[], int sum){
        int dp[][]=new int[arr.length][sum+1];
        for(int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }

        for(int s=1;s<=sum;s++){
            dp[0][s]=(arr[0]==s ?1 :0 );
        }
        return 0;
     }


    

    public static void main(String[] args) {
        int arr[]={1, 1, 2, 3} ;
        int sum=1;
        //output 3 ways to make sum    
        targetSum(arr, sum);
    }
}
