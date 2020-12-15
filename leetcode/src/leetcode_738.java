public class leetcode_738 {
    /*
    738. 单调递增的数字
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(monotoneIncreasingDigits(n));
    }
    public static int monotoneIncreasingDigits(int N) {
        //找第一组逆序数
        int re=0,temp=N;
        int length = (int)(Math.log10(N)+1);
        int[] res=new int[length];
        for(int i=length-1;i>=0;i--)
        {
            res[i]=temp%10;
            temp/=10;
        }
        while(!isSorted(res)) {
            for (int i = 0; i < length - 1; i++) {
                if (res[i] > res[i + 1]) {
                    res[i]--;
                    for (int j=i+1;j<length;j++)
                    {
                        res[j]=9;
                    }
                }
            }
        }
        for (int i=0;i<length-1;i++)
        {
            re+=res[i];
            re*=10;
        }
        re+=res[length-1];
        return re;
    }
    public static boolean isSorted(int[] data)
    {
        boolean flag1 = false;
        for (int i = 0; i < data.length-1; i++) {
            if (data[i] == Math.min(data[i], data[i + 1])) {
                flag1 = true;
            } else {
                flag1 = false;
                break;
            }
        }
        return flag1;
    }
}
