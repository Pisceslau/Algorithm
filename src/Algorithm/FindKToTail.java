package Algorithm;

/**
 * Created by Lunar on 2016/3/11.
 * 剑指Offer第15题
 * 找到倒数第k个结点
 */
public class FindKToTail {
    //相关问题之：求链表的中间结点
    public static ListNode findCenterNode(ListNode pListHead) {
        if (pListHead == null) return null;
        //两个指针都在表头
        ListNode quick = pListHead, slow = pListHead;

        while (quick.next!=null){
            quick = quick.next.next;
            slow = slow.next;

        }
        return slow;

    }

    //发现倒数第k个结点方法
    public static ListNode findKToTail(ListNode pListHead, int k) {
        if (pListHead == null || k == 0)
            return null;
        ListNode pAhead = pListHead;
        ListNode pBehind;
        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null) {
                pAhead = pAhead.next;
            } else return null;
        }
        pBehind = pListHead;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
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
        three.setValue(3);
        two.setValue(2);
        four.setValue(4);
        five.setValue(5);


        ListNode node = findKToTail(one, 2);
        System.out.println(node.getValue());

        ListNode listNode = findCenterNode(one);
        System.out.print(listNode.getValue());
    }

    private static class ListNode {
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
