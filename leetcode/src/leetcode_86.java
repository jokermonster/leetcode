import java.util.List;

public class leetcode_86 {
    /*
    86. 分隔链表
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。



示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {//双指针分割链表，一个指针寻找,一个存储
        if(head == null) return null;
        ListNode left = null;
        ListNode leftCurrent = left;
        ListNode right = null ;
        ListNode rightCurrent = right;
        ListNode current = head;
        while(current != null) {
            if(current.val < x) {
                if(left == null) {
                    left = new ListNode(current.val);
                    leftCurrent = left;
                }else {
                    leftCurrent.next = new ListNode(current.val);
                    leftCurrent = leftCurrent.next;
                }
            }else {
                if(right == null) {
                    right = new ListNode(current.val);
                    rightCurrent = right;
                }else {
                    rightCurrent.next = new ListNode(current.val);
                    rightCurrent = rightCurrent.next;
                }
            }
            current = current.next;
        }
        if(leftCurrent != null) {
            leftCurrent.next = right;
            return left;
        }else {
            return right;
        }
    }
}
