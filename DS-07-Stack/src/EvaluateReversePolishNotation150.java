import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    /*https://leetcode.com/problems/evaluate-reverse-polish-notation/description/*/
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        EvaluateReversePolishNotation150 test = new EvaluateReversePolishNotation150();
        System.out.println(test.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            System.out.println(S);
            if(s.equals("+")) {
                S.add(S.pop()+S.pop()); // S.pop() - removes the top element of the stack and returns it
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if(s.equals("*")) {
                S.add(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }
}
