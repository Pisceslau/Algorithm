package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lunar on 2016/5/7.
 * 剑指Offer复习，面试题33：把数组排成最小的数。
 */
public class SortArrayForMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 0) return "";
        int length = numbers.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(numbers[i]);
            CompareComparator<Integer> comparator = new CompareComparator<>();
            Collections.sort(list, comparator);
        }
        StringBuilder builder = new StringBuilder();
        //Java 8 forEach 对list每个元素使用builder的append方法。list.forEach(builder::append);
        for (int i : list) {
            builder.append(i);
        }

        return builder.toString();
    }


    //定义比较规则
    public class CompareComparator<Integer> implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        }
    }
}
