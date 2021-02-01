import javax.swing.*;
import java.util.Arrays;

public class leetcode_888 {
    /*
   888. 公平的糖果棒交换
爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

如果有多个答案，你可以返回其中任何一个。保证答案存在。



示例 1：

输入：A = [1,1], B = [2,2]
输出：[1,2]
示例 2：

输入：A = [1,2], B = [2,3]
输出：[1,2]
示例 3：

输入：A = [2], B = [1,3]
输出：[2,3]
示例 4：

输入：A = [1,2,5], B = [2,4]
输出：[5,4]
     */
    public int[] fairCandySwap(int[] A, int[] B) {
            int sum1=0,sum2=0,cha;
            int[] re=new int[2];
            for (int i=0;i<A.length;i++)
                 sum1+=A[i];
            for (int i=0;i<B.length;i++)
                sum2+=B[i];
            cha=(sum1-sum2)/2;
            Arrays.sort(A);
            Arrays.sort(B);
            int i=0,j=0;
            while (i<A.length&&j<B.length)
            {
                if (A[i]-B[j]==cha)
                {
                 re[0]=A[i];
                 re[1]=B[j];
                 break;
                }
                else if(A[i]-B[j]<cha)
                    i++;
                else
                    j++;
            }
            return re;

    }
}
