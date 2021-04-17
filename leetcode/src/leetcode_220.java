import org.junit.Test;

import java.util.TreeSet;

public class leetcode_220 {
    /*220. 存在重复元素 III
给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。

如果存在则返回 true，不存在返回 false。



示例 1：

输入：nums = [1,2,3,1], k = 3, t = 0
输出：true
示例 2：

输入：nums = [1,0,1,1], k = 1, t = 2
输出：true
示例 3：

输入：nums = [1,5,9,1,5,9], k = 2, t = 3
输出：false
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {//abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);// ceiling(E e) {返回Set中大于/等于e的最小元素
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;



    }
    @Test
    public void test(){
        System.out.println(containsNearbyAlmostDuplicate(new int[]{2147483646,2147483647},3,3));
;
    }
}
