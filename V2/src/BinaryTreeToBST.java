
public class BinaryTreeToBST {
	
	
	class Tree{
		Tree left;
		Tree right;
		int  value;
		
		public Tree(int v) {
			this.value=v;
		}
	}
	
	
	public void createInorderArray( Tree root , int[] inorderArray , int index) {
		if(root==null) return;
		createInorderArray(root.left,inorderArray, index);
		inorderArray[index]=root.value;
		index++;
		createInorderArray(root.right,inorderArray, index);
	}
	
	
	public void  convertBinaryTreeToBST(Tree root,int[] inorderArray, int index) {
		if(root == null) return;
		
		convertBinaryTreeToBST(root.left,inorderArray, index);
		//Only difference
		root.value=inorderArray[index];
		index++;
		convertBinaryTreeToBST(root.right,inorderArray, index);
	}
	
	
	public static void main(String args[]) {
		
	}

}
