package Stk;

import java.util.Stack;

/**
 * https://www.techiedelight.com/expression-tree/
 * input ab+cde+**
 * o/p      (a+b)*(c*(d+e))
 */
public class ExpressionTest {
    static class Node {
        char c;
        Node left, right;
        public Node(char c){
            this.c=c;
            this.left=this.right=null;
        }
        public Node(char c, Node left, Node right){
            this.c=c;
            this.left=left;
            this.right=right;
        }
    }
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    public static void inOrder(Node node){
        if(node==null){
            return ;
        }
      
        inOrder(node.left);
        System.out.print(node.c);
        inOrder(node.right);
     
    }
    public static Node construct(String str){
        Stack<Node> stk=new Stack<>();
        for(char c:str.toCharArray()){
            if(isOperator(c)){
                Node n1=stk.pop();
                Node n2=stk.pop();
                Node n=new Node(c,n2,n1);
                stk.add(n);
            }else
            stk.add(new Node(c));
            
        }
        return stk.peek();
    }
    /**
     * 
     * 
     * 
     */
    public static void main(String[] args) {
        String postfix="ab+cde+**";

        Node node=construct(postfix);
        inOrder(node);
    }
}
