import java.util.Stack;

public class P150 {
  public int evalRPN(String[] tokens) {
    Stack<Integer> numStack = new Stack<>();

    for (String token : tokens) {
      if (token.equals("+")) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        numStack.push(num1+num2);
      } else if (token.equals("-")) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        numStack.push(num1-num2);
      } else if (token.equals("*")) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        numStack.push(num1*num2);
      } else if (token.equals("/")) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        numStack.push(num1/num2);
      } else {
        numStack.push(Integer.valueOf(token));
      }
    }
    return numStack.pop();
  }
}
