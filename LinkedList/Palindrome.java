package LinkedList;

import java.util.Stack;

public class Palindrome {

	Node head;

	class Node {
		char info;
		Node next;

		Node(char info) {
			this.info = info;
			this.next = null;
		}
	}

	Node createList(char c) {
		Node n = new Node(c);
		n.next = head;
		head = n;
		return head;
	}

	void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.info);
			current = current.next;
		}
	}

	public boolean checkPalindrome() {
		Stack<Character> s=new Stack();
		Node current=head,c2=head;
		while (current!=null) {
			s.push(current.info);
			current=current.next;
		}
		
		while (c2!=null) {
			char c=s.peek();
			if(c==c2.info) {
				s.pop();
				c2=c2.next;
				continue;
			}
			else
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
	//	char[] str = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
		char[] str= {'a'};
		Palindrome p = new Palindrome();
		for (int i = 0; i < str.length; i++) {
			p.head = p.createList(str[i]);
		}
		p.printList();
		System.out.println(p.checkPalindrome());

	}
}
