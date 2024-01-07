package DP;

public class Knapsack {

    public static void main(String[] args) {
        int[] profits = { 1, 6, 10, 16 };
        int[] weights = { 1, 2, 3, 5 };
        int capacity = 7;
        findMaximumProfit(weights, profits, capacity);
    }

    static void findMaximumProfit(int weights[], int profits[], int capacity) {
        Integer dp[][] = new Integer[weights.length][capacity + 1];
        int max = knapsackUtil(weights, profits, capacity, dp, 0);
        System.out.println("====>"+max);
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
      //  int max2= bottomUpApproch(weights, profits, capacity);
    //    System.out.println(max2);
    }

    private static int knapsackUtil(int[] weights, int[] profits, int capacity, Integer[][] dp, int currentIndex) {
        if(capacity<=0 ||currentIndex>=weights.length){
            return 0;
        }
        if(dp[currentIndex][capacity]!=null){
            return dp[currentIndex][capacity];
        }

        int profit1=0; int profit2=0;
        if(weights[currentIndex]<=capacity)
           profit1=profits[currentIndex]+knapsackUtil(weights, profits, capacity-weights[currentIndex], dp, currentIndex+1);
        profit2 =knapsackUtil(weights, profits, capacity, dp, currentIndex+1);
        dp[currentIndex][capacity]=Math.max(profit1, profit2);
        System.out.println(currentIndex+" ,"+capacity+"=="+dp[currentIndex][capacity]);
        return dp[currentIndex][capacity];
    }

    static int bottomUpApproch(int weights[], int profits[], int capacity){
        if(weights.length<=0 || profits.length<=0|| capacity<=0){
            return 0;
        }
        Integer dp[][]=new Integer[weights.length][capacity+1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }

        for ( int i = 0; i <=capacity; i++) {
            if(weights[0]<=i){
                dp[0][i]=profits[0];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1=0; int profit2=0;
                if(weights[i]<=c){
                    profit1=profits[i]+dp[i-1][c-weights[i]];
                }
                profit2=dp[i-1][c];
                dp[i][c]=Math.max(profit1, profit2);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[weights.length-1][capacity];
    }
}
