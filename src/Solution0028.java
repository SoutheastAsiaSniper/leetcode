
/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/3/10
 * Time: 上午11:20
 * Description:
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Solution0028 {

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int size = needle.length();
        for (int i = 0; i < haystack.length() - size + 1; i++){
            String temp = haystack.substring(i, size + i);
            if (temp.equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
