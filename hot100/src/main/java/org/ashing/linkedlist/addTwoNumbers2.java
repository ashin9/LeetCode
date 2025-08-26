package org.ashing.linkedlist;

public class addTwoNumbers2 {

    /**
     * Node(-1) , 返回.next
     * val = l 为空则 0
     * next 存在才 next
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);

        ListNode p = head;
        int jw = 0;
        while (l1 != null || l2 != null || jw != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + jw;
            jw = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }
}
