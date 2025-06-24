package Krahets88.LinkedList;

public class mergeTwoLists21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    /**
     * 递归思路
     * 1, 递归边界 : 其中一个为空, 返回另一个
     * 2, 递归体 : 小的选择, 传参数缩小规模, 返回第一个选择的 list
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(n+m)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代思路
     * 1, 创建新 List 保存, 首值随意, 返回新 List.next, 用新指针操作新 List
     * 2, 只要 l1 l2 不为空, 就循环添加小的值, 跟新 cur, 更新 l1.next 和 l2.next
     * 3, 添加非空的到 cur.next
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(1)
     */
    public ListNode mergeTwoListsFor(ListNode l1, ListNode l2) {
        ListNode newl = new ListNode(-1);
        ListNode cur = newl;

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
        cur.next = l1 != null ? l1: l2;

        return newl.next;
    }

}
