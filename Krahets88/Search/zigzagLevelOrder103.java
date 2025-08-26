package Krahets88.Search;

import java.util.*;

public class zigzagLevelOrder103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) { // queue.size() 随着 add 元素动态变化, 所以可以初始 i=queue.size()
                TreeNode node = queue.poll();

                // 构造结构时Z字构造
                if (res.size() % 2 == 0) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
