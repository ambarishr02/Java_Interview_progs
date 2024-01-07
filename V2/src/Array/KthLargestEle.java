package Arrays;

import java.util.PriorityQueue;

public class KthLargestEle {
    
    public static void main(String[] args) {
        int arr[]={3,2,3,1,2,4,5,5,6}; 
        int k=4;

        findKthLargest(arr, k);
    }

    private static void findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        // System.out.println(minHeap.peek());

        for (int i = k; i < arr.length; i++) {
            
            if(arr[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }            
        }
        // while(minHeap.size()>arr.length-k+1){
        //     minHeap.poll();
        // }
        System.out.println(minHeap.peek());


        
    }
    
}
