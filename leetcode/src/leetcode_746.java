import org.junit.Test;

public class leetcode_746 {
    /*
    数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

示例 1:

输入: cost = [10, 15, 20]
输出: 15
解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 示例 2:

输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。

     */
    @Test
    public void test1()
    {
         int[] a={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
         System.out.println(minCostClimbingStairs(a));

    }
    public int minCostClimbingStairs(int[] cost) {//变形斐波那契数列
     int[] cost0=new int[cost.length+1];//从0开始走
     int[] cost1=new int[cost.length+1];//从1开始走
        if (cost.length==2)
        {
            return Math.min(cost[0],cost[1]);
        }
     cost0[0]=0;
     cost0[1]=0;
     cost1[0]=0;
     cost1[1]=0;
     cost1[2]=cost[1];
     cost0[2]=Math.min(cost[0],cost[1]);
     for (int i=3;i<cost.length+1;i++)
     {
         cost0[i]=Math.min(cost0[i-1]+cost[i-1],cost0[i-2]+cost[i-2]);
         cost1[i]=Math.min(cost1[i-1]+cost[i-1],cost1[i-2]+cost[i-2]);
     }
     return Math.min(cost0[cost.length],cost1[cost.length]);
    }
}
