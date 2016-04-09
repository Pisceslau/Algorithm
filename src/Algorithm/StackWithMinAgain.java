package Algorithm;

import java.util.Stack;

/**
 * Created by Lunar on 2016/4/9.
 * 剑指Offer第21题：包含min函数的栈重写
 */
public class StackWithMinAgain {
    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int value) {
        stackData.push(value);//数据栈直接压入元素
        //最小栈要判断加入的元素是不是相对最小的才行
        if (stackMin.size() == 0 || value < stackMin.peek()) {
            stackMin.push(value);
        } else {
            //否则就加入此刻栈顶的元素
            stackMin.push(stackMin.peek());
        }
    }

    //弹出元素
    public int pop() {
        //数据栈正常弹出
        assert (stackMin.size() > 0 && stackData.size() > 0);
        stackMin.pop();
        return stackData.pop();
    }

    //最小元素
    public int min() {
        assert (stackData.size() > 0 && stackMin.size() > 0);
        return stackMin.peek();
    }

    public int top() {
        assert (stackMin.size() > 0 && stackData.size() > 0);
        return stackData.peek();
    }

    public static void main(String[] args) {
        StackWithMinAgain stackWithMin = new StackWithMinAgain();
        stackWithMin.push(3);
        stackWithMin.push(4);
        stackWithMin.push(2);
        System.out.println(stackWithMin.min());
        stackWithMin.push(1);
        System.out.println(stackWithMin.min());

    }
}
