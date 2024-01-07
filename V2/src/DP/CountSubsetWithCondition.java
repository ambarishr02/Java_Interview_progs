package DP;

import java.util.Arrays;
/**
 * You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
 */
public class CountSubsetWithCondition {

    public static int numSubseq(int[] nums, int target) {
       Arrays.sort(nums);
       int low=0;
       int high=nums.length-1;
       int count=0;
     
       while(low<high){
           if(nums[low]+nums[high]<=target){
               count +=Math.pow(2, high-1);  //on choosing low and right , the number possible arrangement b.w low and high will be calculated.
               low++;
           }
          else
               high--;
         
       } 
       return  (int) (count % (Math.pow(10,9))+7);
     }
    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        System.out.println(numSubseq(nums, 9));
    }
}
