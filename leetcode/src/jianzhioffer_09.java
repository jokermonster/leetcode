import java.util.Stack;

public class jianzhioffer_09 {
    /*
    剑指 Offer 09. 用两个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )



示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
     */
    public Stack<Integer> s1=new Stack<>();//出头节点
    public Stack<Integer> s2=new Stack<>();//进尾节点
    public jianzhioffer_09() {

    }

    public void appendTail(int value) {
         s2.push(value);
    }

    public int deleteHead() {
        if (s1.empty()) {
            if (s2.empty())
                return -1;
            else {
                while (!s2.empty()) {
                    s1.push(s2.pop());
                }
            }
        }
        return s1.pop();
    }
}
