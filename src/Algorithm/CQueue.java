package Algorithm;

import java.util.Stack;

/**
 * Created by Lunar on 2016/4/9.
 * 剑指Offer第七题：用二个栈实现队列重写
 */
public class CQueue {
    //声明二个栈
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6, 9, 0, 6};
        CQueue queue = new CQueue();
        for (int i = 0; i < a.length; i++) {
            queue.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(queue.pop() + ",");
        }
        queue.push(23);
        System.out.print(queue.pop());

    }

    //插入队列
    private void push(int node) {
        stack1.push(node);
    }

    private int pop() {
        //如果当栈二为空时，把栈1中的所有元素都放入栈二中
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        //如果栈2为空则打印出来队列为空的提示
        if (stack2.size() == 0) {
            System.out.println("The CQueue is Empty!");
        }
        //正常弹出队列元素（栈）
        return stack2.pop();
    }
}

