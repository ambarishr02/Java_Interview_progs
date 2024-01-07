package Tree;

import Util.Node;

//Diameter of node = height of Left sub tree of node + height of Right sub tree of node + 1 (node itself).
public class FindDiameterOfBinaryTree {

	private Node rootNode;

	public static void main(String[] args) {
		new FindDiameterOfBinaryTree();
	}

	public FindDiameterOfBinaryTree() {

		addNode(rootNode, 100);
		addNode(rootNode, 90);
		addNode(rootNode, 150);
		addNode(rootNode, 80);
		addNode(rootNode, 95);
		addNode(rootNode, 70);
		addNode(rootNode, 92);
		addNode(rootNode, 60);
		addNode(rootNode, 94);

		System.out.println(getDiameterOfBinaryTreeOptimizedSolution(rootNode)[0]);
	}

	public static int[] getDiameterOfBinaryTreeOptimizedSolution(Node root) {

		// 0th element is diameter and 1st element is height
		int[] result = new int[] { 0, 0 };

		if (root == null)
			return result;

		int[] leftResult = getDiameterOfBinaryTreeOptimizedSolution(root.getLeft());
		int[] rightResult = getDiameterOfBinaryTreeOptimizedSolution(root.getRight());
		int height = Math.max(leftResult[1], rightResult[1]) + 1;

		int rootDiameter = leftResult[1] + rightResult[1] + 1;
		int leftDiameter = leftResult[0];
		int rightDiameter = rightResult[0];

		result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
		result[1] = height;

		return result;
	}

	private void addNode(Node rootNode, int data) {
		if (rootNode == null) {
			Node temp1 = new Node(data);
			this.rootNode = temp1;
		} else {
			addNodeInProperPlace(rootNode, data);
		}
	}

	private void addNodeInProperPlace(Node rootNode, int data) {
		if (data > rootNode.getData()) {
			if (rootNode.getRight() != null) {
				addNode(rootNode.getRight(), data);
			} else {
				Node temp1 = new Node(data);
				rootNode.setRight(temp1);
			}
		} else if (data < rootNode.getData()) {
			if (rootNode.getLeft() != null) {
				addNode(rootNode.getLeft(), data);
			} else {
				Node temp1 = new Node(data);
				rootNode.setLeft(temp1);
			}
		}
	}

}
