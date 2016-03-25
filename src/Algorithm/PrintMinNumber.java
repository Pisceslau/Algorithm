package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Lunar on 2016/3/25.
 * 剑指Offer第三十三题：把数组排成最小的数
 */
public class PrintMinNumber {
    void printMinNumber(int[] numbers) {
        int length = numbers.length;
        if (numbers == null || length < 0) {
            return;
        }
        //把数组变为字符串数组
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = numbers[i] + "";
        }
        //根据比较规则进行排序，使用系统的排序方法。
        Comparator<String> comparator = new MyComparator<>();
        Arrays.sort(strs, comparator);
        for (int i = 0; i < length; i++) {
            System.out.print(strs[i]);
        }
    }

    //定义比较器使用Java Comparator,还有泛型,比较规则如下
    class MyComparator<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            String combination1 = (String) o1 + (String) o2;
            String combination2 = (String) o2 + (String) o1;
            return combination1.compareTo(combination2);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 32, 321};
        PrintMinNumber min = new PrintMinNumber();
        min.printMinNumber(a);
    }
}
