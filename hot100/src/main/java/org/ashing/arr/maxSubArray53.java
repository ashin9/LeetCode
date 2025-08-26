package org.ashing.arr;

public class maxSubArray53 {
    /**
     * 动态规划思想: 将复杂问题分解为互相关联的子问题, 并存储子问题的解以免重复计算
     * 动态规划特征:
     * 1, 最优子结构
     * 2, 重叠子问题
     * 3, 无后效性
     */
    public int maxSubArray(int[] nums) {
        // 状态定义
        // dp[i] 表示以元素 nums[i] 为结尾的连续子数组最大和

        // 转移方程
        // dp[i-1]>0, dp[i] =  dp[i-1] + nums[i]
        // dp[i-1]<=0, dp[i] = dp[i]

        // 状态压缩: dp[i] 只与 dp[i-1] 和 nums[i] 有关系， 将 nums 作为 dp 表

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
