package Algorithm;

/**
 * Created by Lunar on 2016/3/29.
 * 剑指Offer第五十一题：数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内，数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次，请找出数组中任意一个重复的数字，例如，如果输入长度为7的数组{2,3,1,0,2,5,3}那么对于输出是重复的数字2
 * 或者3。
 * 思路：O(1)：因为这些数字都在0-n-1范围内，所以如果没有重复数字的话，那么位置i的数字就是i，若有重复数字
 * 首先判断i位置的数字（设为m）是不是为i，若m==i则判断下一个位置的数字，
 * 如果m!=i则m和下标为m的数字相比，如果m==下标为m的数字，则为重复数字，否则就把m和m位置的数交换，把m放到正确的位置上。
 */
public class Duplicate {
    static boolean duplicate(int[] a) {
        if (a == null) return false;
        //检查数组中的这些数是不是在0到n-1的范围内。
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 || a[i] > a.length - 1) return false;
        }
        for (int i = 0; i < a.length; i++) {
            //while 循环是m!=i的情况，如果等于就执行for循环i++
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    System.out.println("The duplication is " + a[i]);
                    return true;
                }
                //否则交换
                swap(a, i, a[i]);
            }
        }
        //每个数字都和本位置下标相等，说明没有重复的数字。
        return false;
    }

    //数组中交换二个数字
    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(a));
    }
}
