package Util;

public class LinkedListUtil {

 public static class SingleLinkedNode {

    int data;
    SingleLinkedNode next;

    public SingleLinkedNode(int data) {
      super();
      this.data = data;
    }

    public SingleLinkedNode(int data, SingleLinkedNode next) {
      super();
      this.data = data;
      this.next = next;
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public SingleLinkedNode getNext() {
      return next;
    }

    public void setNext(SingleLinkedNode next) {
      this.next = next;
    }
  }

  public static SingleLinkedNode createSingleLinkedList(int arr[]) {
    SingleLinkedNode node = null;
    if (arr.length == 0) {
      System.out.println("Array is empty !!");
    }
    for (int i = arr.length - 1; i >= 0; i--) {
      SingleLinkedNode newNode = new SingleLinkedNode(arr[i]);
      newNode.setNext(node);
      node = newNode;
    }
    return node;
  }

  public static void printSingleLinkedList(SingleLinkedNode node) {
    SingleLinkedNode current = node;
    while (current != null) {
      System.out.print(current.getData() + "->");
      current = current.getNext();
    }
    System.out.println("NULL");
  }
}
