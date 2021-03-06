package leetcode.力扣题.题32;


import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 通过次数75,054提交次数234,096
 */
class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack();
        int maxans = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {

                stack.push(i);

            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);

                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }


        return maxans;






    }
}
