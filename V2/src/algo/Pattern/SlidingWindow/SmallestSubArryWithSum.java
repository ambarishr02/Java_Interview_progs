package algo.Pattern.SlidingWindow;

/**
 * SmallestSubArryWithSum
 * Given an array of positive numbers and a positive number ‘S,’ find the
length of the smallest contiguous subarray whose sum is greater than
or equal to ‘S’. Return 0 if no such subarray exists.
 */
public class SmallestSubArryWithSum {

     public static void SmallestSubArry(int arr[], int sum){
        int windowSum=0;
        int smallest=Integer.MAX_VALUE;
        int windowStart=0;
        for (int i = 0; i < arr.length; i++) {
            windowSum +=arr[i];
            while(windowSum>=sum){
               smallest=Math.min(smallest,i-windowStart+1);
               windowSum=windowSum-arr[windowStart];
               windowStart++; 
            }
        }

        System.out.println( smallest==Integer.MAX_VALUE?0: smallest);
     }

    public static void main(String[] args) {
        int arr[]={3, 4, 1, 1, 6};
       SmallestSubArry(arr,8);
    }
}