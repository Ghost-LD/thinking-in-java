package leetcode;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/19 22:10
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(val+",");
        ListNode temp = next;
        while (temp !=null){
            s.append(temp.val+",");
            temp = temp.next;
        }
        return s.toString();
    }
}
