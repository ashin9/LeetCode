package org.ashing.greedy;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels763 {
    /**
     * 思路（贪心）
     *
     * 统计每个字母最后出现的位置
     *
     * 遍历字符串，记录 last[c] = 最后一次出现的索引
     *
     * 划分子串
     *
     * 遍历字符串，用 end 记录当前子串能延伸的最远位置
     *
     * 遇到每个字符 c：
     *
     * end = max(end, last[c])
     *
     * 当索引 i == end 时：
     *
     * 当前子串结束
     *
     * 记录长度 i - start + 1
     *
     * 更新 start = i + 1
     *
     * 核心贪心点：每次都尽量把子串延伸到包含所有出现的字母的最远位置，保证子串最大，但不会影响之后的子串划分。
     * @param s
     * @return
     */

    public List<Integer> partitionLabels(String s) {
        // 记录每个字母出现的最后位置
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            last[c - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}
