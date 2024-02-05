package Tree;
/**
 * Print complete Binary Search Tree (BST) in increasing order
 * https://www.techiedelight.com/print-complete-binary-search-tree-increasing-order/
 * 
 * input [15, 10, 20, 8, 12, 18, 25].
 * o/p [8, 10, 12, 15, 18, 20, 25]
 */
public class PrintBST {
    
    // using i  then left 2*i+1 and right = 2*i+2

    //Recursive 
    //As we are already know it BST -left-center-right
    //use Inorder 
   static void  printIncreasingOrder(int arr[], int low, int high){
        if(low>high) return;
        printIncreasingOrder(arr, 2*low+1, high);
        System.out.println(arr[low]);
        printIncreasingOrder(arr, 2*low+2, high);
    }
    
    public static void main(String[] args) {
        int arr[]=  { 15, 10, 20, 8, 12, 18, 25 };
        printIncreasingOrder(arr, 0, arr.length - 1);
    }


}
