package LinkedList;

public class MergeLinkedList {

	static class Node {
		int data;
		Node next;
	}

	static Node newNode(int key) {
		Node temp = new Node();
        temp.data = key;
        temp.next = null;
        return temp;
	
	}

	// A utility function to print linked list
	static void printList(Node node) {
		while (node != null) {
			System.out.printf("%d ", node.data);
			node = node.next;
		}
	}

	public static Node merge(Node l1, Node l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		if (l1.data < l2.data) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}

	}

	public static void main(String[] args) {
		Node head1 = newNode(1);
        head1.next = newNode(3);
        head1.next.next = newNode(5);
 
        // 1.3.5 LinkedList created
 
        Node head2 = newNode(0);
        head2.next = newNode(2);
        head2.next.next = newNode(4);
 
        // 0.2.4 LinkedList created
 
        Node mergedhead = merge(head1, head2);
 
        printList(mergedhead);

	}

}
