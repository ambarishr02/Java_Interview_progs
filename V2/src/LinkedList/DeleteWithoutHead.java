package LinkedList;

public class DeleteWithoutHead {
	
	 static class Node {
		 int data;
		 Node next;
		 
		 public Node(int info) {
			 this.data=info;
			 this.next=null;
		 }
	 }
	 
	 
	 void delete(Node del){
		 
		 if(del==null) return ;
		 
		 Node temp =del.next;
		 del.data=temp.data;
		 del.next=temp.next;		 
		 temp=null;
	 }
	 
	 
	 void mergeSort(Node list){
		 
		 if(list==null) return;
		 
		Node left=getMidofList(list);
		Node right=left.next;
		left.next=null;
		
		mergeSort(left);
		mergeSort(right);
		// Merge the left and right lists 
        Node sortedlist = merge(left, right);
	
        while(sortedlist!=null) {
        	System.out.println(sortedlist.data);
        	sortedlist=sortedlist.next;
        }
        
	 }

	 Node merge(Node left, Node right) {
		 
		Node temp;
		
		if(left.data<right.data) {
			temp=left;
			temp.next=merge(left.next, right);
		}else {
			temp=right;
			temp.next=merge(left, right.next);
		}
		 
		return temp;
	 }
	 
	Node getMidofList(Node list){
		Node slow=list, fast=list;
		while(slow.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		 return slow;	 
	 }
}
