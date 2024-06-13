/*
    https://leetcode.com/problems/min-stack/description/
     */
public class MinStack {
    private Node head;

    public void push(int x) {
        if (head == null) // if the stack is empty, add to the head
            head = new Node(x, x, null);
        else // if the stack is not empty
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
     return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node { // Singly-linked list, we always insert at the head of the linked list
        int val;
        int min;
        Node next;
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

