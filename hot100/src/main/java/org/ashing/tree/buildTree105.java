package org.ashing.tree;

import java.util.HashMap;

public class buildTree105 {

    /**
     * 每太看懂
     */
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // 记录中序索引
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]); // 根节点
        int i = dic.get(preorder[root]);              // 划分左右子树
        // 递归构建
        node.left = recur(root + 1, left, i - 1);             // 左子树 root 为 preorder 的 root+1索引
        node.right = recur(root + i - left + 1, i + 1, right); // i-left 为左子树数量, 再+1 就是右子树 root 索引
        return node;
    }
}
