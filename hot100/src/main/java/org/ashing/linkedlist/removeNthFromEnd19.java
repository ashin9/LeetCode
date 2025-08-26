package org.ashing.linkedlist;

public class removeNthFromEnd19 {

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        if (n == len) {
            head = head.next;
        } else if (n == 1) {
            ListNode cur = head;
            for (int i = 1; i < len - 1; i++) {
                cur = cur.next;
            }
            cur.next = null;
        }
        else {
            ListNode pre = null, cur = head;
            for (int i = 0; i < len - n; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            cur.next = null;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 获取链表长度
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        //
        ListNode pre = new ListNode(0, head);
        ListNode cur = pre;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return pre.next;
    }
}
