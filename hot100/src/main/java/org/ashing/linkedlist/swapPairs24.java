package org.ashing.linkedlist;

public class swapPairs24 {

    /**
     * 1. 递归
     * head 原头新二, newHead 原二新头
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 表示原链表头节点, newHead 表示原链表的第二节点, 其余节点 newHead.next
        // 交换后
        // head 表示新链表第二节点, newHead 表示新链表的头节点
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 2. 迭代
     * 空头节点, 只要 p.next 和 p.next.next 非空就交换
     * p.next = p2
     * p1.next = p2.next
     * p2.next = p1
     * p = p1;
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0, head);

        ListNode p = pre;
        while (p.next != null && p.next.next != null) {
            ListNode p1 = p.next;
            ListNode p2 = p.next.next;

            p.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            p = p1;
        }
        return pre.next;
    }

}
