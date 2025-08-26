package org.ashing.subStr;

import java.util.HashMap;
import java.util.Map;

public class subarraySum560 {

    /**
     * 枚举, 遍历每个以 i 为结尾的字符串
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        // 以 i 结尾的子串
        for (int i = 0; i < nums.length; i++) {
            int numi = 0;
            for (int j = i; j >= 0; j--) {
                numi += nums[j];
                if (numi == k) {
                    res++;
                }
            }
        }
        return res;
    }


    public int subarraySum(int[] nums, int k) {
        // s 中有多少对下标(i,j)满足i<j且s[j]-s[i]=k? s[j]=k+s[i]
        int n = nums.length;
        // 前缀和
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + nums[i];
        }

        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int sj: s) {
            res += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum);
        }
        return res;
    }

}
