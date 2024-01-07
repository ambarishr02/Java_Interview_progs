package Arrays;

import java.util.Arrays;

public class CyclicSort {
    
    public static void main(String[] args) {
        int arr[]={2, 6, 4, 3, 1, 5};
        cylcicSort();
        MissingNumber();
        System.out.println(Arrays.toString(arr));
    }


    private static void MissingNumber() {

    }


    private static void cylcicSort(){
        int arr[]={2, 6, 4, 3, 1, 5};
        int i=0;
         while(i<arr.length){
            if(arr[i]==i+1){
                i++;
                continue;
            }else{
                swap(arr, i ,arr[i]-1);
            }
        }
         System.out.println(Arrays.toString(arr));
    }

    
    private static void swap(int[] arr, int i, int j) {
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
