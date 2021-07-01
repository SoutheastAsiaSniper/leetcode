package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/1/26
 * Time: 下午8:40
 * Description:
 *      给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *      实例 1：
 *      输入：head = [1,2,3,4,5], n = 2
 *      输出：[1,2,3,5]
 *
 *      示例 2：
 *      输入：head = [1], n = 1
 *      输出：[]
 *
 *      示例 3：
 *      输入：head = [1,2], n = 1
 *      输出：[1]
 *
 */
public class Solution0019 {

    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(1, new ListNode1(2, new ListNode1(3)));
        ListNode1 listNode11 = removeNthFromEnd1(listNode1, 1);
    }

    /**
     * 计算链表长度
     * @param head
     * @param n
     * @return
     */
    public static ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        // 从哑节点开始遍历，删除第L-n+1的下一个节点
        ListNode1 node1 = new ListNode1(0, head);
        int length = getLength(head);
        ListNode1 cur = node1;
        // 遍历到第L-n+1个节点
        for (int i = 1; i < length - n + 1; ++i){
            cur = cur.next;
        }
        // 修改指针指向需要删除节点的后一个节点
        cur.next = cur.next.next;
        ListNode1 res = node1.next;
        return res;
    }

    public static int getLength(ListNode1 head){
        int length = 0;
        while (head != null){
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 栈
     *   我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，
     *   我们弹出栈的第n个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。
     * @param head
     * @param n
     * @return
     */
    public static ListNode1 removeNthFromEnd1(ListNode1 head, int n) {
        ListNode1 listNode1 = new ListNode1(0, head);
        Deque<ListNode1> stack = new LinkedList<ListNode1>();
        ListNode1 cur = listNode1;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++){
            stack.pop();
        }
        // 检索栈中的第一个元素
        ListNode1 prev = stack.peek();
        prev.next = prev.next.next;
        ListNode1 res = listNode1.next;
        return res;
    }

}



class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}