package org.ashing.linkedlist;

public class getIntersectionNode160 {

    /**
     * 1. 每个链表走一遍, 若不存在则存到 Set 中, 若存在则返回
     * 空间 O(M+N)
     */

    /**
     * 2. 走一遍 A 为 a + c, 走一遍 B 为 b + c, 走 a + b + c 则走一样步数
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }
        return pa;
    }
}
