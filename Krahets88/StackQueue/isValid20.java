package Krahets88.StackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid20 {
    /**
     * 自己想到的思路
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if ((cur == ')' && left == '(') || (cur == '}' && left == '{') || (cur == ']' && left == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 用 Map 存放映射关系
     */
    public boolean isValid2(String s) {
        // 若长度为奇数，则肯定不是
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        // 栈保存左括号
        Stack<Character> stack = new Stack<>();
        // Map 保存括号映射
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if (stack.isEmpty() || stack.pop() != map.get(cur)) {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }
}
