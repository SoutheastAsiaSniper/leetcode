package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/1/27
 * Time: 下午8:09
 * Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 *   输入：head = [1,2,3,4]
 *   输出：[2,1,4,3]
 * 示例 2：
 *   输入：head = []
 *   输出：[]
 * 示例 3：
 *   输入：head = [1]
 *   输出：[1]
 */
public class Solution0024 {

    public static void main(String[] args) {

    }

    /**
     * 递归的方法
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = head.next;
        head.next = swapPairs(newNode.next);
        newNode.next = head;
        return newNode;
    }

    /**
     * 递归：
     *   创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
     *   如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        // 哑节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 表示当前到达的节点
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }


}
