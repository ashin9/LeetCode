package org.ashing.tree;

public class isSymmetric101 {

    /**
     *  递归体: 判断 root.left 和 root.right 是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        // 仅一个越过节点 或 值不相等
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
