package org.ashing.tree;

public class diameterOfBinaryTree543 {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 任何路径 = 由某个节点作为根节点，从其左右儿子向下遍历的路径拼接得到
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(res, l + r); // 全局变量记录所有节点作为根时最大路径, 左右深度之和
        return 1 + Math.max(l, r);  // 树的深度
    }
}
