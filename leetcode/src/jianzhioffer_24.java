public class jianzhioffer_24 {
    /*
    剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
      ListNode k=head;
      ListNode j=head;
      ListNode q=head;
      if (k==null)
          return null;
      if(k.next==null)
          return head;
      k=k.next;
      if (k.next==null)
      {
          k.next=head;
          head.next=null;
          return k;
      }
      j=k.next;
      q.next=null;
      while(j!=null)
      {
          k.next=q;
          q=k;
          k=j;
          j=j.next;
      }
      k.next=q;
        return k;
    }
}
