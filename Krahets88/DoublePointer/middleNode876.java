package Krahets88.DoublePointer;

public class middleNode876 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     * 快慢指针, 快指针一次走 2 步, 当快指针走到末尾, 慢指针指向链表中间
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
