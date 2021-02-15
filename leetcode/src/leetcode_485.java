public class leetcode_485 {
    /*
    485. 最大连续1的个数
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int re = 0, flag = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0)
            {
                re=re>temp?re:temp;
                temp=0;
            }
            else
            {
                temp++;
            }
        }
        re=re>temp?re:temp;
        return re;
    }
}
