package LinkedList;



public class ReverseLinkedList {
    Node head;



    Node reverseList(Node head ){
        Node prev=null;
        Node current=head;
        Node next;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;

    }
    
    
    static Node reverse(Node head)
    {
        if (head == null || head.next == null)
            return head;
 
        /* reverse the rest list and put
        the first element at the end */
        Node rest = reverse(head.next);
        head.next.next = head;
 
        /* tricky step -- see the diagram */
        head.next = null;
 
        /* fix the head pointer */
        return rest;
    }
    public static void main(String[] args){
      ReverseLinkedList list = new ReverseLinkedList();
      list.head =new Node(1);
      list.head.next=new Node(2);
      list.head.next.next=new Node(3);
      list.head.next.next.next=new Node(4);
       Node.displayList(list.head);
     //  Node reverse= list.reverseList(list.head);
       Node reverse=reverse(list.head);
       Node.displayList(reverse);
    }
  

}