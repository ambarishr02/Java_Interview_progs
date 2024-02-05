package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of unsorted numbers, find all unique triplets in it that
//add up to zero.
public class TrippleSum {

    public static List<List<Integer>> TripletSum(int arr[], int sum){
        List<List<Integer>> triplets=new ArrayList<>();
        Arrays.sort(arr); //sort the array then use two for loops.  Nlogn for searching and N2 for searching so it N2
        for (int i = 0; i < arr.length; i++) {
            int left=i+1;
            int right=arr.length-1;
            int targetSum=-arr[i];
           while(left<right){
               int currentSum=arr[left]+arr[right];
               if(currentSum==targetSum){
                   triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
               } 
               if(currentSum>targetSum){
                    left++;
                }else
                 right--;

           }

        }
        return triplets;
    }
    public static void main(String[] args) {
        
    }
}
