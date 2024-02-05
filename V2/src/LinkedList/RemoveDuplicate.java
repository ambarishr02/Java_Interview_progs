package LinkedList;

import java.util.HashSet;
import java.util.Set;

import Util.LinkedListUtil.SingleLinkedNode;

public class RemoveDuplicate {

    public static void removeDuplicates(SingleLinkedNode root){

        if(root==null) return;
        Set<Integer> set=new HashSet<>();
        SingleLinkedNode previous=null;
        while(root!=null){
           if(set.contains(root.getData())){
                 if(root.getNext()==null){
                     previous.setNext(null);
                 }else{
                     previous.setNext(root.getNext());
                 }
                 
            }else
             set.add(root.getData());
             previous=root;
             root=root.getNext();
        }

    }

    public static void main(String[] args) {
        SingleLinkedNode node1 = new SingleLinkedNode(10);
        SingleLinkedNode node2 = new SingleLinkedNode(20);
        SingleLinkedNode node3 = new SingleLinkedNode(20);
        SingleLinkedNode node4 = new SingleLinkedNode(40);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        SingleLinkedNode.printSingleLinkedList(node1);
        removeDuplicates(node1);
        SingleLinkedNode.printSingleLinkedList(node1);
    }

}
