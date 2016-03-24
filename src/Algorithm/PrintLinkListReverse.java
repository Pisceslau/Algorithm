package Algorithm;

import java.util.Stack;

/**
 * Created by Lunar on 2016/3/6.
 * 剑指Offer第五题从尾到头打印链表
 */
public class PrintLinkListReverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);


        head.setNext(one);
        one.setNext(two);
        two.setNext(three);
        three.setNext(null);
        reverseByRecusive(head);

        System.out.println();
        reverseByStack(head);

    }

    //栈的实现
    public static void reverseByStack(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while (p != null) {
            stack.push(p.getValue());
            p = p.getNext();
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ",");
        }
    }

    //递归的实现方法
    public static void reverseByRecusive(ListNode head) {
        if (head != null) {
            if(head.getNext() != null) {
                reverseByRecusive(head.getNext());
            }
            System.out.print(head.getValue());
        }
    }

    //链表类
    public static class ListNode {
        private int value;//值
        private ListNode next;//指针指向下一个结点

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }


    }

}
