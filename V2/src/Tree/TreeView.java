package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import Util.TreeNode;


public class TreeView {

    static int maxlevel = 0;
    static int maxrlevel = 0;

    public static void leftView(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > maxlevel) {
            System.out.println(root.getData());
            maxlevel = level;
        }
        leftView(root.getLeft(), level + 1);
        leftView(root.getRight(), level + 1);
    }

    public static void rightView(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > maxrlevel) {
            System.out.println(root.getData());
            maxrlevel = level;
        }
        rightView(root.getRight(), level + 1);
        rightView(root.getLeft(), level + 1);
    }



    // leftViewUsingBFS(TreeNode root){
    //     if(root==null) return;

    //     Queue<TreeNode> que=new LinkedList<>();

    //     que.add(root);

    //     while(!que.isEmpty()){
    //       int curLayer= que.size();

    //       for (int i = 0; i < curLayer; i++) {
    //             TreeNode cur= que.remove();
    //             if(i== que.size()-1){
    //                 rightView
    //             }
    //       }

    //     }


    // }

    public static void topView(TreeNode root) {
        if (root == null)
            return;

        class Que {
            TreeNode TreeNode;
            int hd;

            public Que(TreeNode TreeNode, int h) {
                this.TreeNode = TreeNode;
                this.hd = h;
            }

        }

        TreeMap<Integer, TreeNode> viewmap=new TreeMap<>();
        Queue<Que> que=new LinkedList<>();
        que.add(new Que(root, 0));

        while(!que.isEmpty()){
            Que obj=que.poll();
            if(!viewmap.containsKey(obj.hd)){
                viewmap.put(obj.hd, obj.TreeNode);
            }
            if(obj.TreeNode.getLeft()!=null){
                que.add(new Que(obj.TreeNode.getLeft(),obj.hd-1));
            }
            if(obj.TreeNode.getRight()!=null){
                que.add(new Que(obj.TreeNode.getRight(),obj.hd+1));
            }
        }
        viewmap.forEach((k,v)->System.out.println(k+" "+v.getData()));
    }

    public static void bottomView(TreeNode root) {

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(20));
        root.setRight(new TreeNode(30));
        root.getLeft().setLeft(new TreeNode(40));
        root.getLeft().setRight(new TreeNode(50));
         root.getRight().setLeft(new TreeNode(60));
       
        
        // leftView(root, 1);
        // System.out.println("================");
        // rightView(root, 1);
        // System.out.println("==================");
        topView(root);
    }
}
