import org.junit.Test;

public class leetcode_1208 {
    /*
    1208. 尽可能使字符串相等
给你两个长度相同的字符串，s 和 t。

将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。

用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。

如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。

如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。



示例 1：

输入：s = "abcd", t = "bcdf", cost = 3
输出：3
解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
示例 2：

输入：s = "abcd", t = "cdef", cost = 3
输出：1
解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
示例 3：

输入：s = "abcd", t = "acde", cost = 0
输出：1
解释：你无法作出任何改动，所以最大长度为 1。
     */
    @Test
    public void test()
    {
        String s="krpgjbjjznpzdfy";
        String t="nxargkbydxmsgby";
        System.out.println(equalSubstring(s,t,14));
    }
    public int equalSubstring(String s, String t, int maxCost) {
       int[] cost=new int[s.length()];
       int left=0,right=0,len=s.length(),re=0,costtemp=0;
       for (int i=0;i<cost.length;i++)
       {
           cost[i]=s.charAt(i)-t.charAt(i)>0?s.charAt(i)-t.charAt(i):t.charAt(i)-s.charAt(i);
       }
       while(right<len)
       {
          while (costtemp<=maxCost&&right<len)
          {
              costtemp+=cost[right];
              right++;
          }
          re=re>right-left?re:right-left;
          costtemp-=cost[left];
          left++;
       }
       return re;
    }
}
