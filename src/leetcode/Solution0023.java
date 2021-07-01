package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/1/27
 * Time: 下午7:23
 * Description:
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *   输入：lists = [[1,4,5],[1,3,4],[2,6]]
 *   输出：[1,1,2,3,4,4,5,6]
 *   解释：链表数组如下：
 *   [
 *     1->4->5,
 *     1->3->4,
 *     2->6
 *   ]
 *   将它们合并到一个有序链表中得到。
 *   1->1->2->3->4->4->5->6
 * 示例 2：
 *   输入：lists = []
 *   输出：[]
 * 示例 3：
 *   输入：lists = [[]]
 *   输出：[]
 */
public class Solution0023 {

    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}
