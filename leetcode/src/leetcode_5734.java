public class leetcode_5734 {
    /*
    5734. 判断句子是否为全字母句
全字母句 指包含英语字母表中每个字母至少一次的句子。

给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。

如果是，返回 true ；否则，返回 false 。



示例 1：

输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
输出：true
解释：sentence 包含英语字母表中每个字母至少一次。
示例 2：

输入：sentence = "leetcode"
输出：false
     */
    public boolean checkIfPangram(String sentence) {
        int re=0,len=sentence.length();
        boolean[] a=new boolean[26];
        for (int i=0;i<26;i++)
            a[i]=true;
        for (int i=0;i<len;i++)
        {
            int k=sentence.charAt(i)-'a';
            if (a[k])
            {
                a[k]=false;
                re++;
                if (re==26)
                    return true;
            }
        }
        return false;
    }
}
