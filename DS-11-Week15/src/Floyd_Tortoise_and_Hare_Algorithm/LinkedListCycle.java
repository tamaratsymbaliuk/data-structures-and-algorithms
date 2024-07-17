package Floyd_Tortoise_and_Hare_Algorithm;

public class LinkedListCycle {
    // https://leetcode.com/problems/linked-list-cycle/description/

    public class Solution {
        public boolean hasCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    // They met! There is a cycle
                    return true;
                }
            }
            // fast pointer reached null or fast.next is null, wich means end of
            // the linked list. So, there is no cycle in the linked list - return false;
            return false;

        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

