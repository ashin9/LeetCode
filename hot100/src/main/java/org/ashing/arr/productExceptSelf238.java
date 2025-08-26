package org.ashing.arr;

public class productExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        // 左边元素所有乘积 * 右边元素所有乘积
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // 左三角
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        // 右三角, 最后一行只有 1 忽略
        int tmp = 1;
        for (int i = n - 2; i >= 0; i--) {
            tmp *= nums[i+1]; // 每行乘积
            res[i] *= tmp;    // 左边乘以右边每行乘积为结果
        }
        return res;
    }
}
