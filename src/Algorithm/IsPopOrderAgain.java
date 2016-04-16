package Algorithm;

/**
 * Created by Lunar on 2016/4/16.
 * 剑指Offer22题：栈的压入、弹出序列复习
 */

import java.util.ArrayList;

public class IsPopOrderAgain {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length <= 0 || popA.length <= 0 || pushA.length != popA.length)
            return false;
        ArrayList<Integer> list = new ArrayList<>();//模仿栈
        int pushIndex = 0;
        int popIndex = 0;
        int length = popA.length;
        while (popIndex < length) {
            while (pushIndex < length && (list.isEmpty() || popA[popIndex] != list.get(list.size() - 1))) {
                //弹出序列元素不在栈中
                list.add(pushA[pushIndex]);
                pushIndex++;
            }
            if (popA[popIndex] == list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
                popIndex++;
            } else {
                return false;
            }
        }
        return list.isEmpty();
    }
}