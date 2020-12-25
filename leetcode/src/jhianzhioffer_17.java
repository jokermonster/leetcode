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
        System.out.println(Arrays.toString(printNumbers(2)));
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
