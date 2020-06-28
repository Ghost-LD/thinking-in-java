package leetcode;

/**
 * 去除链表中相同节点
 *
 * @author yitian
 * @date 2020/6/20 13:52
 */
public class Solution3 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(3);
        head.next = head2;
        ListNode head3 = new ListNode(2);
        head2.next = head3;
        ListNode head4 = new ListNode(2);
        head3.next = head4;
        ListNode head5 = new ListNode(4);
        head4.next = head5;
        ListNode head6 = new ListNode(5);
        head5.next = head6;
        ListNode re = deleteDuplicates2(head);
        System.out.println(re);
    }


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode cur = listNode;
        while (cur.next != null && cur.next.next !=null){
            //循环条件为cur.next和cur.next.next存在
            if(cur.next.val == cur.next.next.val){
                //值相同进入while循环
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val==temp.next.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
            }else {
                cur = cur.next;
            }
        }
        return listNode.next;
    }



    private static ListNode temp;
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode curHead = deleteDuplicates2(head.next);
        if(temp == null){
            temp = curHead;
        }
        if (temp.val == head.val) {
            return temp.next;
        } else {
            head.next = curHead;
            temp = head;
            return head;
        }
    }

}
