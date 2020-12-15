import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1370 {
    /*
    给你一个字符串 s ，请你根据下面的算法重新构造字符串：

从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
重复步骤 2 ，直到你没法从 s 中选择字符。
从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
重复步骤 5 ，直到你没法从 s 中选择字符。
重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。

请你返回将 s 中字符重新排序后的 结果字符串 。

示例 1：

输入：s = "aaaabbbbcccc"
输出："abccbaabccba"
解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"

     */
    public static void main(String[] args) {

    System.out.println(sortString("aaaabbbbcccc"));
    }
    public static String sortString(String s) {
        if(s.length()==0)
            return null;
        char[] test = new char[s.length()];
        List<String> str=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder re = new StringBuilder();
        String trim=new String();
        String a = s;//直接读取这行当中的字符串。
            for (int i = 0; i < s.length(); i++) {
                test[i] = a.charAt(i);//字符串处理每次读取一位。
            }
        Arrays.sort(test);
            for (int i = 0; i < test.length; i++) {
                sb.append(test[i]);
            }
        trim = sb.toString().trim();
        int i,j;
        for ( i = 0; i < trim.length(); i++)
        {
            for(j=0;j<str.size()&&str.get(j).contains(test[i]+"");j++)
            {
            }
            if (j<str.size()&&j%2==0)
            {str.set(j,str.get(j)+test[i]);}
            else if(j<str.size()&&j%2==1)
            {
                str.set(j,test[i]+str.get(j));
            }
            else
            {  str.add(test[i]+"");}
        }
      for (int gg=0;gg<str.size();gg++)
      {
         re.append(str.get(gg));
      }
        return re.toString();

    }

}
