import java.util.Arrays;
import java.util.Stack;

public class jianzhioffer_54 {
    /*
    剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。



示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
     */
    public int kthLargest(TreeNode root, int k) {
        int[] re=new int[k];
        TreeNode tmp=root;
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(tmp);  //根节点入栈
        while(!s.empty()) {
            //1.访问根节点
            TreeNode p=s.pop();
            if (p.val>re[0])
            {
                re[0]=p.val;
                Arrays.sort(re);
            }
            //2.如果根节点存在右孩子，则将右孩子入栈
            if(p.right!=null) {
                s.push(p.right);
            }
            //3.如果根节点存在左孩子，则将左孩子入栈
            if(p.left!=null) {
                s.push(p.left);
            }
        }
        return re[0];
    }
    //100%时间解法
    int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }

}
