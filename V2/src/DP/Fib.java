package DP;

//Find nth fibnoci number
public class Fib {

  public static void main(String[] args) {
    int n=5;
    System.out.println(fib(n));
    System.out.println(fib_dp(n));

  }

  private static int fib(int n) {
    if (n < 2) return n;

    return fib(n - 1) + fib(n - 2);
  }

  private static int fib_dp(int n){
    if(n<2) return n;

    int dp[]=new int[n+1];
    dp[0]=0;
    dp[1]=1;
    for (int i = 2; i <= n; i++) {
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];

  }
}
