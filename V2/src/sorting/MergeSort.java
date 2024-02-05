package sorting;

import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int arr[], int low , int high){
        int mid=(low+high)/2;
        if(low<high){
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
       
    }

    static void merge(int arr[], int low, int mid, int high){
        int temp[]= new int[arr.length];
        int tempLowIndex=low;
        int tempArryIndex=low;
        int midIndex=mid+1;

       
        System.out.println("Before Merging:  ");
        System.out.println(Arrays.toString(arr));

        while(tempLowIndex<=mid && midIndex<=high){
            if(arr[tempLowIndex]<arr[midIndex]){
                temp[tempArryIndex++]=arr[tempLowIndex++];
            }else{
                temp[tempArryIndex++]=arr[midIndex++];
            }
        }

        while(tempLowIndex<=mid){
            temp[tempArryIndex++]=arr[tempLowIndex++];
        }
        while(midIndex<=high){
            temp[tempArryIndex++]=arr[midIndex++];
        }

        for (int i = low; i <=high; i++) { // Here we have keep in mind use low and high instead of zero for low.
            arr[i]=temp[i];
        }
        System.out.println("After merging");
        System.out.println(Arrays.toString(temp));
    }

    public static void main(String[] args) {
        int arr[]={10, 40, 80, 38};
        mergeSort(arr, 0, arr.length-1);
    }
    
}
