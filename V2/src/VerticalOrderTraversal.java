import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VerticalOrderTraversal {
	
	/* Left is -ve value
	 * Root is zero
	 * Right +ve values */  
	 
	
	int min_value=0;
	int max_value=0;
	
	
	void findMinMaxValues(TreeNode node,int hd){
		if (node==null) {
			return;
		}
		if(hd<min_value) {
			min_value=hd;
		}else {
			max_value=hd;
		}
		
		findMinMaxValues(node.left,hd-1);
		findMinMaxValues(node.right,hd+1);
	}
	
	void printVerticleOrder(TreeNode node,int line_number,int hd){
		
		if(node==null) {
			return;
		}
		if(hd==line_number) {
			System.out.println(" "+node.data);
		}
		printVerticleOrder(node.left,line_number,hd-1);
		printVerticleOrder(node.right,line_number,hd+1);
	}
	
	
	void verticalOrder(TreeNode node){
		findMinMaxValues(node,0);
		
		for(int i=min_value;i<=max_value;i++) {
			printVerticleOrder(node,i,0);
		}
	}
	
	void  prepareTraversalMap(TreeNode root, int hd,TreeMap<Integer,List<Integer>> map){
		if(root==null) {
			return;
		}
		List<Integer> list=map.get(hd);
		
		if(list==null) {
			list=new ArrayList<>();
			list.add(root.data);
			map.put(hd, list);
			
		}else {
			list.add(root.data);
			map.put(hd, list);
		}
		prepareTraversalMap(root.left, hd-1,map);
		prepareTraversalMap(root.right, hd+1,map);
	
	}
	
	void verticalOrderV2(TreeNode node) {
		
		TreeMap<Integer,List<Integer>> map=new TreeMap<>();
		prepareTraversalMap(node,0,map);
		
//		for(int key:map.keySet()) {
//		for(int val:map.get(key)){
//			System.out.print(val);
//			}
//			System.out.println("");
//		}
		
		for (Entry<Integer,List<Integer>> entry:map.entrySet()) {
			System.out.println(entry.getValue());
		}
		
	}
	
	
	
	
	public static void main(String args[]) {
		VerticalOrderTraversal vericleOrder=new VerticalOrderTraversal ();
		TreeNode root=null;
//		root.left= new TreeNode(20);
//		root.right=new TreeNode(30);
//		root.left.left=new TreeNode(40);
//		root.left.right=new TreeNode(50);
//		root.right.left=new TreeNode(60);
//		root.right.right=new TreeNode(70);
		root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        root.right.left.right = new TreeNode(8); 
        root.right.right.right = new TreeNode(9); 
		
		//vericleOrder.verticalOrder(root);
		vericleOrder.verticalOrderV2(root);
	}

}
