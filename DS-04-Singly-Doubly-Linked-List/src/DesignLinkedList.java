public class DesignLinkedList {
    // singly LinkedList implementation
    /*Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.*/

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            // Explicitly set next to null to initialize it
            this.next = null;
        }

    }

    private Node head;
    private int size;

    // Initialize the LinkedList object
    public DesignLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;


    }

    // Add a node of value val before the first element of the linked list.
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;


    }

    // Append a node of value val as the last element of the linked list.
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

    }

    // Add a node of value val before the indexth node in the linked list.
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
        } else {
            Node newNode = new Node(val);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Delete the indexth node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;

    }

    public static void main(String[] args) {
        // Testing the MyLinkedList implementation
        DesignLinkedList linkedList = new DesignLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));  // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1));  // returns 3
    }
}
