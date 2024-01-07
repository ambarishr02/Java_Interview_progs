package Tree;

import java.util.*;

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1(int x) {
		val = x;
	}
};

public class FindAllTreePaths {

	public static List<List<Integer>> findPaths(TreeNode1 root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<Integer>();
		findPathsRecursive(root, sum, currentPath, allPaths);
		return allPaths;
	}

	private static void findPathsRecursive(TreeNode1 currentNode, int sum, List<Integer> currentPath,
			List<List<Integer>> allPaths) {
		if (currentNode == null)
			return;

		// add the current node to the path
		currentPath.add(currentNode.val);

		// if the current node is a leaf and its value is equal to sum, save the current
		// path
		if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
			allPaths.add(new ArrayList<Integer>(currentPath));
		} else {
			// traverse the left sub-tree
			findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
			// traverse the right sub-tree
			findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
		}

		// remove the current node from the path to backtrack,
		// we need to remove the current node while we are going up the recursive call
		// stack.
		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String args[]) {
		TreeNode1 root = new TreeNode1(12);
		root.left = new TreeNode1(7);
		root.right = new TreeNode1(1);
		root.left.left = new TreeNode1(4);
		root.right.left = new TreeNode1(10);
		root.right.right = new TreeNode1(5);
		int sum = 23;
		List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
		System.out.println("Tree paths with sum " + sum + ": " + result);
	}
}
