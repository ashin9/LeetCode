package org.ashing.tree;

public class flatten114 {

    /**
     * 只要 root!=null
     * 若 root.left为空,则 root 更新为right
     * 若 root.left非空,则
     *   找到左子树的最右节点
     *   root 的右子树拼到左子树有节点
     *   左子树拼到 root 右子树
     *   下个节点
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为 null，直接考虑下个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找到左子树最右边节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 原来右子树拼到左子树最右边节点
                pre.right = root.right;
                // 左子树拼到右子树
                root.right = root.left;
                root.left = null;
                // 下个节点
                root = root.right;
            }
        }
    }

}
