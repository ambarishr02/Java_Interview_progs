package sorting;

import java.util.Arrays;

public class HeapSort {

    static void Sort(int arr[],int n){

        for (int i =n/2-1; i >=0; i--) {
            heapify(arr,i, arr.length);
        }

        for (int i = n-1; i >0; i--) {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr, 0, i);
        }
    }
    
    static void heapify(int arr[], int i, int n){
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n && arr[l]>arr[largest]){
            largest=l;
        }
        if(r<n && arr[r]>arr[largest]){
            largest=r;
        }
        if(largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;
            heapify(arr, largest, n);
        }
     }
    
    public static void main(String[] args) {
        int arr[]={20,10, 80 ,40};
        Sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
