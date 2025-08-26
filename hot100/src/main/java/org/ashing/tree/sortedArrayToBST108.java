package org.ashing.tree;

public class sortedArrayToBST108 {

    /**
     * 难点: 难以切分 nums 数组
     */
    public TreeNode sortedArrayToBST1(int[] nums) {
        int n = nums.length;
        int mid = (n + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST();
        root.right = sortedArrayToBST();

        return root;
    }

    /**
     * 用辅助函数, 参数传递索引
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) { // 必须判断
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


}
