package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncresingSubseq {
    
    static void LISDP(int arr[]){
        int dp[]=new int[arr.length];
        dp[0]=1;
        for (int i = 1; i < arr.length; i++) {
            dp[i]=1;
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                } 
            }
        }
        
     //  System.out.println(Arrays.binarySearch(dp, 8));
       System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    //    int max= Collections.max(Arrays.asList(dp));
    //     System.out.println(max);
    }

    // static int binarySearch(List<Integer> lis, int key){
    //     int low=0, h=lis.size()-1, ans=Integer.MAX_VALUE;
       
    //     int mid=lis.size()/2;
    //   //  if(lis.get(mid))
    // }

    static void LISWithBinarSearch(int arr[]){
        ArrayList<Integer> lis=new ArrayList<>();
      
        lis.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int pos =Collections.binarySearch(lis, arr[i]);
           // int pos=Arrays.binarySearch(lis, arr[i]);
         //  System.out.println(lis.get(lis.size();
            if(pos<0){
               lis.add(arr[i]);
                }else{
                lis.add(pos, arr[i]);
            }
        }
 
        System.out.println(lis.size());
    }
    public static void main(String[] args) {
        int arr[]={4,2,3,6,10,1,12};
        LISDP(arr);
        LISWithBinarSearch(arr);
    }
}
