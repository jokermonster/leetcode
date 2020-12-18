import org.junit.Test;

public class leetcode_389 {
    /*
    389. 找不同
给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。



示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
     */
    @Test
    public void test1()
    {
        System.out.println(findTheDifference("","a"));
    }
    public char findTheDifference(String s, String t) {//创建26长度的数组，s进，t出，最后剩下就是答案
        int[] re=new int[26];
        char res;
        for (int i=0;i<s.length();i++)
        {
            re[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++)
        {
            re[t.charAt(i)-'a']--;
        }
        for (int i=0;i<re.length;i++)
        {
            if(re[i]!=0)
            {
                return (char)((int)('a')+i) ;
            }
        }
         return 'a';
    }
    public char findTheDifference2(String s, String t) {//位运算
        char ans = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;

    }
}
