public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // creating a dummy list
        ListNode curr = dummy; // initializing a pointer
        int carry = 0; // initializing carry with 0, used when the sum of two digits is 10 or greater

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry; // if we have carry then add it into our sum
            carry = sum / 10; // if we get carry, then divide it by 10 to get the carry

            // Create a new node with the last digit of the sum (sum % 10)
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Method to create a linked list from an array
    public ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Creating two linked lists: l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = solution.createList(new int[] {2, 4, 3});
        ListNode l2 = solution.createList(new int[] {5, 6, 4});

        // Adding the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Printing the result
        System.out.print("Result: ");
        solution.printList(result);  // Expected output: 7 -> 0 -> 8
    }
}
