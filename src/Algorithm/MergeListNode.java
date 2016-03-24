package Algorithm;

/**
 * Created by Lunar on 2016/3/12.
 * 剑指Offer第十七题
 * 合并两个递增的链表
 */
public class MergeListNode {
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

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1==null)return head2;
        else if (head2==null)return head1;

        ListNode pMergeHead;

        if (head1.value < head2.value) {
            pMergeHead = head1;
            pMergeHead.next = merge(head1.next, head2);
        } else {
            pMergeHead = head2;
            pMergeHead.next = merge(head1, head2.next);

        }
        return pMergeHead;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode();
        ListNode two = new ListNode();
        ListNode three = new ListNode();
        ListNode four = new ListNode();
        ListNode five = new ListNode();

        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(null);

        one.setValue(1);
        two.setValue(3);
        three.setValue(5);
        four.setValue(7);
        five.setValue(9);

        ListNode a = new ListNode();
        ListNode b = new ListNode();
        ListNode c = new ListNode();
        ListNode d = new ListNode();
        ListNode e = new ListNode();

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(null);

        a.setValue(2);
        b.setValue(4);
        c.setValue(6);
        d.setValue(8);
        e.setValue(10);

        ListNode node = merge(one,a);

        while (node!= null) {
            System.out.print(node.getValue());
            node = node.next;
        }
    }
}
