package org.ashing.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Hash + 递归
     */
    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        // 递归边界
        if (head == null) {
            return null;
        }
        // 递归体
        if (!cachedNode.containsKey(head)) {
            Node newNode = new Node(head.val);
            cachedNode.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }

        return cachedNode.get(head);
    }


    /**
     * map 存储, 两次遍历
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return head;

        // map 记录 node 和 copy node
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 构建
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
