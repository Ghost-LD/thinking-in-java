package leetcode;

/**
 *  删除链表的倒数第N个节点
 *
 * @author yitian
 * @date 2020/6/19 22:09
 */
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}
