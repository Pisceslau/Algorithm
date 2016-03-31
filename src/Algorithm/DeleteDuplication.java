package Algorithm;

/**
 * Created by Lunar on 2016/3/31.
 * 剑指Offer第五十七题：删除链表的重复结点
 * 题目：在一个排序的链表中，如何删除重复的结点？
 * 思路：从头遍历结点，如何一个结点的值与下一个结点的值相同，一起删除
 * 要防止链表断开，需要前一个结点与下一个大于当前结点的相连
 */
public class DeleteDuplication {

    static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return pHead;
        ListNode root = new ListNode(-1);
        root.next = pHead;
        ListNode preNode = root;//当前结点前驱结点
        ListNode curNode = pHead;//当前结点

        boolean needDeleted = false;

        while (curNode != null && curNode.next != null) {
            ListNode nextNode = curNode.next;

            //如果不需要删除
            if (curNode.value == nextNode.value) {
                //如果需要删除的话，要while循环删除多个结点，所以要保存个值，用值判断下一个结点删除与否
                int value = curNode.value;
                //next有可能为空所以判断
                while (curNode != null && curNode.value == value) {

                    curNode = curNode.next;
                }
                //如果头结点也需要删除的话，那么无前驱结点，则会为空指针错误
                preNode.next = curNode;
            } else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return root.next;
    }

    public static void print(ListNode result) {
        while (result != null) {
            System.out.print(result.value + "->");
            result = result.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode result = deleteDuplication(n1);
        print(result);
    }
}
