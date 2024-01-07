package LinkedList;

public class MergeSort {
	
	static class Node{
		int data;
		Node next;
		Node(int key){
			this.data=key;
			this.next=null;
		}
	}
	
	
	static Node mergeSort(Node n){
		if(n.next==null) {
			return n;
		}
		Node mid=findMid(n);
		Node secondHalf=mid.next;
		mid.next=null;
		Node left=mergeSort(n);
		Node right=mergeSort(secondHalf);
		Node finalHead=merge(left, right);
		return finalHead;		
	}
	
	static Node merge(Node left, Node right){
		Node merged=new Node(-1);
		Node temp=merged;
		while(left!=null && right!=null) {
			if(left.data<right.data) {
				temp.next=left;
				left=left.next;
			}else {
				temp.next=right;
				right=right.next;
			}
			temp=temp.next;
		}
		
		while(left!=null) {
			temp.next=left;
			left=left.next;
			temp=temp.next;
		}
		while(right!=null) {
			temp.next=right;
			right=right.next;
			temp=temp.next;
		}
		
		return merged.next;
	}
	
	static Node findMid(Node n) {
		Node slow=n;
		Node fast=n.next;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
 
	public static void main(String[] args) {
		Node head=new Node(20);
		Node temp=head;
		temp.next=new Node(30);
		temp=temp.next;
		temp.next=new Node(10);
		temp=temp.next;
		temp.next=new Node(4);
		
		head=mergeSort(head);
		
		printList(head);
	}

}
