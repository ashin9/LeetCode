package Krahets88.HashTable;

public class longestPalindrome409 {
    /**
     * 完全没有思路
     */

    /**
     * 将每个字符使用偶数次, 若还有剩余则作为回文中心
     * count[] 存储字符出现的次数, ans 记录回文串长度
     * 若字符出现次数为奇数且 ans 为偶数, 则可以选择当中心, ans++
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
