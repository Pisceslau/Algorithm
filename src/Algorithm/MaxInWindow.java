package Algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Lunar on 2016/5/8.
 * 剑指Offer第65题：滑动窗口的最大值
 * 用一个双端队列，队列第一个位置保存当前窗口的最大值（下标），当窗口滑动一次
 * 1.判断当前最大值是否过期
 * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 */
public class MaxInWindow {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();//保存最终的结果
        if (size == 0) return result;
        //双端队列 保存可能最大值的下标
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int begin = 0;//滑动窗口首元素的下标

        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;//如果队列为空，向里面添加元素（下标）i
            if (queue.isEmpty()) {
                queue.add(i);
            }
            //peekFirst()获取不移除，pollFirst获取并移除
            else if (begin > queue.peekFirst()) {
                queue.pollFirst();
            }
            //输入的元素的值大于队列尾部的值，则一直删除队列尾部的
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if (begin >= 0) {
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> list = new MaxInWindow().maxInWindows(num, 3);
        System.out.println(list);
    }
}
