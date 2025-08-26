package Krahets88.Search;

public class lowestCommonAncestor236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归边界
        if (root == null || root == p || root == q) return root;
        // 递归体
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 那边有返回哪边, 否则返回 root
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
