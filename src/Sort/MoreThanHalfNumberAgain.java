package Sort;

/**
 * Created by Lunar on 2016/4/9.
 * 剑指Offer第二十九题：数组中出现次数超过一半的数字：阵地攻守思想
 */
public class MoreThanHalfNumberAgain {
    //阵地攻守思想
    public int moreThanHalfNumber(int[] array) {
        if (array == null || array.length <= 0) return 0;

        //取数组第一个元素为士兵
        int result = array[0];
        int count = 0;//频率

        for (int i = 1; i < array.length; i++) {
            //如果count为0；则取新的i,频率为1
            if (count == 0) {
                result = array[i];
                count = 1;
            } else if (result == array[i]) {
                //同元素则加
                count++;
            } else {
                //不同元素则相减少
                count--;
            }
        }
        //检验result大于在数组中的一半与否
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        if (times * 2 < array.length) {
            return result = 0;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] b = {1};
        System.out.println(new MoreThanHalfNumberAgain().moreThanHalfNumber(a));
        System.out.println(new MoreThanHalfNumberAgain().moreThanHalfNumber(b));
    }
}
