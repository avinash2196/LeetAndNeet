package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {

    List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, "");
        return answer;
    }

    private void generate(int n, int open, int close, String curr) {
        if (open == n && close == n) {
            answer.add(curr);
            return;
        }
        if (open < n) {
            generate(n, open + 1, close, curr + "(");
        }
        if (close < open) {
            generate(n, open, close + 1, curr + ")");
        }
    }
}
