package Algorithm;

/**
 * Created by Lunar on 2016/4/1.
 * 剑指Offer第五十六题：链表中环的入口结点
 * 题目：一个链表中有环，如何找出环的入口结点？
 * 思路：先找到一快一慢二个指针的相遇的结点，这个结点在环中，从这个相遇结点接着走，
 * 每走一步增加1，回到自己得到环中结点数
 * 根据环中结点数，第一个指针先走结点数步，第二个指针然后和第一个指针一起走，然后相遇的结点
 * 就是这个环的入口结点
 */
public class EntryInListLoop {
    static ListNode meetingNode(ListNode head) {
        //
        if (head == null) return null;
        //慢指针，快指针
        ListNode slow = head.next;
        if (slow == null) return null;
        ListNode fast = slow.next;

        while (slow != null && fast != null) {
            if (slow == fast) return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    //得到环的入口结点
    static ListNode entryNodeOfLoop(ListNode head) {

        ListNode meetingNode = meetingNode(head);//得到相遇结点
        if (meetingNode == null) return null;
        int nodesOfLoop = 1;
        ListNode node1 = meetingNode;
        while (node1.next != meetingNode) {
            node1 = node1.next;
            nodesOfLoop++;
        }
        node1 = head;//结点一从头开始，先走nodesOfLoop步
        for (int i = 0; i < nodesOfLoop; i++) {
            node1 = node1.next;
        }
        //结点二和结点一一起走
        ListNode node2 = head;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(six);
        six.setNext(three);

        System.out.print(entryNodeOfLoop(one).value);
    }
}
