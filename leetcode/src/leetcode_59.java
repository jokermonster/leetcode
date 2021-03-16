public class leetcode_59 {
    /*
    59. 螺旋矩阵 II
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。



示例 1：


输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]
     */
    public int[][] generateMatrix(int n) {
        int star=0,end=n-1;
        int[][] re=new int[n][n];
        int k=1;
        while (star<=end)
        {
            for (int i=star;i<=end;i++)
            {
                re[star][i]=k;
                k++;
            }
            for (int i=star+1;i<=end;i++)
            {
                re[i][end]=k;
                k++;
            }
            for (int i=end-1;i>=star;i--)
            {
                re[end][i]=k;
                k++;
            }
            for (int i=end-1;i>star;i--)
            {
                re[i][star]=k;
                k++;
            }
            star++;
            end--;
        }
        return re;
    }
}
