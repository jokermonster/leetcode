import java.util.ArrayList;
import java.util.List;

public class leetcode_216_competion {
    public static void main(String[] args) {
   int[] a={1,2,3};
    System.out.println(test2(5,73));
    }
    public static boolean test1(String[] word1, String[] word2){
        /*
        给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
       数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串
       输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
       输出：true
       解释：
       word1 表示的字符串为 "ab" + "c" -> "abc"
       word2 表示的字符串为 "a" + "bc" -> "abc"
       两个字符串相同，返回 true
       1 <= word1.length, word2.length <= 103
       1 <= word1[i].length, word2[i].length <= 103
          1 <= sum(word1[i].length), sum(word2[i].length) <= 103
       word1[i] 和 word2[i] 由小写字母组成
         */
        String w1=new String(""),w2=new String("");
        for(int i=0;i<word1.length;i++)
        {
            w1+=word1[i];
        }
        for(int i=0;i<word2.length;i++)
        {
            w2+=word2[i];
        }
     return (w1.equals(w2));
    }



    public static String test2(int n, int k){
        /*
        小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。

字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。

给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。

注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：

x 是 y 的一个前缀；
如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
输入：n = 3, k = 27
输出："aay"
解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
         */
        String re=new String ("");
     for(int i=0;i<n;i++)
     {
         re+=(char)((n-i-1)*26>=k?'a':('a'+k-(n-i-1)*26-1));
         k-=(n-i-1)*26>=k?1:(k-(n-i-1)*26);
     }
      return re;
    }
    public static int letterToNumber(String letter) {
        int length = letter.length();
        int num = 0;
        int number = 0;
        for (int i = 0; i < length; i++) {
            char ch = letter.charAt(length - i - 1);
            num = (int) (ch - 'A' + 1);
            num *= Math.pow(26, i);
            number += num;
        }
        return number;
    }
    public static int test3(int[] nums){
        /*
        给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。

比方说，如果 nums = [6,1,7,4,1] ，那么：

选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。

请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
输入：nums = [2,1,6,4]
输出：1
解释：
删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
只有一种让剩余数组成为平衡数组的方案。
         */
        int all0=0,all1=0,re=0;
        List<Integer>res=new ArrayList<>();
        List<Integer>save=new ArrayList<>();
        for(int temp:nums)
        {
            res.add(temp);
        }
        save.addAll(res);
        for (int i=0;i<save.size();i++) {
            all0=0;all1=0;
            res.removeAll(res);
            res.addAll(save) ;
            res.remove(i);
            for(int k=0;k<res.size();k++)
            {
                if(k%2==1)
                {
                    all1+=res.get(k);
                }
                else
                {
                    all0+=res.get(k);
                }
            }
            if (all1==all0)
            {
                re++;
            }
        }
return re;
    }

    public static void test4(){
        /*
        给你一个任务数组 tasks ，其中 tasks[i] = [actuali, minimumi] ：

actuali 是完成第 i 个任务 需要耗费 的实际能量。
minimumi 是开始第 i 个任务前需要达到的最低能量。
比方说，如果任务为 [10, 12] 且你当前的能量为 11 ，那么你不能开始这个任务。如果你当前的能量为 13 ，你可以完成这个任务，且完成它后剩余能量为 3 。

你可以按照 任意顺序 完成任务。

请你返回完成所有任务的 最少 初始能量。
输入：tasks = [[1,2],[2,4],[4,8]]
输出：8
解释：
一开始有 8 能量，我们按照如下顺序完成任务：
    - 完成第 3 个任务，剩余能量为 8 - 4 = 4 。
    - 完成第 2 个任务，剩余能量为 4 - 2 = 2 。
    - 完成第 1 个任务，剩余能量为 2 - 1 = 1 。
注意到尽管我们有能量剩余，但是如果一开始只有 7 能量是不能完成所有任务的，因为我们无法开始第 3 个任务。
         */

    }
}
