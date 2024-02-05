package LinkedList;

import java.util.Stack;

import Util.LinkedListUtil.SingleLinkedNode;

public class AddTwoIntegers {

  static void AddNumbers(SingleLinkedNode n1, SingleLinkedNode n2) {
    int count1 = 0, count2 = 0;
    SingleLinkedNode current = n1;

    while (current != null) {
      count1++;
      current = current.getNext();
    }
    current = n2;
    while (current != null) {
      count2++;
      current = current.getNext();
    }
    int size = 0;
    if (count1 > count2) {
      size = count1;
      int rem = count1 - count2;
      current = n2;
      while (rem > 0) {
        SingleLinkedNode temp = new SingleLinkedNode(0);
        temp.setNext(current);
        current = temp;
        rem--;
      }
      n2 = current;
    } else if (count2 > count1) {
      size = count1;
      int rem = count2 - count1;
      current = n1;
      while (rem >= 0) {
        SingleLinkedNode temp = new SingleLinkedNode(0);
        temp.setNext(current);
        current = temp;
        rem--;
      }
      n1 = current;
    }

    SingleLinkedNode.printSingleLinkedList(n1);
    SingleLinkedNode.printSingleLinkedList(n2);
    Stack<SingleLinkedNode> s1 = new Stack<>();
    Stack<SingleLinkedNode> s2 = new Stack<>();
    SingleLinkedNode t1 = n1;
    SingleLinkedNode t2 = n2;
    while (size > 0) {
      s1.push(t1);
      t1 = t1.getNext();

      s2.push(t2);
      t2 = t2.getNext();
      size--;
    }

    int rem = 0;
    SingleLinkedNode result = null;
    while (!s1.isEmpty()) {
      SingleLinkedNode t1_1 = s1.pop();
      SingleLinkedNode t2_1 = s2.pop();
      int v = t1_1.getData() + t2_1.getData() + rem;
      if (v > 10) {
        rem = v / 10;
        v = (v) % 10;
      } else {
        rem = 0;
      }
      if (result == null) result = new SingleLinkedNode(v); else {
        SingleLinkedNode temp = new SingleLinkedNode(v);
        temp.setNext(result);
        result = temp;
      }
    }
    System.out.println("======================");
    SingleLinkedNode.printSingleLinkedList(result);
  }

  public static void main(String[] args) {
    SingleLinkedNode node1 = new SingleLinkedNode(7);
    SingleLinkedNode node2 = new SingleLinkedNode(5);
    SingleLinkedNode node3 = new SingleLinkedNode(9);
    SingleLinkedNode node4 = new SingleLinkedNode(4);
    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    SingleLinkedNode.printSingleLinkedList(node1);

    SingleLinkedNode node5 = new SingleLinkedNode(4);
    SingleLinkedNode node6 = new SingleLinkedNode(2);
    node5.setNext(node6);
    SingleLinkedNode.printSingleLinkedList(node5);

    AddNumbers(node1, node5);
  }
}
