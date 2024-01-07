package Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
	int info;
	TreeNode left;
	TreeNode right;
	
	public  TreeNode(int data) {
		this.info=data;
		this.left=this.right=null;
	}
}
public class TreeHeight {

	public static int height(TreeNode root) {
		if(root==null) return 0;
		return Math.max(1+height(root.left),1+height(root.right));
	}
	
	public static boolean printPath(TreeNode root, int d1,List<TreeNode> list) {
		if(root==null) return false;
		list.add(root);
		if(root.info==d1) {
			return true;
		}
		
	    if(printPath(root.left,d1, list) ||printPath(root.right, d1, list))
	    	return true;
	 
	    list.remove(list.size()-1);
	    return false;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
		
		 root.left= new TreeNode(20);
		 root.right=new TreeNode(30);
		 
		 root.left.left=new TreeNode(40);
		 root.left.right=new TreeNode(50);
		 
		 root.right.right=new TreeNode(60);
		 root.right.right.right=new TreeNode(70);
		 System.out.println(height(root));
		 
		 List<TreeNode>list=new ArrayList<>();
		 printPath(root,70,list);
		 
		 for(TreeNode node:list) {
			 System.out.println(node.info);
		 }
	}
	
}
