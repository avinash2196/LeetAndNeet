package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Map<Character, Character> mapping = new HashMap();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mapping.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != mapping.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
