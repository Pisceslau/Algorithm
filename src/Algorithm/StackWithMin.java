package Algorithm;

import java.util.Stack;

/**
 * Created by Lunar on 2016/3/17.
 * 剑指Offer第二十一题：包含min函数的栈
 */
public class StackWithMin {
    public Stack<Integer> stack;
    public Stack<Integer> stackHelp;//辅助栈和栈的定义

    public StackWithMin() {
        this.stack = new Stack<>();
        this.stackHelp = new Stack<>();
    }

    public void push(int t) {
        stack.push(t);
        if (stackHelp.size() <= 0 || t < stackHelp.peek()) {
            stackHelp.push(t);
        } else {
            stackHelp.push(stackHelp.peek());
        }
    }

    //出栈要求stack stackHelp 不为空
    public int pop() {
        assert (stackHelp.size() > 0 && stack.size() > 0);
        stackHelp.pop();
        return stack.pop();
    }
    //最小值
    public int min() {
        assert (stackHelp.size() > 0 && stack.size() > 0);
        return stackHelp.peek();
    }


    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(3);
        stackWithMin.push(4);
        stackWithMin.push(2);
        System.out.println(stackWithMin.min());
        stackWithMin.push(1);
        System.out.println(stackWithMin.min());

    }
}
