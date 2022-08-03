package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2022/6/11
 * Time: 22:09
 * Description: 最长有效括号
 *   给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *   示例 1：
 *     输入：s = "(()"
 *     输出：2
 *     解释：最长有效括号子串是 "()"
 *   示例 2：
 *     输入：s = ")()())"
 *     输出：4
 *     解释：最长有效括号子串是 "()()"
 *   示例 3：
 *     输入：s = ""
 *     输出：0
 *
 */
public class Solution0032 {

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int length = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        // 如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    length = Math.max(length, i - stack.peek());
                }
            }
        }
        return length;
    }
}
