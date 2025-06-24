package Krahets88.LinkedList;

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
     * 回溯 + 哈希表
     * 哈希表记录节点创建情况
     * 不存在则创建, 并递归创建下个节点和随机节点
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
}
