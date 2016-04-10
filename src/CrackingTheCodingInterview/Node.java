package CrackingTheCodingInterview;

/**
 * Created by Lunar on 2016/4/10.
 * 程序员面试金典中8.2简单实现链表 和删除链表
 */
public class Node {
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }

    //添加到尾部
    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        //表头就是要删的
        Node n = head;
        if (n.value == d) {
            return head.next;
        }
        //要删的不是表头
        while (n.next != null) {
            if (n.next.value == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
