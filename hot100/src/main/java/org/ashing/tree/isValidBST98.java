package org.ashing.tree;

public class isValidBST98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        long x= root.val;
        return left < x && x < right &&
                isValidBST(root.left, left, x) &&
                isValidBST(root.right, x, right);
    }
}
