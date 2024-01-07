package Strings;

import java.util.Stack;

//3-2+5

public class ExprValuation {

  public static void main(String[] args) {
    String str = "3*(2+6)";
    try {
      evaluateExpr(str);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //"3*(2+6)"
  static void evaluateExpr(String str) throws Exception {
    char ch[] = str.toCharArray();
    Stack<Character> operation = new Stack<>();
    Stack<Integer> operands = new Stack<>();
    for (int i = 0; i < ch.length; i++) {
      if (Character.isDigit(ch[i])) {
        int j = i + 1;
        while (j < ch.length && Character.isDigit(ch[j])) {
          j++;
        }
        operands.push(Integer.parseInt(str.substring(i, j)));
        i = j - 1;
      } else if (ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/') { 
        //current top has precendence over current symbol 
        while (!operation.isEmpty() && hasPrecendence(ch[i], operation.peek())) {
          operands.push(applyOperation(operands.pop(), operands.pop(), operation.pop()));
        }
        operation.push(ch[i]);
      } else if (ch[i] == '(' )  {
        
        operation.push('(');

      } else if (ch[i] == ')') {
        
        while (operation.peek() != '(') {
          operands.push(applyOperation(operands.pop(), operands.pop(), operation.pop()));
        }
        operation.pop();
      }
    }

    while (!operation.isEmpty()) {
       operands.push(applyOperation(operands.pop(), operands.pop(), operation.pop()));
    }
    

    System.out.println(operands.pop());
  }


  private static int applyOperation(Integer v1, Integer v2, Character op)
    throws Exception {
    switch (op) {
      case '+':
        return v1 + v2;
      case '-':
        return v1 - v2;
      case '*':
        return v1 * v2;
      case '/':
        if (v2 == 0) throw new Exception("Divid by zero ");
        return v1 / v2;
    }
    return 0;
  }

  //Returns true if top has higher or same precedence as 'current',otherwise returns false. 
  static boolean hasPrecendence(char current, char top) {
    if (top == '(' || top == ')') return false;

    if ((top == '+' || top == '-') && (current == '*' || current == '/')) {
      return false;
    }
    return true;
  }
}
