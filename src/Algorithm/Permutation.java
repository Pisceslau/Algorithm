package Algorithm;

import java.util.Arrays;

/**
 * Created by Lunar on 2016/3/20.
 * 剑指Offer第二十八题：字符串的全排列
 */
public class Permutation {
    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void permutation(char[] str) {
        if (str==null)return;
        permutation(str,0);
    }

    private static void permutation(char[] str, int begin) {
        if (begin == str.length) {
            System.out.println(Arrays.toString(str));
        } else {
            for (int i = begin;i<str.length;i++) {
                swap(str, begin, i);
                permutation(str, begin + 1);
                swap(str, begin, i);
            }
        }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd'};
        permutation(a);
    }
}
