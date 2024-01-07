package Trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import Util.TreeNode;

public class TreeViews {

  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40, 50, 60 };
    TreeNode root = Util.TreeNode.buildTree(arr);
    Views(root);
  }

  private static void Views(TreeNode root) {
    if (root == null) return;
    class ViewNode {

      TreeNode node;
      Integer hd;

      public ViewNode(TreeNode n, int hd) {
        this.node = n;
        this.hd = hd;
      }
    }
    Map<Integer, TreeNode> map = new TreeMap<>();

    Queue<ViewNode> q = new LinkedList<>();
    q.add(new ViewNode(root, 0));

    while (!q.isEmpty()) {
      ViewNode v = q.remove();
      Integer hd = v.hd;
      if (
        !map.containsKey(v.hd)
      ) map.put(v.hd, v.node); //  adding this makes this top view otherwise its  bottom view.
      if (v.node.getLeft() != null) {
        q.add(new ViewNode(v.node.getLeft(), hd - 1));
      }
      if (v.node.getRight() != null) {
        q.add(new ViewNode(v.node.getRight(), hd + 1));
      }
    }

    //for()
    for (Entry<Integer, TreeNode> e : map.entrySet()) {
      System.out.println(e.getKey() + "," + e.getValue().getData());
    }
  }
}
