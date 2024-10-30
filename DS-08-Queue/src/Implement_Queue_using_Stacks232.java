import java.util.Stack;

public class Implement_Queue_using_Stacks232 {
    public static void main(String[] args) {
        Implement_Queue_using_Stacks232 obj = new Implement_Queue_using_Stacks232();
        obj.push(5);
        obj.push(8);
        obj.push(9);

        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);

    }
    /*
    https://leetcode.com/problems/implement-queue-using-stacks/description/
     */

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    // Amortized O(1)
    public int pop() {
        int x = peek();
        output.pop();
        return x;
    }


    // Amortized O(1) - we do in total 3 operations (inserting in first stack, moving to the second stack and deleting) push, pop, peek
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
