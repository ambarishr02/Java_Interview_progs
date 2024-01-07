package Tree;

import Util.Node;

public class CheckTwoTreesAreIdentical {
	 
	 private Node rootNode1;
	 private Node rootNode2;
	 
	 public static void main(String[] args) {
	  new CheckTwoTreesAreIdentical();
	 }
	 
	 public CheckTwoTreesAreIdentical() {
	  rootNode1 = addNode(rootNode1, 100);
	  rootNode1 = addNode(rootNode1, 30); 
	  rootNode1 = addNode(rootNode1, 20); 
	  rootNode1 = addNode(rootNode1, 40);
	  rootNode1 = addNode(rootNode1, 200);
	 
	  rootNode2 = addNode(rootNode2, 100); 
	  rootNode2 = addNode(rootNode2, 30); 
	  rootNode2 = addNode(rootNode2, 20); 
	  rootNode2 = addNode(rootNode2, 40);
	  rootNode2 = addNode(rootNode2, 200);
	 
	  System.out.println("Result :"+checkTreeAreIdentical(rootNode1, rootNode2));
	 }
	 
	 private boolean checkTreeAreIdentical(Node tree1, Node tree2){
	  if(tree1==null && tree2==null){
	   return true;
	  }
	 
	  if(tree1==null || tree2==null){
	   return false;
	  }
	 
	  //Data check, Left Tree check and Right Tree check can be done in same line,
	  //but for simplicity I have separated it.
	  if(tree1.getData()!=tree2.getData()){ 
	   return false;
	  }
	 
	  boolean isLeftSame = checkTreeAreIdentical(tree1.getLeft(), tree2.getLeft());  
	  boolean isRightSame = checkTreeAreIdentical(tree1.getRight(), tree2.getRight()); 
	 
	  if(isLeftSame && isRightSame){
	   return true;
	  }else{
	   return false;
	  }
	 }
	 
	 private Node addNode(Node rootNode, int i) {
	  if(rootNode==null){
	   return new Node(i);
	  }else{
	   if(i > rootNode.getData()){
	    Node nodeToAdd = addNode(rootNode.getRight(), i);
	    rootNode.setRight(nodeToAdd);
	 
	   }else{
	    Node nodeToAdd = addNode(rootNode.getLeft(), i);
	    rootNode.setLeft(nodeToAdd);
	   }
	  }
	  return rootNode;
	 }
	}
