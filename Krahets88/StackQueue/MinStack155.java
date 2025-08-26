package Krahets88.StackQueue;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack155 {
    /** 有小 bug
     *
     */
    /*class MinStack {
        Stack<Integer> minVal;
        LinkedList<Integer> cache;

        public MinStack() {
            this.minVal = new Stack<>();
            this.cache = new LinkedList<>();
        }

        public void push(int val) {
            if (minVal.isEmpty() || val <= minVal.peek()) {
                minVal.push(val);
            }
            cache.addLast(val);
        }

        public void pop() {
            if (cache.getLast() == minVal.peek()) {
                minVal.pop();
            }
            cache.removeLast();
        }

        public int top() {
            return cache.getLast();
        }

        public int getMin() {
            return minVal.peek();
        }
    }*/

    /**
     * 辅助栈, 保存 min 值
     * 每次 push, 保存当前 min 栈和 push 值的小值
     */
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public int pop() {
            stack.pop();
            minStack.pop();
            return 0;
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
