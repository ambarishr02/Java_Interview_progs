package Tree;

import java.util.Stack;

public class PrintBSTInASC {
    

    // Iterative function to print a complete binary search tree in increasing order
    public static void printIncreasingOrder(int[] keys)
    {
        // base case
        if (keys == null || keys.length == 0) {
            return;
        }
 
        // create a stack to store array indices
        Stack<Integer> s = new Stack<>();
 
        // start with the root node (the first array element)
        int r = 0;
 
        // push the root node into the stack
        s.add(r);
 
        // run till stack is empty
        while (!s.isEmpty())
        {
            // push the left child of the current node into the stack
            // and repeat the same for the left child
            while (r == s.peek() && r*2 + 1 < keys.length)
            {
                r = r*2 + 1;
                s.add(r);
            }
 
            // print the last processed node and remove it from the stack
            r = s.pop();
            System.out.print(keys[r] + " ");
 
            // push the right child of the current node into the stack
            if (r*2 + 2 < keys.length)
            {
                r = r*2 + 2;
                s.add(r);
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 18, 25 };
        printIncreasingOrder(keys);
    }
}

