public class MyCircularQueue {
    // https://leetcode.com/problems/design-circular-queue/
    int maxSize, size = 0;
    Node head = null, tail = null;
    public MyCircularQueue(int k) {
        maxSize = k;
    }
    public boolean enQueue(int val) {
        if (isFull()) return false;
        Node newNode = new Node(val);
        if (isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return true;
    }
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head.next;
        size--;
        return true;
    }
    public int Front() {
        return isEmpty() ? -1 : head.val;
    }
    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == maxSize;
    }
}

class ListNode {
    int val;
    Node next;
    public ListNode(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
