package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * @param args
 */
public class AddUptoSum {

   static int[]  findIndex(int arr[], int sum){

    Map<Integer, Integer> map =new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        if(map.get(sum-arr[i])!=null){
            return new int[] {map.get(sum-arr[i]), i};
        }
        map.putIfAbsent(arr[i], i);
    }
    return arr;
    }
    
    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        int sum=9;
      int index[]=  findIndex(arr, sum);
      System.out.println(index[0]+","+index[1]);
    }
}
