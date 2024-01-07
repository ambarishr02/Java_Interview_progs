package LinkedList;

class AddNumberList {
    static Node head1, head2;

    static class Node{
       public  int data;
       public Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }

       public boolean hasNext(Node node) {
            return  (node.next!=null)?true:false;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }



    Node  addListNumberV1(Node n1, Node n2) {
        //if(n1==null)?return n2: return n2;
        int sum = 0, carry = 0;
        Node temp;
        Node prev = null;
        Node result = null;
        while (n1 != null || n2 != null) {
        	
            sum = carry + (n1 != null ? n1.data : 0)
                    + (n2 != null ? n2.data : 0);
            carry = (sum > 10) ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);
            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }

        }
        if (carry > 1) {
            temp = new Node(carry);
            prev.next = temp;
        }
        return result;
    }

   void  displayNodes(Node node){
       while(node!=null){
           System.out.print(node.data+"->");
           node=node.next;
       }
       System.out.print("NULL");
   }
    public static void main(String[] args) {
        AddNumberList list = new AddNumberList();
        list.head1=new Node(7);
        list.head1.next=new Node(2);
        list.head1.next.next=new Node(3);
        list.head1.next.next.next=new Node(4);
        list.displayNodes(head1);
        System.out.println("");
        list.head2=new Node(7);
        list.head2.next=new Node(9);
        list.displayNodes(head2);
        System.out.println("");
        Node res=list.addListNumberV1(head1, head2);
        list.displayNodes(res);
    }
}