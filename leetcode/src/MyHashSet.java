import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    public ArrayList<LinkedList<Integer>> hashSet=new ArrayList<LinkedList<Integer>>();

    /** Initialize your data structure here. */
    public MyHashSet() {
        for (int i=0;i<769;i++)
        {
            LinkedList<Integer>temp=new LinkedList<>();
            hashSet.add(temp);
        }
    }

    public void add(int key) {
        if (!contains(key))
            hashSet.get(key%769).add(key);
    }

    public void remove(int key) {
        if ( hashSet.get(key%769).contains(key))
        {
            for (int i=0;i<hashSet.get(key%769).size();i++)
            {
                if (hashSet.get(key%769).get(i)==key)
                {
                    hashSet.get(key%769).remove(i);
                    return;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashSet.get(key%769).contains(key);
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
