package org.ashing;

public class lengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希表优化：用数组 index[128] 替代 HashMap，记录每个字符最后一次出现的位置的下一个位置（即如果重复，left 应该跳到哪里）
        int[] index = new int[128];
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            left = Math.max(left, index[ch]);
            maxLen = Math.max(maxLen, right - left + 1);
            index[ch] = right + 1;
        }
        return maxLen;
    }
}
