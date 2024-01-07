package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;

public class TreeView {

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

  public static TreeNode buildTreeV2(int arr[], int i) {
    if (arr.length == 0) return null;
    TreeNode node = null;
    if (i < arr.length) {
      node = new TreeNode(arr[i]);
      node.setLeft(buildTreeV2(arr, 2 * i + 1));
      node.setRight(buildTreeV2(arr, 2 * i + 2));
    }

    return node;
  }

  public static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }
    printTree(root.getLeft());
    System.out.print(root.getData() + " ");
    printTree(root.getRight());
  }

  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40, 50, 60 };
    int arr2[] = { 10, 20, 30, 40, 50, 60 };
    TreeNode root = buildTree(arr);
     TreeNode root2 = buildTree(arr2);
    printTree(root);
    System.out.println("=========");
    printTree(root2);
  }
}
