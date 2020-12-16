import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class leetcode_290 {
    /*
    290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
     */
    public static void main(String[] args) {
        String s="dog dog dog dog";
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        //使用hashmap.分割str
        String[] a = s.split(" ");
        if (pattern.length()!=a.length)
        {
            return false;
        }
        Map<Character,String> map=new HashMap<Character,String>();
        for (int i = 0; i < a.length; i++) {
            Character key=pattern.charAt(i);
            if (map.containsKey(key))
            {
                if (!map.get(key).equals(a[i]))
                {
                    return false;
                }
            }
            else if (map.containsValue(a[i]))
            {
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object obj = entry.getValue();
                    if (obj != null && obj.equals(a[i])) {
                        if(entry.getKey()!=key)
                        {
                            return false;
                        }
                        break;
                    }
                }
            }
            else
            {
                map.put(key,a[i]);
            }
        }
        return true;
    }
}
