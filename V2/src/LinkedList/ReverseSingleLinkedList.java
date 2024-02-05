package LinkedList;

import Util.LinkedListUtil.SingleLinkedNode;

/**
 * ReverseSingleLinkedList
 */
public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedNode node1 = new SingleLinkedNode(10);
        SingleLinkedNode node2 = new SingleLinkedNode(20);
        SingleLinkedNode node3 = new SingleLinkedNode(30);
        SingleLinkedNode node4 = new SingleLinkedNode(40);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        SingleLinkedNode.printSingleLinkedList(node1);
        System.out.println("=============");
         SingleLinkedNode reverse= ReverseRecursively(node1);
        SingleLinkedNode.printSingleLinkedList(reverse);
   
        //  System.out.println("=============");
        //  SingleLinkedNode reverse2=reverseIteratively(node4);
        // SingleLinkedNode.printSingleLinkedList(reverse2);

    }

    static SingleLinkedNode reverseIteratively(SingleLinkedNode head) {
      SingleLinkedNode current=head;
      SingleLinkedNode previous=null;
      SingleLinkedNode next=null;

        while(current!=null){
            next=current.getNext();
            current.setNext(previous);
            previous=current;
            current=next;
        }
       
      return previous;
        
    }

    static SingleLinkedNode ReverseRecursively(SingleLinkedNode head) {
        if(head==null){
            return null;
        }
        if(head.getNext()==null) return head; 
        SingleLinkedNode node=ReverseRecursively(head.getNext()); 
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }


    
}