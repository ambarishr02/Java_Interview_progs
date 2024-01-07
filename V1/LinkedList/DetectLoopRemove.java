package LinkedList;

public class DetectLoopRemove {
    static Node head;

    

    public void detectLoopRemove(Node headNode) {
        if( headNode==null) {
            System.out.print("List is empty");
        }
        Node slow_ptr=headNode;
        Node fast_ptr=headNode;
        while(slow_ptr!=null&&fast_ptr!=null&&fast_ptr.next!=null){
            fast_ptr=fast_ptr.next.next;
            slow_ptr=slow_ptr.next;
            if(slow_ptr==fast_ptr){
               removeLoopV2(slow_ptr, headNode);
               System.out.println("Loop Found and Removed ");
               Node.displayList(head);
               break;
            }
        }
            
    }

   void removeLoopV1(Node loopNode, Node head){
        Node temp_ptr=head;
        Node loop_ptr;
        while(true){
            loop_ptr=loopNode;
         while(loop_ptr.next!=loopNode && loop_ptr.next!=temp_ptr){
             loop_ptr=loop_ptr.next;
         }
         if(loop_ptr.next==temp_ptr){
            break;
         }
         temp_ptr=temp_ptr.next;
        }
        loop_ptr.next=null;
    }
   
   
   void removeLoopV2(Node loopNode , Node head) {
	   Node ptr1=loopNode;
	   int count=0;
	   while(ptr1.next!=loopNode) {
		   ptr1=ptr1.next;
		   count++;
	   }
	   Node ptr2=head;
	   while(count>=0) {
		   ptr2=ptr2.next;
		   count--;
	   }
	   ptr1=head; 
	   Node prev=null;
	   while(ptr1!=ptr2) {
		   ptr1=ptr1.next;
		   prev=ptr2;
		   ptr2=ptr2.next;
	   }
		prev.next=null; 
		
   }


    public static void main(String[] args){
       DetectLoopRemove list=new DetectLoopRemove();
        head =new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=head.next;
        list.detectLoopRemove(head);
    }
}
