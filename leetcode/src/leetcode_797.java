import java.util.*;
public class leetcode_797 {
    /*
    给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，
即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。


     */
    public static void main(String[] args) {
        int[][] graph= {{2},{},{1}};
        List<List<Integer>> list;
        list=  allPathsSourceTarget(graph);
        for (List temp:list)
        {
            System.out.println(temp);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        if (graph == null || graph.length == 0) return res;
        LinkedList<Integer> temp = new LinkedList<>();
        temp.addLast(0);
        help(temp, res, 0, graph);
        for(List temp1:res)
        {
            if(temp1.contains(graph.length-1)) {
                for (int i = 0; i < temp1.size() - 1 - temp1.indexOf(graph.length - 1); i++) {
                    temp1.remove(temp1.size() - 1);
                }
            }
            else
            {
                res.remove(temp1);
            }
        }
        return res;
    }

    private static void help(LinkedList<Integer> integers, List<List<Integer>> res, int index, int[][] graph) {
        if (graph[index].length == 0) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i : graph[index]) {
            integers.addLast(i);
            help(integers, res, i, graph);
            integers.removeLast();
        }
    }
}
