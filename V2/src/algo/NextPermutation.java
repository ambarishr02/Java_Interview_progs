package algo;

/**
 *  Next lexicographical permutation 
 *  input :[1,2,3] o/p : [1,3,2]  // Find next greater value  with permutations
 *  With constant memory
 *  Approach : Find the pivot element  (Find the trasition point from end of the array )
 *  Trasition point  is. element smaller/greater  than next  element i.e changing from asceding to decending or viceversa
 *  input =[1,4,9.5,7,6,6,4]
 *  Find_Trans_Index=Index_3 and  find next greter number  from Index_3 to end then swap the values
 *  [1,4,9, 6 ,7,6, 5 ,4]
 *  finally reverse the second half element  [7,6,,5,4]
 *  [1,4,9,6,4,5,6,7] =output
 *   
*/
public class NextPermutation {

     static void reverse(int arr[], int start, int end){
        for (int i = start; i <(start+end)/2+1; i++) {
            swap(arr, i, end-(i-start));
        }
       
     }

     static void swap(int arr[], int i,int j ){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
     
     }

    static void permutation(int arr[]){
        int transition_index=-1;
        for (int i = arr.length-1; i >0; i--) {
            System.out.println(arr[i-1]+" < "+arr[i]);
            if(arr[i-1]<arr[i]){
                System.out.println("Te1");
                transition_index=i-1;
                break;
            }
        }
        if(transition_index==-1){
            reverse(arr, 0, arr.length-1);
        }else{
            int nextgreterNumber=transition_index+1;
            for (int j=arr.length-1 ; j > nextgreterNumber; j--) {
                if(arr[j]>arr[transition_index]){
                    nextgreterNumber=j;
                    break;
                }
            }
            swap(arr, nextgreterNumber, transition_index);
            reverse(arr, transition_index+1, arr.length-1);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    } 
    public static void main(String[] args) {
        int arr[]={1,4,9,5,7,6,6,4};
        permutation(arr);
    }
    
}
