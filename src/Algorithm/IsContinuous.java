package Algorithm;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/28.
 * 剑指Offer第四十四题：扑克牌的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的，2~10为数字本身
 * ，A为1，J为11，Q为1前12，K为13，而大小王可以看做是任意数字
 * 思路：首先排序，不是连续的话，看数之间相隔的若干个数字，但只要我们有足够的0就可以补满这二个数字的空缺，这个
 * 数组实际上还是有序的，因为大小王可以当做是任意的数字，默认值为0
 * 注意：非0的数字重复则为不是顺子
 */
public class IsContinuous {
    /**
     * 求是否连续的方法
     *
     * @param a 输入数组
     * @return 是否连续
     */
    public static boolean isContinuous(int[] a) {
        if (a == null || a.length < 0) return false;
        Arrays.sort(a);//首先使用快速排序排序数组，使之成为可能有0在左侧的按顺序排序的数组
        //统计排序后的数组的0的个数
        int numberOfZero = 0;//0的个数
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) numberOfZero++;
        }
        //统计间隔的数目
        int numberOfGap = 0;
        int left = numberOfZero;//左边数下标
        int right = left + 1;//右边数的下标

        while (right < a.length) {
            //如果相等则不是顺子
            if (a[left] == a[right]) return false;
            numberOfGap += a[right] - a[left] - 1;
            //左右数右移动
            left = right;
            right++;
        }
        return numberOfGap <= numberOfZero;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 3, 4, 5};
        System.out.println(isContinuous(a));
    }
}
