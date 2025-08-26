package org.ashing.tree;

public class invertTree226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;           // 临时记录好原 left
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}
