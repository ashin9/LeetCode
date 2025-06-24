package Krahets88.StackQueue;

import java.util.Stack;

public class MyQueue232 {
    class MyQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            while (!outStack.isEmpty()) {
                inStack.push(outStack.pop());
            }
            inStack.push(x);
        }

        public int pop() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        public int peek() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
