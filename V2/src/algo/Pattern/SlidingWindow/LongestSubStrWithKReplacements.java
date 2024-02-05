package algo.Pattern.SlidingWindow;

public class LongestSubStrWithKReplacements{
    
    public static Integer findLongestSubstringWithDistictChar(Integer arr[], int k){

        int windowStart=0;
       
        int maxLength=Integer.MIN_VALUE;
        int maxOnesCount=0;
        for (int i = 0; i < arr.length; i++) {
          if(arr[i]==1){
              maxOnesCount++;
          }
          if(i-windowStart+1-maxOnesCount>k){
              if(arr[windowStart]==1){
                  maxOnesCount--;
              }
              windowStart++;
          }
            maxLength=Math.max(maxLength, i-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Integer arr[]={0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(findLongestSubstringWithDistictChar(arr, 2));
    }
}
