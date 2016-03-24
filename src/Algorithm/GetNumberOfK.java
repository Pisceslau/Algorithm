package Algorithm;

/**
 * Created by Lunar on 2016/3/24.
 * 剑指Offer第三十八题：数字在排序数组中出现的次数
 * 思路：(1):找到数组第一个k的位置
 * 运用二分查找的方法找到第一个k:如果数组中间的数<k则在数组右边下一轮
 * 如果数组中间的数>k则在数组左边下一轮
 * 如果数中间的数和k一样大小，则判断是不是第一个k,若前面的数字大小也是k,则前移动，
 * 反之本身就是第一个k.
 * （2）用同样的思路实现找到数组中最后一个k的位置
 * (3)right-left+1得到次数
 * 注意：各种边界条件！！！！
 */
public class GetNumberOfK {
    public static int getFirstK(int[] a, int left, int right, int k) {
        if (a == null || left > right) return -1;
        int length = a.length;
        int middle = (left + right) / 2;
        int middleData = a[middle];
        if (middleData == k) {
            //等于k的情况
            if ((middle > 0 && a[middle - 1] != k)||middle==0) {
                return middle;
            } else {
                right = middle - 1;
            }
        } else if (middleData < k) {

            left = middle + 1;

        } else {
            right = middle - 1;
        }
        return getFirstK(a, left, right, k);

    }

    //得到数组中最后一个k的位置
    public static int getLastK(int[] a, int left, int right, int k) {
        if (a == null || left > right) return -1;
        int middle = (left + right) / 2;
        int middleData = a[middle];
        if (middleData < k) {
            left = middle + 1;
        } else if (middleData > k) {
            right = middle - 1;
        } else {
            //等于k的情况
            if ((middle < a.length - 1 && a[middle + 1] != k)||middle==a.length-1)
                return middle;
            else {
                left = middle + 1;
            }
        }
        return getLastK(a, left, right, k);
    }

    //得到排序数组中K的个数
    static int getNumberOfK(int[] a, int k) {
        if (a.length < 0) return -1;
        int first = getFirstK(a, 0, a.length - 1, k);
        int last = getLastK(a, 0, a.length - 1, k);
        int number = 0;
        if (first > -1 && last > -1) {
            number = last - first + 1;
        }
        return number;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(a, 3));
    }

}
