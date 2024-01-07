package DP;

public class Knapsack {
	
	public void solution(int profit[], int weights[], int capacity) {
		
		Integer dp[][]=new Integer[profit.length][capacity+1];
		int x=knapsackUtil(weights, profit, dp,capacity,0);
		System.out.println(x);
	}
	
	
	int knapsackUtil(int weights[], int profits[], Integer dp[][],int capacity , int currentIndex){
		
		if(capacity <=0 || currentIndex>=weights.length)
			return 0;
		
		if(dp[currentIndex][capacity]!= null){
			return dp[currentIndex][capacity];
		}
		int profit1=0;
		if(weights[currentIndex]<=capacity) {
			profit1=profits[currentIndex]+knapsackUtil(weights,profits,dp,capacity-weights[currentIndex] , currentIndex+1);
		}
		int profit2=knapsackUtil(weights,profits,dp,capacity , currentIndex+1);
		
		dp[currentIndex][capacity] = Math.max(profit1, profit2);
		return dp[currentIndex][capacity];
	}
	
	public static void main(String[] args) {
		
		Knapsack ks = new Knapsack();
	    int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
		ks.solution(profits, weights,7);
	}

}
