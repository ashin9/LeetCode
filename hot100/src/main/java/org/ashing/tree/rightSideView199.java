package org.ashing.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView199 {

    /**
     * dfs 优先访问右子树, 每次深度先到达的是视图
     */
    public List<Integer> rightSideView1(TreeNode root) {
        // 递归先访问右子树，再访问左子树，每个深度首次到达时，对应的节点就在右视图中
        List<Integer> res = new LinkedList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return ;
        }
        if (depth == res.size()) {  // 深度 == res 大小
            res.add(root.val);
        }
        dfs(root.right, depth + 1, res);
        dfs(root.left, depth + 1, res);
    }

    /**
     * 层序遍历, 每层最后一个是右视图
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if (i == 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }


}
