package DFS;

import Util.TreeNode;

public class AllPathSum {
	
	
	


	public static void main(String[] args) {
		int arr[]={10,20,30,40,50,60,70};
		TreeNode root=Util.TreeNode.buildTree(arr);
		Util.TreeNode.InOrderTraverSalOfTree(root);
	}

}
