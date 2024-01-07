package DFS;
/*
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

    a 1-day pass is sold for costs[0] dollars,
    a 7-day pass is sold for costs[1] dollars, and
    a 30-day pass is sold for costs[2] dollars.

 */
public class MinTicketCost {


    static void mincostTicket(int[] days, int[] cost){
        int[] dp=new int[days.length];
       int min= dfs(days, cost, 0, dp);
        System.out.println(min);
    }

    static int dfs(int days[], int[] cost, int index, int dp[]){
       // if(days.length==0) return;

        if(index==days.length) return 0;

        if(dp[index]!=0){
            return dp[index];
        }
        int op1=cost[0]+dfs(days, cost,index+1, dp);

        int k=index;
        while(k<days.length && days[k]<days[index]+7)
        k++;

        int op2=cost[1]+dfs(days, cost,k,dp);

        k=index;
        while(k<days.length && days[k]<days[index]+30)
        k++;

        int op3=cost[2]+dfs(days, cost,k,dp);

       int min= Math.min(op1, Math.min(op2, op3));
       dp[index]=min;
       return  min;
    }

   

    public static void main(String[] args) {
    
        int days[]={1,4,6,7,8,20};
        int cost[]={2,7,15};
        
        mincostTicket(days,cost);
    }
    
}
