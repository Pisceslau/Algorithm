package Algorithm;

/**
 * Created by Lunar on 2016/3/25.
 * 剑指Offer第三十七题：两个链表的第一个公共结点
 * 思路如下：（1）蛮力法 O(mn)
 * (2)使用栈后进先出的性质，从后向前比较两个链表若结点看结点是不是相同空间复杂度O(m+n)时间复杂度O(m+n)
 * (3)比较二个链表的差值，让一个链表先走几步，到达某个结点，然后，再一起走，如果到某个地方结点相同则为公共结点
 * 时间复杂度O(m+n);
 */
public class FindFirstCommonNode {
    //链表的长度的计算方法
    static int getListNodeLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    //算法的实现
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        //得到二个链表的长度
        int length1 = getListNodeLength(head1);
        int length2 = getListNodeLength(head2);
        //计算链表长度的差值
        int lengthDif = length1 - length2;
        //保证差值为正值
        ListNode headLong = head1;
        ListNode headShort = head2;
        if (length2 > length1) {
            headLong = head2;
            headShort = head1;
            lengthDif = length2 - length1;
        }
        //先在长链表先走几步，然后再和短链表一起走，直到碰到一个公共链表结点
        for (int i = 0; i < lengthDif; i++) {
            headLong = headLong.next;
        }
        //如果二个链表都不为空并且第一个结点不等于第二个结点，则继续遍历下一个结点
        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }
        ListNode commonNode = headLong;
        return commonNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node6 = new ListNode();
        ListNode node7 = new ListNode();

        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();

        node1.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node6);
        node6.setNext(node7);

        node4.setNext(node5);
        node5.setNext(node6);

        System.out.println(findFirstCommonNode(node1, node4).getValue());
    }

    //链表的定义
    static class ListNode {
        int value;
        ListNode next;

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
