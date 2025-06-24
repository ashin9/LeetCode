package Krahets88.HashTable;

import java.util.HashMap;
import java.util.Map;

public class isIsomorphic205 {

    class Solution {
        /**
         * 自己思路: 一张 hash, 挨个字符判断
         * @param s
         * @param t
         * @return
         */
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Character> map = new HashMap<>();
            for (int i = 0 ; i < s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);

                if (map.get(sc) == null) {
                    if (map.values().contains(tc)) {
                        return false;
                    }
                    map.put(sc, tc);
                }
                if (map.get(sc) != tc) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 两张 hash 表, 同时维护双向映射, 若发现存在 key 则检查 value 是否为当前映射字符, 若不是则说明冲突
         */
        public boolean isIsomorphic2(String s, String t) {
        }

    }
}
