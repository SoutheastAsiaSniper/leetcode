import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/1/27
 * Time: 下午3:16
 * Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *   左括号必须用相同类型的右括号闭合。
 *   左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 	 输入：s = "()"
 * 	 输出：true
 * 示例 2：
 * 	 输入：s = "()[]{}"
 * 	 输出：true
 * 示例 3：
 * 	 输入：s = "(]"
 * 	 输出：false
 * 示例 4：
 * 	 输入：s = "([)]"
 * 	 输出：false
 * 示例 5：
 * 	 输入：s = "{[]}"
 * 	 输出：true
 */
public class Solution0020 {

    public static void main(String[] args) {
        System.out.println(isValid("{}([)]"));
    }

    /**
     * 栈：
     *   后遇到的左括号要先闭合
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int n = s.length();
        // 如果字符串个数奇数，直接返回false
        if (n % 2 == 1){
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            // 如果是左括号则入栈，如果是右括号，则取栈顶元素比较是否闭合
            if (pairs.containsKey(ch)){
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
