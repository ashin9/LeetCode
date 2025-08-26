package org.ashing.subStr;

public class NumArray303 {

    /**
     * 前缀和之差, 是子串和
     */
    class NumArray {
        private final int[] s;

        public NumArray(int[] nums) {
            s = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                s[i+1] = s[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return s[right+1] - s[left];
        }
    }
}
