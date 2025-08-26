package org.ashing.tree;

import java.util.LinkedList;
import java.util.List;

public class inorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    /**
     * 辅助函数, 多个参数记录过程构造结果
     * @param root
     * @param res
     */
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
