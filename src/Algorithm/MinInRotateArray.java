package Algorithm;

/**
 * Created by Lunar on 2016/5/7.
 * 剑指Offer复习之：旋转数组的最小数字
 * 思路：二分查找
 * 通过牛客网AC
 */
public class MinInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0) return 0;

        int index1 = 0;
        int length = array.length;
        int index2 = length - 1;
        int indexMid = index1;//之所以赋值初始为index1；因为移动前0个元素也是符合题目定义的，这时候整个数组就是一个递增的数组
        //所以下面这个while循环就不会执行，直接就返回这个0下标（index1)元素即可。
        //Normal情况：分为两个递增的子数组，第一个子数组的元素都大于第二个子数组的元素。
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            //如果中间元素index1 index2的指向元素都是相等的则顺序遍历找最小的值
            if (array[index1] == array[index2] && array[index2] == array[indexMid])
                return minInOrder(array, index1, index2);
            //说明中间元素大于第一个索引则index2 = indexMid;
            if (array[indexMid] >= array[index1])
                index1 = indexMid;

            else if (array[index2] >= array[indexMid])
                index2 = indexMid;
        }
        return array[indexMid];
    }

    private int minInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1; i < index2; i++) {
            if (result > array[i])
                result = array[i];
        }
        return result;
    }

}
