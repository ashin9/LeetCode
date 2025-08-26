package org.ashing.stack;

import java.util.Stack;

public class MinStack155 {

    private int min;
    private Stack<Integer> s;

    public MinStack155() {
        this.min = Integer.MAX_VALUE;
        this.s = new Stack<>();
    }

    public void push(int val) {
        if (val <= min) {
            s.push(min);        // 先存旧的 min
            min = val;
        }
        s.push(val);
    }

    public void pop() {
        if (s.pop() == min) {  // 弹两次 min
            min = s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}
