package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

public class LevelOrder {
    
    public static void main(String[] args) {
        int arr[] ={10, 20, 30, 40, 50, 60};
        TreeNode root=Util.TreeNode.buildTree(arr);
     List<List<Integer>> result=   levelOrder(root);
     System.out.println("============================");
     for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i).toString());
     }
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return null;
        List<Integer> currentList=null;
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
          int currentSize=q.size();
          TreeNode node=null;
          currentList=new ArrayList<>(currentSize);
          for (int i = 0; i < currentSize; i++) {
            node= q.poll();
            
          
          if(node.getLeft()!=null){
            q.add(node.getLeft());
          }
          if(node.getRight()!=null){
            q.add(node.getRight());
          } 
          currentList.add(node.getData());  
        }
          result.add(currentList); 
      }


        return  result;
    }


}
