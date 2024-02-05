package Array;

import java.util.Arrays;

/**
 * You are given an unsorted array containing n numbers taken from
the range 1 to n . The array can have duplicates, which means that
 some numbers will be missing.
 Check the index and if its same do nothig othewise place current number to its right place by swapping it.

 */
public class CyclicSort {

  public static void main(String[] args) {
 
   // cylcicSort();
  //  MissingNumber();
      //  MissingNumber();
    missingNumber();
  }


  private  static void missingNumber(){
    int nums[] = {0,2, 3,1};
    int i=0;
    while(i<nums.length){
      if(nums[i]!=i){
        swap(nums, i, nums[i]);
      }else
        i++;
    }
    System.out.println(nums.toString());
  }













  //arr[i]=arr[arr[i]]
  /*
   * Array has duplicate number find the missing number
   */
  private static void MissingNumber() {
    int nums[] = {2, 4, 1, 2};
    int i = 0;
    while (i < nums.length) {
      int x=nums[i];
      int y=nums[nums[i]-1];
    System.out.println(x+","+y);
      // if (nums[i] < nums.length && x != y) 
      //     swap(nums,i,nums[i]-1); 
      // else 
        i++;
    }
    // find the first number missing from its index, that will be our required number
    for (i = 0; i < nums.length; i++) 
     if (nums[i] != i-1 ) 
        System.out.print(i);

  }

  private static void MisssingAllNumber(){
     int nums[] = { 2, 6, 2, 3, 1, 5 };
    int i = 0;
    while (i < nums.length) {
      if (nums[i] < nums.length && nums[i] != nums[nums[i]-1]) 
          swap(nums,i,nums[i]); 
      else 
      i++;
    }
  }

  //number are in the range 1 -> n
  private static void cylcicSort() {
    int arr[] = { 2, 6, 4, 3, 1, 5 };
    int i = 0;
    while (i < arr.length) {
      if (arr[i] == i + 1) {
        i++;
        continue;
      } else {
        swap(arr, i, arr[i] - 1);
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
