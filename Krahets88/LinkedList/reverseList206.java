package Krahets88.LinkedList;

public class reverseList206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    /**
     * 递归 : 翻转指针
     * 递归边界: head 为 null or head.next 为 null
     * 递归体: 传参数 next, 缩小规模, 当前节点翻转指针
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        // 下一节点的 next 指向当前节点, 相当于翻转指针方向
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    /**
     * 迭代 : 双指针, 前指
     * 双指针, 记录 pre 和 cur
     * 提前记录 cur.next
     * cur.next = pre
     * 同步移动双指针
     */
    public ListNode reverseListFor(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            // 翻转指针
            cur.next = pre;
            // 双指针后移
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
