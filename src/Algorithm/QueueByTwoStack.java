package Algorithm;

import java.util.Stack;

/**
 * Created by Lunar on 2016/3/7.
 * 剑指Offer第七题：用二个栈实现队列
 */
public class QueueByTwoStack<T> {
    //声明二个栈
    public Stack<T> stack1 = new Stack<>();
    public Stack<T> stack2 = new Stack<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6, 9, 0, 6};
        QueueByTwoStack<Integer> queue = new QueueByTwoStack<>();
        for (int i=0;i<a.length;i++) {
            queue.appendTail(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(queue.deleteHead() + ",");
        }
        queue.appendTail(23);
        System.out.print(queue.deleteHead());

    }

    //实现方法appendTail,添加数据到队列的尾部
    public void appendTail(T element) {

        stack1.push(element);
    }

    //实现方法deleteHead()，删除队列中的一个数据
    public T deleteHead() {
        //stack1的元素不为空则把a中的元素放到b中
        if (stack1.size() == 0) {
            if (stack2.size() == 0) {
                try {
                    throw new Exception("队列为空！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //栈2为空则把所有的栈1元素放入栈2中
        if(stack2.size() <= 0) {
            while (stack1.size()>0) {
                T element = stack1.pop();
                stack2.push(element);
            }
        }

        return stack2.pop();

    }

}
