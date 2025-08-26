package org.ashing.linkedlist;

public class detectCycle142 {

    /**
     * 检测到环之后, 定义一个从头开始走的节点, 和 slow 同步走直道相遇, 相遇的节点就是环入口
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode headp = head;
                while (headp != slow) {
                    headp = headp.next;
                    slow = slow.next;
                }
                return headp;
            }
        }
        return null;
    }
}
