package Krahets88.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class isAnagram242 {
    public boolean isAnagram(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if (sn != tn) {
            return false;
        }

        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < sn; i++) {
            ht.put(s.charAt(i), ht.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> htt = new HashMap<>();
        for (int i = 0; i < tn; i++) {
            htt.put(t.charAt(i), htt.getOrDefault(t.charAt(i), 0) + 1);
        }
        if(ht.equals(htt)) {
            return true;
        }
        return false;
    }

    /**
     * 排序后比较两个字符长度和内容是否相等
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }
}
