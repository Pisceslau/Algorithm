package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lunar on 2016/4/1.
 * 剑指Offer第六十五题：滑动窗口的最大值
 */
public class StreamMedian {
    List<Integer> list = new ArrayList<>();//插入排序思想

    public static void main(String[] args) {
        StreamMedian s = new StreamMedian();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (Integer i : a) {
            s.insert(i);
            System.out.println(s.getMedian());
        }
    }

    public void insert(Integer num) {
        int i = 0;
        while (i < list.size()) {
            if (num <= list.get(i)) break;
            i++;
        }
        list.add(i, num);
    }

    public Double getMedian() {
        int size = list.size();
        //数与1相与&结果为1相当于奇数，反之偶数相当于求余运算
        if ((size & 1) == 0) {
            //偶数
            return (double) ((list.get(size / 2) + list.get(size / 2 - 1)) / 2.0);
        } else
            return (double) list.get(size / 2) * 1.0;
    }
}
