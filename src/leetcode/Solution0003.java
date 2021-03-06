package leetcode;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution0003 {

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int rk = 0, ans = 0;
        for (int i = 0; i < s.length(); i++){
            rk = i;
            while (rk < s.length() && !set.contains(s.charAt(rk))){
                set.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans, rk - i);
            set.clear();
        }
        return ans;
    }

}
