public class jianzhioffer_25 {
    /*
    剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode re=new ListNode();
        ListNode k=re;
        ListNode t1=l1,t2=l2;
        while(t1!=null&&t2!=null)
        {
            if(t1.val< t2.val)
            {
                re.next=t1;
                t1=t1.next;
                re=re.next;
            }
            else
            {
                re.next=t2;
                t2=t2.next;
                re=re.next;
            }
        }
        re.next=t1==null?t2:t1;
        k=k.next;
        return k;

    }
}
