public class leetcode_861 {
    /*
    有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

返回尽可能高的分数。

 

示例：

输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
     */
    public static void main(String[] args) {

    }
    public int matrixScore(int[][] A) {

        int m = A.length, n = A[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            // 如果第 i 行以 0 开头
            if (A[i][0] == 0) {
                // 行翻转
                for (int j = 0; j < n; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            // 统计第 j 列有多少个 1。
            for (int i = 0; i < m; i++) {
                cnt += A[i][j];
            }
            // max(cnt, m - cnt) 表示这个位置最多有多少个 1。 1<<(n-j-1) 表示这个位置的1的大小。
            result += Math.max(cnt, m - cnt) * (1 << (n - j - 1));
        }
        return result;

    }

}
