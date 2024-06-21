public class MyCircularDeque {

    int maxSize;
    int size;
    Node head;
    Node tail;

    public MyCircularDeque(int k) {

        maxSize = k;
        size = 0;
        head = null;
        tail = null;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {

        if (isFull()) return false;
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;

    }

    public boolean deleteFront() {

        if (isEmpty()) return false;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return true;

    }

    public boolean deleteLast() {

        if (isEmpty()) return false;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return true;

    }

    public int getFront() {

        return isEmpty() ? -1 : head.val;
    }

    public int getRear() {

        return isEmpty() ? -1 : tail.val;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public boolean isFull() {

        return size == maxSize;
    }
}
class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
