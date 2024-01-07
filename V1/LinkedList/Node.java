package LinkedList;

public class Node {
    Integer data;
    Node next;
     public Node(int data){
         this.data = data;
         this.next = null;
     }


   static void displayList(Node head){
       while (head!=null){
           System.out.print(head.data+"->");
           head= head.next;
       }
       System.out.print("NULL");
   }
}
