package org.ashing.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid20 {

    public boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {   // 右括号, 看能否弹出
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {                    // 左括号, 直接进栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 不用 map, 遇到左入站右, 遇到右出栈并匹配
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
