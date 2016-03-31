package Algorithm;

/**
 * Created by Lunar on 2016/3/31.
 * 链表类
 */
public class ListNode {
    public int value;//值
    public ListNode next;//指针指向下一个结点

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