package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import Util.Node;

public class TreeViews {
	Node root;
	static int maxLevel = 0;
	static int maxRlevel = 0;

	void leftView(Node root, int level) {
		if (root == null)
			return;
		if (level > maxLevel) {
			System.out.println(root.data);
			maxLevel = level;
		}
		leftView(root.left, level + 1);
		leftView(root.right, level + 1);
	}

	void leftViewUsingQueue(Node  root) {
		
		if (root==null) return;
		
		Queue<Node> que=new LinkedList<>();
		que.add(root);
		
		while(!que.isEmpty()) {
			int n =que.size();
			
			for (int i=1;i<=n;i++) {
				Node current=que.poll();
				
				if(i==1) System.out.println(current.data);
				
				
				if(current.left!=null)
					que.add(current.left);
				if(current.right!=null)
					que.add(current.right);
				
			}
		}
		
		
	}
	void rightView(Node root, int level) {
		if (root == null)
			return;
		if (level > maxRlevel) {
			System.out.println(root.data);
			maxRlevel = level;
		}
		rightView(root.right, level + 1);
		rightView(root.left, level + 1);
	}

	
	void view(Node root, boolean topView) {
		TreeMap<Integer, Node> ViewMap = new TreeMap<>();
		class Que {
			Node node;
			int hd;
			public Que(Node node , int h) {
				this.node=node;
				this.hd=h;
			}
		  
		}
		Queue<Que> q= new LinkedList<Que>();
		if (root==null)	return;
		else {
			q.add(new Que(root,0));
		}
		
		while(!q.isEmpty()) {
			Que obj=q.poll();
				if(topView) {
					if(!ViewMap.containsKey(obj.hd)) { 
						ViewMap.put(obj.hd, obj.node);
					}
				}else {
					ViewMap.put(obj.hd, obj.node);
				}
			
			if(obj.node.left!=null)
				q.add(new Que(obj.node.left,obj.hd-1));
			if(obj.node.right!=null)
				q.add(new Que(obj.node.right,obj.hd+1));
		}
		ViewMap.forEach((K, V) -> System.out.println(K + ",  : " + V.data));
	}

	public static void main(String[] args) {
		TreeViews treeView = new TreeViews();
//		treeView.root = new Node(10);
//		treeView.root.left = new Node(20);
//		treeView.root.right = new Node(30);
//		treeView.root.left.left = new Node(40);
//		treeView.root.left.right = new Node(50);
//		treeView.root.right.left = new Node(60);
//		treeView.root.right.right = new Node(70);
		
		
		treeView.root = new Node(1); 
		treeView.root.left = new Node(2); 
		treeView.root.right = new Node(3); 
		treeView.root.left.right = new Node(4); 
		treeView.root.left.right.right = new Node(5); 
		treeView.root.left.right.right.right = new Node(6);
		
		
		
		
		System.out.println("======LeftView=========");
		treeView.leftView(treeView.root, 1);
		System.out.println("======RightView======== ");
		treeView.rightView(treeView.root, 1);
		System.out.println("=======TopView========");
		treeView.view(treeView.root,true);
		System.out.println("=====Bottom View======= ");
		treeView.view(treeView.root, false);
		System.out.println("=====Left View using Queue ======= ");
		treeView.leftViewUsingQueue(treeView.root);
	}

}
