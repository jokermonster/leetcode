public class bufenpaixu_16_6 {
    /*
    给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
    注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。

示例：

输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
输出： [3,9]

     */
    /*
    从左往右走一遍确定下界，从右往左走一遍确定上界
     */
    public static void main(String[] args) {
int[] array={1,2,4,7,10,11,7,12,6,7,16,18,19};
int[] re=subSort(array);
        System.out.println(re[0]);
        System.out.println(re[1]);
    }
    public static int[] subSort(int[] array) {

      int max1,max_id,min1,min_id;
      int [] a={-1,-1};
      max1=array[array.length-1];
      min1=array[0] ;
      max_id=array.length-1;
      min_id=0;
      int flag=0;

      for (int i=0;i<array.length-1;i++)
      {
          if (array[i+1]<array[i])
          {flag=1;}
          min1=array[min_id]<=array[i]?array[min_id]:array[i];
          min_id=array[min_id]<=array[i]?min_id:i;
          max1=array[max_id]>=array[i]?array[max_id]:array[i];
          max_id=array[max_id]>=array[i]?max_id:i;
      }
      if (flag==0)
      {
          return a;
      }
      flag=0;
      if(min_id!=0&&max_id!=array.length-1)
      {
          a[0]=0;
          a[1]=array.length;
          return a;
      }
      if(min_id!=0)
      {
          min_id=0;
      }
      else
      {
          min_id=0;
          for (int i=0;i<array.length-1;i++)
          {
              if (array[i+1]<array[i])
              {
                  if(flag==0)
                  {
                      int j=i;
                      while(array[i+1]<array[j])
                      {
                          j--;
                      }
                      min1=array[j+1];
                      min_id=j+1;
                      flag=1;
                  }
                  else
                  {
                      if(array[i+1]<min1)
                      {
                          int j=min_id;
                          while(array[i+1]<array[j])
                          {
                              j--;
                          }
                          min1=array[j+1];
                          min_id=j+1;
                      }
                  }

              }
          }
      }
      flag=0;
      if(max_id!=array.length-1)
        {
            max_id=array.length-1;
        }
      else
        {
            max_id=array.length-1;
            for (int i=array.length-1;i>0;i--)
            {
                if (array[i-1]>array[i])
                {
                    if(flag==0)
                    {
                        int j=i;
                        while(array[i-1]>array[j])
                        {
                            j++;
                        }
                        max1=array[j-1];
                        max_id=j-1;
                        flag=1;
                    }
                    else
                    {
                        if(array[i-1]>max1)
                        {
                            int j=max_id;
                            while(array[i-1]>array[j])
                            {
                                j++;
                            }
                            max1=array[j-1];
                            max_id=j-1;
                        }
                    }

                }
            }
        }
      a[0]=min_id;
      a[1]=max_id;
      return a;
    }
}
