package DFS;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Util.Node;

public class BinaryAllPaths {

	public static void printroottoLeaf(Node current, Map<Node, Node> parent) {
		Stack<Node> stk = new Stack<>();
		while (current != null) {
			stk.push(current);
			current = parent.get(current);
		}

		while (!stk.isEmpty()) {
			System.out.print(stk.pop().data+"-->");
		}
		System.out.println("======================");
	}

	public static int PathSum(Node root) {
		if (root == null)
			return 0;

		Map<Node, Node> parent = new HashMap<>();
		Stack<Node> stk = new Stack<>();
		stk.push(root);
		parent.put(root, null);
		while (!stk.isEmpty()) {
			Node current = stk.pop();

			if (current.left == null && current.right == null) {
				printroottoLeaf(current, parent);
			}
			if (current.left != null) {
				stk.push(current.left);
				parent.put(current.left, current);
			}
			if (current.right != null) {
				stk.push(current.right);
				parent.put(current.right, current);
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		
		Node root=Node.createTree();
		//Node.DisplayTree(root);
//		Node root = new Node(10);
//		root.left = new Node(20);
//		root.right = new Node(30);
//		root.right.left = new Node(40);

		PathSum(root);
	}
}
