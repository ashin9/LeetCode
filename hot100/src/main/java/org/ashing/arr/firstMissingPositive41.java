package org.ashing.arr;

public class firstMissingPositive41 {

    /**
     * 直观思路: 所有数字放入 hash 表, 从 1 开始到 n, 判断是否在, 第一个不在的就是答案
     * 问题: 不符合空间复杂度 O(1)
     */

    /**
     * 优化思路: 原地 hash
     * hash 规则: 每个地方存放的数 = 索引 + 1
     * num[i] = num[nums[i] - 1] // nums[i] 的值应该为 i+1 因此, nums[i]-1 = i + 1 - 1 = i
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 遍历每个元素, 只要在 1-n 之间, 交换到应有的 hash 位置
        for (int i = 0; i < n; i++) {
            // 因为交换后, i 处元素可能仍不在正确位置, 所以 while 一直交换
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 找第一个不符合规则的元素
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void  swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
