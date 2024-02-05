package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;

public class LevelOrder {

    static void levelOrder(TreeNode root){
        if(root==null) return;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            System.out.println(n.getData());
           if(n.getLeft()!=null)
            q.add(n.getLeft());
            if(n.getRight()!=null)
            q.add(n.getRight());
        }

    }


    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(20));
        root.setRight(new TreeNode(30));
        root.getLeft().setLeft(new TreeNode(50));
        root.getLeft().getLeft().setLeft(new TreeNode(40));

        levelOrder(root);
    }
}
