public class leetcode_147 {
    /*
    对链表进行插入排序。
     */
    public static void main(String[] args) {

    }
    public ListNode insertionSortList(ListNode head) {
        if (head==null)
        {
            return null;
        }
        ListNode headhead=new ListNode(head.val);
        headhead.next=head;
        ListNode now=new ListNode(head.val);
        now=head;
        ListNode location=new ListNode(head.val);
        while(head.next!=null)
        {
            if(head.next.val<head.val)
            {
                now=headhead;
              for (location=headhead.next;location.val<head.next.val;location=location.next)
              {
                 now=now.next;
              }
                ListNode temp=new ListNode(head.val);
                temp=head.next;
                now.next=temp;
                head.next=head.next.next;
                temp.next=location;
            }
            else
            {
                head=head.next;
            }
        }
        return headhead.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

