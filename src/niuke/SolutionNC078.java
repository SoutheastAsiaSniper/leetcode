package niuke;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/4/13
 * Time: 下午4:04
 * Description: 输入一个链表，反转链表后，输出新链表的表头。
 */
public class SolutionNC078 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;

        ListNode node = ReverseList(listNode);
        System.out.println(node.val);
        ListNode temp = node;
        while (temp != null){
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = null;
        ListNode nextNode = null;
        while (head != null){
            nextNode = head.next;
            head.next = newNode;
            newNode = head;
            head = nextNode;
        }
        return newNode;
    }

}
