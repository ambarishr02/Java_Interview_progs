package Stk;

import java.util.Stack;

/**
 * PreviousSmaller
 * https://www.techiedelight.com/previous-smaller-element/
 */
public class PreviousSmaller {

    static void findPreviousSmaller(int arr[]) {
        Stack<Integer> stk=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            
            while(!stk.isEmpty()){
                if(stk.peek()<arr[i]){
                    System.out.println(stk.peek());
                    break;
                }else
                stk.pop();
            }

            if(stk.isEmpty()){
               System.out.println("-1");
            }

            stk.push(arr[i]);
        }
    }

    static void findNextGreaterEle(int arr[]){
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
           while(!s.isEmpty()){
            if(s.peek()>arr[i]){
                System.out.print(s.peek()+",");
                break;
            }else{
                s.pop();
            }
           }
           if(s.isEmpty()){
            System.out.print("-1,");
           }
           s.push(arr[i]);
        }
        
    }

    public static void main(String[] args) {
      //  int[] arr = { 2, 5, 3, 7, 8, 1, 9 };
      //  findPreviousSmaller(arr);
      int arr1[]={2, 7, 3, 5, 4, 6, 8};
      findNextGreaterEle(arr1);
    }
}