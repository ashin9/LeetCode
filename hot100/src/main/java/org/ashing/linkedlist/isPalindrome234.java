package org.ashing.linkedlist;

public class isPalindrome234 {

    /**
     * 快慢指针找到中间节点
     * 逆置后半段链表
     * 遍历比较元素
     */
    public boolean isPalindrome(ListNode head) {
        ListNode midLink = midNode(head);
        ListNode reMid = reverseList(midLink);

        while (reMid != null) { // 注意不能是 head != null, 因为 head 长
            if (head.val != reMid.val) {
                return false;
            }
            head = head.next;
            reMid = reMid.next;
        }
        return true;
    }

    // 双指针
    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 快慢指针
    private ListNode midNode(ListNode head) {
        ListNode fast = head, low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
}
