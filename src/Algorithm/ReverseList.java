package Algorithm;

/**
 * Created by Lunar on 2016/3/12.
 * 剑指Offer第十六题：反转链表
 * 注意如果直接把某个结点的指针反向的话，那么下一个结点如何遍历呢？
 * 所以先用本结点next值取得下一个结点的位置，然后进行反向，然后再找到下一个结点继续
 */
public class ReverseList {
    static ListNode reverseList(ListNode pHead) {
        ListNode pReversedHead = null;
        ListNode pNode = pHead;
        ListNode pPre = null;

        while (pNode != null) {
            ListNode pNext = pNode.next;//寄存下一个结点位置
            //然后反转链表
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPre;
            //移动到下一个点
            pPre = pNode;
            pNode = pNext;

        }
        return pReversedHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        ListNode b = new ListNode();
        ListNode c = new ListNode();
        ListNode d = new ListNode();

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(null);

        a.setValue(1);
        b.setValue(2);
        c.setValue(3);
        d.setValue(4);

        ListNode node = reverseList(a);
        System.out.println(node.getValue()+" "+node.getNext().getValue());
    }

    //链表结构
    static class ListNode {
        private int value;
        private ListNode next;

        private ListNode head;//头结点

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
