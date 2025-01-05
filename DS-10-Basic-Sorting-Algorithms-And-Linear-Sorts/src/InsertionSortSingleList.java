public class InsertionSortSingleList {
    public static void main(String[] args) {
        // Create a sample linked list: 4 -> 2 -> 1 -> 3
        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(4, node2);

        InsertionSortSingleList test = new InsertionSortSingleList();
        ListNode listNode = test.insertionSortList(head);
        System.out.println(listNode);
    }
    public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val).append(" -> ");
                current = current.next;
            }
            sb.append("null");
            return sb.toString();
        }
  }
    public ListNode insertionSortList(ListNode head) {

        for (ListNode cur = head; cur != null; cur = cur.next) {
            for (ListNode j = head; j != cur; j = j.next) {
                if (j.val > cur.val) {
                    int t = j.val;
                    j.val = cur.val;
                    cur.val = t;
                }
            }
        }
        return head;

    }

}
