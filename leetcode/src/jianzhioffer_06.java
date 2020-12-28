public class jianzhioffer_06 {
    /*
    剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
     */
    public int[] reversePrint(ListNode head) {
          ListNode t=head;
          int n=0;
          while (t!=null)
          {
              n++;
              t=t.next;
          }
          int[] re=new int[n];
          t=head;
          while (t!=null)
          {
              re[n-1]=t.val;
              n--;
              t=t.next;
          }
        return re;
    }
}
