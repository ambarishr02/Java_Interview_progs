package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Util.Node;

public class LevelOrderTraversal {
	
	
	static void levelOrderTravarsal(Node root){
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node current=q.poll();
			
			System.out.println(current.data+",");
			if(current.left!=null) {
				q.add(current.left);
			}
			if(current.right!=null) {
				q.add(current.right);
			}
			
		}
	}

	public static void main(String[] args) {
		
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		levelOrderTravarsal(root);
	}
	
	
}
