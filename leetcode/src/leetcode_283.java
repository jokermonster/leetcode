public class leetcode_283 {

    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    /*
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
     */
    public  static void main(String[] args) {
        int[] a={0,1,0,3,12};
        //System.out.println(a.length-1);
        moveZeroes(a);
        for (int x:a
                ) {
            System.out.println(x);
        }

    }

    public static void moveZeroes(int[] nums) {//类似于冒泡排序
        int num=0;
        int length=nums.length;
        for(int i=length-1;i>=0;i--)
        {
            if (nums[i]==0)
            {

                int temp=nums[i];
                for (int j=i;j<length-1-num;j++)
                {
                    nums[j]=nums[j+1];
                }
                nums[length-1-num]=temp;
                num++;
            }

        }
    }

    public static void moveZeroes2(int[] nums) {
        //思路：设置一个index，表示非0数的个数，循环遍历数组，
        // 如果不是0，将非0值移动到第index位置,然后index + 1
        //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
