package Algorithm;

import java.util.Stack;

/**
 * Created by Lunar on 2016/3/17.
 * 剑指Offer第二十二题：栈的压入。弹出序列
 */
class IsPopOrder {
    public static boolean isPopOrder(int[] arrayPush, int[] arrayPop) {
        //输入校验
        if (arrayPush == null || arrayPop == null || arrayPop.length == 0 || arrayPush.length == 0 || arrayPush.length != arrayPop.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        //若下一个弹出的数字不在栈顶，则把入栈队列的数加,,入栈中入栈元素还未全部入栈的条件下，
        while (popIndex < arrayPop.length) {
            //,入栈中入栈元素还未全部入栈的条件下，或者栈顶的元素与出序列元素不一样，后者栈为空，则需要进行入栈操作
            while (pushIndex < arrayPush.length && (stack.isEmpty() || stack.peek() !=arrayPop[popIndex])) {
                // 入栈数组中的元素入栈
                stack.push(arrayPop[pushIndex]);
                // 指向下一个要处理的入栈元素
                pushIndex++;
            }
            if (arrayPop[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;//移到下一个元素
            } else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));
    }
}