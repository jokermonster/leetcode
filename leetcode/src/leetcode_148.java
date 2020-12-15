public class leetcode_148 {
    /*
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     */
    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {

    }
    public ListNode sortList(ListNode head) {//时间复杂度为O(n2)
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
    //递归归并排序
    public ListNode sortList2(ListNode head) {//时间复杂度为O(nlogn)空间不是O(1)递归
        if (head==null)
        {
            return null;
        }
        if(head==null || head.next==null) return head;
        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针

        while(fast!=null && fast.next!=null){ //快慢指针找到链表中点
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
        }
        ListNode rightHead = slow.next; //链表第二部分的头节点
        slow.next = null; //cut 链表

        ListNode left = sortList2(head); //递归排序前一段链表
        ListNode right = sortList2(rightHead); //递归排序后一段链表
        return merge(left,right);

    }
    public ListNode merge(ListNode h1,ListNode h2){ //合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if(h1!=null)    p.next = h1;
        else if(h2!=null) p.next = h2;
        return dummy.next;

    }
    //迭代
    public ListNode sortList3(ListNode head) {
        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for(int step = 1; step < length; step*=2){ //依次将链表分成1块，2块，4块...
            //每次变换步长，pre指针和cur指针都初始化在链表头
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while(cur!=null){
                ListNode h1 = cur; //第一部分头 （第二次循环之后，cur为剩余部分头，不断往后把链表按照步长step分成一块一块...）
                ListNode h2 = split(h1,step);  //第二部分头
                cur = split(h2,step); //剩余部分的头
                ListNode temp = merge3(h1,h2); //将一二部分排序合并
                pre.next = temp; //将前面的部分与排序好的部分连接
                while(pre.next!=null){
                    pre = pre.next; //把pre指针移动到排序好的部分的末尾
                }
            }
        }
        return dummy.next;
    }
    public int getLength(ListNode head){
        //获取链表长度
        int count = 0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public ListNode split(ListNode head,int step){
        //断链操作 返回第二部分链表头
        if(head==null)  return null;
        ListNode cur = head;
        for(int i=1; i<step && cur.next!=null; i++){
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null; //切断连接
        return right;
    }
    public ListNode merge3(ListNode h1, ListNode h2){
        //合并两个有序链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }
            else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if(h1!=null)    p.next = h1;
        if(h2!=null)    p.next = h2;

        return head.next;
    }



}
