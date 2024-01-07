 


public class TreeTraversal {
	 TreeNode root;
	 int max_level=0;
	 int r_max_level=0;	

    void leftViewUtil(TreeNode node,int level){
		
		if(node==null) {
			return ;
		}
		
		if(level>max_level) {
			System.out.println(""+node.data);
			max_level=level;
		}
		leftViewUtil(node.left,level+1);
		leftViewUtil(node.right,level+1);
	}
    
   
    void rightViewUtil(TreeNode node,int level) {
    	if (node==null) {
    		return ;
    	}
    	if(level>r_max_level) {
			System.out.println(""+node.data);
			r_max_level=level;
		}
    	rightViewUtil(node.right,level+1);
    	rightViewUtil(node.left,level+1);
    }
    
   
    void 	TopView(){
    	
    }
    
    
    void View(){
     leftViewUtil(root,1);
     System.out.println("==============");
     rightViewUtil(root,1);
     
    }
	   
    
	
  public  static void main(String args[]) {
	  
	  	TreeTraversal tree = new TreeTraversal(); 
        tree.root = new TreeNode(12); 
        tree.root.left = new TreeNode(10); 
        tree.root.right = new TreeNode(30); 
        tree.root.right.left = new TreeNode(25); 
        tree.root.right.right = new TreeNode(40); 
        
        tree.View();
   
    }
	
}
