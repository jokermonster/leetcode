

public class leetcode_204
{
    /*
    204. 计数质数
统计所有小于非负整数 n 的质数的数量。



示例 1：

输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
示例 2：

输入：n = 0
输出：0
示例 3：

输入：n = 1
输出：0
     */
    public static void main(String[] args) {
      System.out.println(countPrimes(13));
    }
    public  static  int countPrimes(int n) {
        int sum=0;
        for (int i = 1; i <n; i++)
        {
            if(zhi(i)) {
                sum+=1;
            }
        }
       return sum;
    }
    public static boolean zhi(int n)
    {
        if(n==1||n==2)
            return true;
        else {
            for (int i = 2; i < (int)java.lang.Math.sqrt(n)+3;i++)
            {
                if(n%i==0) {
                    return false;
                }
            }
        }
        return true;
    }
}
