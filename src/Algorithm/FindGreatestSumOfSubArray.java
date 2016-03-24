package Algorithm;

/**
 * Created by Lunar on 2016/3/21.
 * 剑指Offer第三十一题：连续子数组的最大和
 * 输入的整型数组存在正负数，数组中一个非或多个整数组成一个子数组，求所有子数组的和的最大值，要求时间复杂度为O(n)
 * 长度为n的子数组总共有n(n+1)/2个子数组
 */
public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfArray(int[] array) {
        if (array == null || array.length <= 0) return 0;
        //此时的数组和
        int currentSum = 0;
        //此时的历史最大子数组和
        int greatestSum = 0;
        for (int i = 0; i < array.length; i++) {
            //如果数组和小于此时的一个数组元素，
            // 则之前的值肯定不是最大子数组和，作废，
            //并用此时的元素作为和
            if (currentSum <= 0) {

                currentSum = array[i];
            } else {
                currentSum += array[i];
            }
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.printf("The greatest sum of subArray is %s .", findGreatestSumOfArray(a));
    }

}
