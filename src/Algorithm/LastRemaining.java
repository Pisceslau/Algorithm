package Algorithm;

import java.util.LinkedList;

/**
 * Created by Lunar on 2016/3/28.
 * 剑指Offer第四十五题：圆圈中最后剩下的数字
 * 题目：0,1，。。。，n-1这n个数字排成一个圆圈，从数字0开始每次从这圆圈里删除第m个数字，求出这个圆圈里剩下的最后一个数字。
 * 约瑟夫环问题
 */
public class LastRemaining {
    /**
     * 数学解法得到递推公式，然后循环方法实现
     *
     * @param n 数的个数
     * @param m 删去的数字
     * @return 最终剩下的数字
     */
    static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    /**
     * 使用LinkList模拟循环链表
     *
     * @param n 数的个数
     * @param m 删去的数字
     * @return 最终剩下的数字
     */
    static int lastRemainingByList(int n, int m) {
        if (n < 1 || m < 1) return -1;
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
        int index = 0;//要删除结点的位置索引
        while (numbers.size() > 1) {
            //走m-1步到达要删除结点的位置。
            index = (index + m - 1) % numbers.size();//使用求余运算模拟循环到下一个删除的位置
            numbers.remove(index);
        }
        return numbers.getFirst();
    }

    public static void main(String[] args) {
        //数学方法测试
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(6, 6)); // 最后余下3
        System.out.println(lastRemaining(5, 2)); // 最后余下2
        System.out.println(lastRemaining(6, 7)); // 最后余下4
        System.out.println(lastRemaining(0, 0)); // 最后余下-1
        //方法二模拟循环链表测试
        System.out.println();
        System.out.println(lastRemainingByList(5, 3));
        System.out.println(lastRemainingByList(6, 6)); // 最后余下3
        System.out.println(lastRemaining(5, 2)); // 最后余下2
        System.out.println(lastRemaining(6, 7)); // 最后余下4
        System.out.println(lastRemaining(0, 0)); // 最后余下-1
    }
}
