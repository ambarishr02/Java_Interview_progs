package Array;
public class FindZeroIndx {
    
    
    // Find the index of 0 to replace with 1 to get the maximum sequence
    // of continuous 1's

    // 0 0 1 1 1
    public static int findIndexofZero(int[] A)
    {
        int max_count = 0;          // stores maximum number of 1's (including 0)
        int max_index = -1;         // stores index of 0 to be replaced
 
        int prev_zero_index = -1;   // stores index of previous zero
        int count = 0;              // stores current count of zeros
 
        // consider each index `i` in the array
        for (int i = 0; i < A.length; i++)
        {
            // if the current element is 1
            if (A[i] == 1) {
                count++;
            }
            // if the current element is 0
            else {
                // reset count to 1 + number of ones to the left of current 0
                count = i - prev_zero_index;
 
                // update `prev_zero_index` to the current index
                prev_zero_index = i;
            }
 
            // update maximum count and index of 0 to be replaced if required
            if (count > max_count)
            {
                max_count = count;
                max_index = prev_zero_index;
            }
        }
 
        // return index of 0 to be replaced or -1 if the array contains all 1's
        return max_index;
    }


    public static int findIndexofZeroReplaceV2(int[] arr){
         {
            int max_count = 0;  // for maximum number of 1 around a zero
            int max_index=0;  // for storing result
            int prev_zero = -1;  // index of previous zero
            int prev_prev_zero = -1; // index of previous to previous zero
      
            // Traverse the input array
            for (int curr=0; curr<arr.length; ++curr)
            {
                // If current element is 0, then calculate the difference
                // between curr and prev_prev_zero
                if (arr[curr] == 0)
                {
                    // Update result if count of 1s around prev_zero is more
                    if (curr - prev_prev_zero > max_count)
                    {
                        max_count = curr - prev_prev_zero;
                        max_index = prev_zero;
                    }
      
                    // Update for next iteration
                    prev_prev_zero = prev_zero;
                    prev_zero = curr;
                }
            }
      
            // Check for the last encountered zero
            if (arr.length-prev_prev_zero > max_count)
                max_index = prev_zero;
      
            return max_index;
        }
    }
 
    public static void main (String[] args)
    {
        int[] A = { 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
 
       // int index1 = findIndexofZeroReplaceV2(A);
         int index = findIndexofZero(A);
 
        if (index != -1) {
            System.out.print("Index to be replaced is " + index);
          //    System.out.print("Index to be replaced is " + index1);
        }
        else {
            System.out.print("Invalid input");
        }
    }

 
}
