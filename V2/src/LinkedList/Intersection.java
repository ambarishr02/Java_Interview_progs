package LinkedList;

import Util.LinkedListUtil.SingleLinkedNode;
/*
 * Given two lists sorted in increasing order, return a new list representing their intersection. 
 * The new list should be made with its own memory – the original lists should not be changed.
 */
public class Intersection {
// First List: 1 —> 4 —> 7 —> 10 —> null
// Second List: 2 —> 4 —> 6 —> 8 —> 10 —> null
 
// Output: 4 —> 10 —> null


public static SingleLinkedNode sortedIntersect(SingleLinkedNode a, SingleLinkedNode b){
   if(a==null || b ==null )
        return null;

   SingleLinkedNode result=null;
    
   while(a!=null && b!=null){

    if(a.getData()==b.getData()){
        if(result==null){
             result= new SingleLinkedNode(a.getData(), null);
        }else{
            result.setNext(new SingleLinkedNode(a.getData(), null));
        }
        a=a.getNext();
         b=b.getNext();
    }else if(a.getData()<b.getData()){
        a=a.getNext();
    }else{
        b=b.getNext();
    }

   }
   
   return result;

}

public static void printList(String msg, SingleLinkedNode head)
    {
        System.out.print(msg);
 
        SingleLinkedNode ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.getData() + " —> ");
            ptr = ptr.getNext();
        }
 
        System.out.println("null");
    }


public static SingleLinkedNode intersectionPoint(SingleLinkedNode a , SingleLinkedNode b){
    SingleLinkedNode result=null;

    return result;
}    

public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
 
        SingleLinkedNode a = null;
        for (int i = keys.length - 1; i >= 0; i = i - 3) {
            a = new SingleLinkedNode(keys[i], a);
        }
 
        SingleLinkedNode b = null;
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
            b = new SingleLinkedNode(keys[i], b);
        }
 
        // print both lists
        printList("First List: ", a);
        printList("Second List: ", b);
 
        SingleLinkedNode head = sortedIntersect(a, b);
        printList("After Intersection: ", head);
    }


}
