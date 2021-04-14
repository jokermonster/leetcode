import java.util.ArrayList;
import java.util.List;

public class Trie {
    /*
    208. 实现 Trie (前缀树)
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。


示例：

输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
     */
    List<List<String>> tr=new ArrayList<List<String>>();
    public Trie() {
        for (int i=0;i<26;i++)
        {
            List<String> temp=new ArrayList<>();
            tr.add(temp);
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        tr.get((int)(word.charAt(0)-'a')).add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int a=word.charAt(0)-'a';
        for (int i=0;i<tr.get(a).size();i++)
        {
            if (word.equals(tr.get(a).get(i)))
                return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int a=prefix.charAt(0)-'a',len=prefix.length();
        for (int i=0;i<tr.get(a).size();i++)
        {
            if (tr.get(a).get(i).length()<len)
                continue;
            if (tr.get(a).get(i).substring(0,len).equals(prefix))
                return true;

        }
        return false;
    }
}
