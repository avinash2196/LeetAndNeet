package LeetCode;

import java.util.Stack;

public class MinStack {
    //stack of int[] ,containing element and min element
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }
        int min = stack.peek()[1];
        stack.push(new int[]{val, Math.min(val, min)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

