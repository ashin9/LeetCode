package Krahets88.DoublePointer;

import java.util.HashSet;
import java.util.Set;

public class getIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * Set 存放集合, 再遍历另外一个
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // headA 所有祖先存放在 Set 中
        Set<ListNode> allNode = getAllNode(headA);

        // 遍历 headB 是否存在于 Set 中，若存在则找到相交起始节点
        while (headB != null) {
            if (allNode.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public Set<ListNode> getAllNode(ListNode list) {
        Set<ListNode> allNode = new HashSet<>();
        while (list != null) {
            allNode.add(list);
            list = list.next;
        }
        return allNode;
    }

    /**
     * 双指针法, 把空间复杂度降至 O(1)
     * 同步更新双指针, 若 A 为空则指向 B 链表头, 若 B 为空则指向 A 链表头
     * 当 A B 指向同一节点或 null 时, 则为相交节点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

}
