package Util;

public class Node {

	public Node left;
	public Node right;
	public int data;

	public Node(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public static Node createTree() {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);

		return root;
	}

	public static void DisplayTree(Node root) {
		while (root == null)
			return;

		System.out.println(root.data);
		DisplayTree(root.left);
		DisplayTree(root.right);
	}
}
