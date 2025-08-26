package org.ashing.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 特殊情况, 无法构造窗口
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }
        // 用 26 长度数组作为 map，记录每个字符出现的次数
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 第一个窗口特殊处理
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        // 滑动固定长窗口
        for (int i = 0; i < sLen - pLen; i++) {
            // 减去头，加上尾，判断
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i+pLen) - 'a'];
            if (Arrays.equals(sCount,pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
