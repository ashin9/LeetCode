package org.ashing.linkedlist;

import java.util.PriorityQueue;

public class mergeKLists23 {

    /**
     * 优先队列
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        // 所有非空链表头节点入堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 迭代, 多次两链表合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int m = lists.length;
        if (m == 0) {
            return null;
        }
        for (int step = 1; step < m; step *= 2) {               // 合并 logn 次
            for (int i = 0; i < m - step; i += step * 2) {      // 当前的步长下，遍历所有需要合并的链表对
                lists[i] = mergeTwoLists(lists[i], lists[i + step]);
            }
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);

        ListNode cur = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return prehead.next;
    }
}
