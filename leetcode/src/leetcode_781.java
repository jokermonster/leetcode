import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode_781 {
    /*
    781. 森林中的兔子
森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。

返回森林中兔子的最少数量。

示例:
输入: answers = [1, 1, 2]
输出: 5
解释:
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。

输入: answers = [10, 10, 10]
输出: 11

输入: answers = []
输出: 0
     */
    @Test
    public void test() {
        int[] test=new int[]{1,0,1,0,0};
        System.out.println(numRabbits(test));
    }
    public int numRabbits(int[] answers) {
        if (answers==null) {
            return 0;
        }
        int an=0;
        HashMap<Integer,Integer> re=new HashMap<>();
        for (int i=0;i<answers.length;i++)
        {
            if (re.containsKey(answers[i]))
                re.put(answers[i],re.get(answers[i])+1);
            else
                re.put(answers[i],1);
        }
        for (Map.Entry<Integer, Integer> temp : re.entrySet())
        {
            if (temp.getKey()+1>= temp.getValue())//有value个猴说有key个猴跟他们一样   有十一个猴说，有十个猴跟他们一样，有五个猴说有十一个跟他们一样 value<=key+1
                an+=temp.getKey()+1;
            else
            {
                while (temp.getKey()+1< temp.getValue())//有十二个猴说，十个猴跟他们呢一样，十二个猴为 11+11
                {
                    an+=temp.getKey()+1;
                    temp.setValue(temp.getValue()-temp.getKey()-1);
                }
                an+=temp.getKey()+1;
            }
        }
        return an;
    }
}
