package org.ashing;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive128 {

    /**
     * 思路: 遍历每个元素, 若元素存在 -1 的说明不可以作为最长连续序列的开头跳过, 否则可以, 然后计算最长连续长度
     */

    public int longestConsecutive(int[] nums) {
        int longest = 0;
        // 先把所有元素放入 Set
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        for (int num : num_set) {           // 遍历每个元素
            if (!num_set.contains(num-1)) { // 可作为开头
                int curNum = num;
                int curLong = 1;
                while (num_set.contains(curNum+1)) { // 计算最长长度
                    curNum++;
                    curLong++;
                }
                longest = Math.max(longest, curLong);
            }
        }
        return longest;
    }
}
