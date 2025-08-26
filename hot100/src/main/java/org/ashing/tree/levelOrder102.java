package org.ashing.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder102 {

    /**
     *
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return new LinkedList<>();
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) { // 记住 queue.size() --
                TreeNode curNode = queue.poll();     // 记住 poll()
                curLevel.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }
}
