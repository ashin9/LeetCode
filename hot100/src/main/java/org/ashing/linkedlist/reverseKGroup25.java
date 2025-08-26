package org.ashing.linkedlist;

public class reverseKGroup25 {

    /**
     * 分组翻转, 记录分组的 start.pre 和 end.next
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prehead = new ListNode(0, head);

        // pre 记录待翻转链表前驱，end 记录待翻转链表末尾
        ListNode pre = prehead;
        ListNode end = prehead;

        while (end.next != null) {
            // 每组结尾，若不够 k 个则返回
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode endnext = end.next;  // 记录尾 next，方便连接链表
            end.next = null;              // 断开链表，方便翻转
            // 翻转链表
            ListNode start = pre.next;
            pre.next = reverse(start);    // 翻转链表
            start.next = endnext;         // 翻转后 start 在尾部，连接到 next

            // 更新分组指针
            pre = start;
            end = pre;
        }

        return prehead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode curnext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curnext;
        }
        return pre;
    }
}
