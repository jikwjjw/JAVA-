package stack;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class LongestValidParentheses {
    /**
     *
     * @param s = "(()"
     * @return 2
     * 解释: 最长有效括号子串为 "()"
     */
    /**
     *
     * @param s = ")()())"
     * @return 4
     * 解释: 最长有效括号子串为 "()()"
     */
    public static  int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s= "))()())";
        LongestValidParentheses.longestValidParentheses(s);
    }
}

