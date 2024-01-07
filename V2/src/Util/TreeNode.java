package Util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

  Integer data;
  TreeNode left;
  TreeNode right;

  public TreeNode() {
    this.data = null;
    this.left = null;
    this.right = null;
  }

  public TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public TreeNode(Integer data, TreeNode left, TreeNode right) {
    super();
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public Integer getData() {
    return data;
  }

  public void setData(Integer data) {
    this.data = data;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public static TreeNode buildTree(int arr[]) {
    if (arr.length == 0) return null;
    TreeNode root = null;
    Queue<TreeNode> q = new LinkedList<>();
    root = new TreeNode(arr[0]);
    q.add(root);
    int i = 1;
    while (i < arr.length) {
      TreeNode node = q.remove();
      if (i < arr.length) {
        node.setLeft(new TreeNode(arr[i]));
        i++;
        q.add(node.getLeft());
      }

      if (i < arr.length) {
        node.setRight(new TreeNode(arr[i]));
        i++;
        q.add(node.getRight());
      }
    }

    return root;
  }

  public static void InOrderTraverSalOfTree(TreeNode root) {
    if (root == null) {
      return;
    }
    InOrderTraverSalOfTree(root.getLeft());
    System.out.print(root.getData() + " ");
    InOrderTraverSalOfTree(root.getRight());
  }
}
