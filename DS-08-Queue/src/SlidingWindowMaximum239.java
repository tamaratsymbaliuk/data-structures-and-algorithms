public class SlidingWindowMaximum239 {
    //https://leetcode.com/problems/sliding-window-maximum/description/
    class MaxStack {
        private Node head;

        public void push(int x) {
            if (head == null)
                head = new Node(x, x, null);
            else
                head = new Node(x, Math.max(x, head.max), head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMax() {
            return head.max;
        }

        public boolean empty() {
            return head == null;
        }

        private class Node { // Singly-linked list
            int val;
            int max;
            Node next;

            private Node(int val, int max, Node next) {
                this.val = val;
                this.max = max;
                this.next = next;
            }
        }
    }

    class MaxQueue {

        MaxStack input = new MaxStack();
        MaxStack output = new MaxStack();

        public void push(int x) {
            input.push(x);
        }

        // Amortized O(1)
        public int pop() {
            int x = front();
            output.pop();
            return x;
        }

        // Amortized O(1)
        public int front() {
            if (output.empty()) {
                while (!input.empty()) {
                    int x = input.top();
                    input.pop();
                    output.push(x);
                }
            }
            return output.top();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }

        int getMax() {
            int max = (int) -1e5; // -10^5
            if (!input.empty()) {
                max = Math.max(max, input.getMax());
            }
            if (!output.empty()) {
                max = Math.max(max, output.getMax());
            }
            return max;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        MaxQueue maxQueue = new MaxQueue();
        for (int i = 0; i < k; i++) { // i = 0..k-1
            maxQueue.push(nums[i]);
        }

        results[0] = maxQueue.getMax();
        for (int i = k; i < n; i++) {
            maxQueue.pop();
            maxQueue.push(nums[i]);
            results[i - k + 1] = maxQueue.getMax();
        }

        return results;
    }
}
