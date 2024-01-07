package Trees;
import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;
public class FlatenBinaryTree {
  static TreeNode head=null;
  static TreeNode current=null;
  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40, 50, 60 };

    TreeNode root = Util.TreeNode.buildTree(arr);
   // Util.TreeNode.InOrderTraverSalOfTree(root);
    System.out.println("\n======================");
    TreeNode node=flattenTree(root);
     while(node!=null){
        System.out.print(node.getData()+"->");
        node=node.getRight();
     }

    usingDFS(root);
    while(head!=null){
      System.out.print(head.getData()+",");
      head=head.getRight();
    }

  }


  static void usingDFS(TreeNode root){
     if(root==null) return;
    if(head==null){
     head=new TreeNode(root.getData());
      current=head;
    }else{
      current.setRight(new TreeNode(root.getData()));
      current=current.getRight();
    }
    
     
    usingDFS(root.getLeft());
    usingDFS(root.getRight());

   }

private static TreeNode flattenTree(TreeNode root) {
    if(root==null) return null;

   
    Queue<TreeNode> que=new LinkedList<>();
    TreeNode head=null, t=null;

    que.add(root);
    while(!que.isEmpty()){
      TreeNode current=que.poll();
      if(head==null){
       head=new TreeNode(current.getData());
       t=head;
      }else{
       t.setRight(new TreeNode(current.getData()));
       t=t.getRight(); 
      } 
       if(current.getLeft()!=null)
       que.add(current.getLeft());

       if(current.getRight()!=null)
       que.add(current.getRight());

    }

    // if(root.getLeft()!=null){
    //     node.setRight(flattenTree(root.getLeft()));
    // }else

    // if(root.getRight()!=null){
    //     node.setRight(flattenTree(root.getRight()));
    // }

    return head;
}



 
   
 }



