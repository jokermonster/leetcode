import org.junit.Test;

import java.util.Arrays;

public class jhianzhioffer_17 {
    /*
    剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
     */
    @Test
    public void te()
    {
        leetcode_236competion obj =new leetcode_236competion(3,1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
       System.out.println(obj.calculateMKAverage());  // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [3,1,10]
        System.out.println(obj.calculateMKAverage());  // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage());   // 最后 3 个元素为 [5,5,5]


    }
    public int[] printNumbers(int n) {
     int jie=1;
     for (int i=0;i<n;i++)
     {
         jie*=10;
     }
     int[] re=new int[jie-1];
     for (int i=1;i<jie;i++) {
         re[i-1] = i;
     }
     return re;
    }
}
