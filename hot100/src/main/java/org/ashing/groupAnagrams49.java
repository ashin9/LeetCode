package org.ashing;

import java.util.*;

public class groupAnagrams49 {

    /**
     * 每个字符串排序后作为 Map 的 Key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // 遍历每个字符串, 转换为字符数组后排序, 然后构造 String 作为 Map 的 Key
        for (String str: strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
