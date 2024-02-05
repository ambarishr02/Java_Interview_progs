package algo.Pattern.SlidingWindow;

public class MaxSumSubArrayOfSize {

    private static int subArray(int arr[], int size){
        int maxSum=0;
        int windowSum=0;
        for (int i = 0; i <=arr.length-size; i++) {
            windowSum=0;
          for (int j = i; j <i+size; j++) {
            windowSum+=arr[j];
          }
          maxSum= Math.max(windowSum, maxSum); 
        }
       return maxSum;
    }
    
    public static void main(String[] args) {
        int arr[]={2, 1, 5, 1, 3, 2};
        System.out.println(subArray(arr,3));

    }
}
