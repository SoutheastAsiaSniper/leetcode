package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/1/27
 * Time: 下午4:37
 * Description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *   输入：n = 3
 *   输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *   输入：n = 1
 *   输出：["()"]
 */
public class Solution0022 {

    static ArrayList[] cache = new ArrayList[100];

    public static void main(String[] args) {
        generateParenthesis(2);
    }

    public static List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<String>();
//        backtrack(ans, new StringBuilder(), 0, 0, n);
//        return ans;

        return generate(n);
    }

    /**
     * 回溯法
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * 按括号序列的长度递归:
     *   我们需要枚举与第一个 ( 对应的 ) 的位置 2 * i + 1；
     *   递归调用 generate(i) 即可计算 a 的所有可能性；
     *   递归调用 generate(n - i - 1) 即可计算 b 的所有可能性；
     *   遍历 a 与 b 的所有可能性并拼接，即可得到所有长度为 2 * n 的括号序列。
     * @return
     */
    public static List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

}
