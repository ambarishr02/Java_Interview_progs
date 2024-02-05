package Array;

/**
 * MaxSumSubset
 */
public class MaxSumSubset {

     private static void MaxSumSubset1(int arr[]){
        int max_so_far=0;
        int currentSum=0;
     
        int startIndex=0, endIndex=0, s=0;

        for(int i=0; i<arr.length;i++){
            currentSum=currentSum+arr[i];
            if(currentSum>max_so_far){
                max_so_far=currentSum;
                startIndex=s;
                endIndex=i;
            }
            if(currentSum<0){
                currentSum=0;
                s=i+1;
            }
        }
        System.out.println("Maximum sum="+max_so_far);
        System.out.println("start Index="+startIndex+", endIndex="+endIndex);
        
     }

    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        MaxSumSubset1(arr);
    }
}