public class MergeTwoSortedLists_21 {
     static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
         ListNode(int val) {
            this.val = val;
         }
         ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
         }



    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
         } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public static void main(String[] args) {

        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);



        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3, l6);
        ListNode l4 = new ListNode(1, l5);

        MergeTwoSortedLists_21 test = new MergeTwoSortedLists_21();
        test.mergeTwoLists(l1, l4);
        System.out.println(test.mergeTwoLists(l1, l4));


    }
}
