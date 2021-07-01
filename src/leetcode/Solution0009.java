package leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class Solution0009 {

    public static void main(String[] args) {
        int x = 120;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x >= 0 && x < 10){
            return true;
        }
        if (x % 10 == 0 || x < 0){
            return false;
        }
        int tmp = x;
        int rev =0;
        while(tmp != 0){
            int rem = tmp % 10;
            tmp /= 10;
            rev = rev * 10 + rem;
        }
        if (rev == x){
            return true;
        }else {
            return false;
        }
    }
}
