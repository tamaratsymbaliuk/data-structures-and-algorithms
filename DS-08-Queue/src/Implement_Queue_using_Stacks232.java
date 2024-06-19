import java.util.Stack;

public class Implement_Queue_using_Stacks232 {
    public static void main(String[] args) {

    }
    /*
    https://leetcode.com/problems/implement-queue-using-stacks/description/
     */

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public Implement_Queue_using_Stacks232() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        int x = peek();
        output.pop();
        return x;
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();

    }

    public boolean empty() {
        return input.empty() && output.empty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
