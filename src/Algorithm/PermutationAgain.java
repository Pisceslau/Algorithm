package Algorithm;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Lunar on 2016/5/7.
 * 剑指Offer复习之：28题：字符串的排列
 */
public class PermutationAgain {

    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> permutation(String str) {

        char[] chars = str.toCharArray();
        permutation(chars, 0);
        Collections.sort(list);
        return list;
    }

    private void permutation(char[] str, int begin) {
        if (begin == str.length - 1) {
            String s = new String(str);
            if (!list.contains(s))
                list.add(s);

        } else {
            for (int i = begin; i < str.length; i++) {
                swap(str, begin, i);

                permutation(str, begin + 1);

                swap(str, begin, i);
            }
        }
    }

    //交换二个数
    private void swap(char[] str, int i, int j) {

        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;

    }
}
