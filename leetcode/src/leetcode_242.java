import java.util.Arrays;

public class leetcode_242 {
    /*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
    示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
     */
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }
}
