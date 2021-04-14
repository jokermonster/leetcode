import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_783 {
    /*
    783. 二叉搜索树节点最小距离
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同



示例 1：


输入：root = [4,2,6,1,3]
输出：1
示例 2：


输入：root = [1,0,48,null,null,12,49]
输出：1

     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> a=new ArrayList<>();
        int min;
        if (root==null) return 0;
        TreeNode temp=root;
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.empty()||temp!=null)
        {
            while (temp!=null)
            {
                stack.push(temp);
                temp=temp.left;
            }
            temp=stack.pop();
            a.add(temp.val);
            temp=temp.right;
        }
        if (a.size()<2)
            return 0;
        min=a.get(1)-a.get(0);
        for (int i=0;i< a.size()-1;i++)
            min=Math.min(a.get(i+1)-a.get(i),min);
        return min;


    }
}
