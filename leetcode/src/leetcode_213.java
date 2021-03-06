public class leetcode_213 {
    /*
    213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [0]
输出：0
     */
    public int rob(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[2][len];//0行为没偷，1行为偷了
        if (len==0)
            return 0;
        if (len==1)
            return nums[0];
        dp[0][0]=0;
        dp[1][0]=nums[0];
        for (int i=1;i<len-1;i++)
        {
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);  //没偷
            dp[1][i]=dp[0][i-1]+nums[i];  //偷了
        }
        dp[0][len-1]=Math.max(dp[0][len-2],dp[1][len-2]);//没偷

        dp[0][0]=0;//没偷
        dp[1][0]=0;//没偷
        for (int i=1;i<len-1;i++)
        {
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);  //没偷
            dp[1][i]=dp[0][i-1]+nums[i];  //偷了
        }
        dp[1][len-1]=dp[0][len-2]+nums[len-1];//偷了
        return Math.max( dp[0][len-1], dp[1][len-1]);
    }
}
