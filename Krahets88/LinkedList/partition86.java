package Krahets88.LinkedList;

public class partition86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    /**
     * 维护两个链表, 一个小于 x, 一个大于 x
     * 大于 x 结尾指向 null
     * 小于 x 结尾指向 大于 x 链表头
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode sml = new ListNode(0);
        ListNode smlHead = sml;
        ListNode bgl = new ListNode(0);
        ListNode bgHead = bgl;

        while (head != null) {
            if (head.val < x) {
                sml.next = head;
                sml = sml.next;
            } else {
                bgl.next = head;
                bgl = bgl.next;
            }
            head = head.next;
        }
        bgl.next = null;
        sml.next = bgHead.next;
        return smlHead.next;
    }
}
