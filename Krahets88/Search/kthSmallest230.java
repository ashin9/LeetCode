package Krahets88.Search;

public class kthSmallest230 {

    /**
     * BST 的中序遍历是递增的, 因此等价于求遍历的第 k 个元素
     */

    int res, k;

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        // BST 的中序遍历是递增的, 因此等价于求遍历的第 k 个元素
        this.k = k;
        dfs(root);
        return res;
    }
}
