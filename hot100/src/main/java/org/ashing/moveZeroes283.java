package org.ashing;

public class moveZeroes283 {

    public void moveZeroes(int[] nums) {
        // 双指针, i 指针走一遍, j记录非 0 的数量

        // 第一次遍历 j 指针记录非 0 的个数
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // 第二次遍历, 剩下的元素赋 0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
