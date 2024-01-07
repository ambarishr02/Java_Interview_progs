import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {
	
	
	public void topView(TreeNode node,int hd) {
		class QueueObj{
			TreeNode node;
			int hd;
			public QueueObj(TreeNode node, int hd){
				
				
			}
		}
		QueueObj root=new QueueObj(node,hd);
		Queue<QueueObj> q=new LinkedList<QueueObj>();
		q.add(root);
		
		
		
	}
	
	
	public static void main(String args[]) {
		VerticalOrderTraversal vericleOrder=new VerticalOrderTraversal ();
		TreeNode root=null;
		root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        root.right.left.right = new TreeNode(8); 
        root.right.right.right = new TreeNode(9); 
		
		
		vericleOrder.verticalOrderV2(root);
	}

}
