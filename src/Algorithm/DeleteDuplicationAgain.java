package Algorithm;

/**
 * Created by Lunar on 2016/5/5.
 * 剑指Offer复习57题：删除链表中的重复结点
 */
public class DeleteDuplicationAgain {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;

        ListNode preNode = null;
        ListNode node = pHead;
        while (node != null) {
            ListNode nextNode = node.next;
            boolean needDelete = false;
            if (nextNode != null && nextNode.value == node.value) {
                needDelete = true;
            }
            if (!needDelete) {
                preNode = node;
                node = node.next;
            } else {
                int value = node.value;
                ListNode toBeDel = node;
                while (toBeDel != null && toBeDel.value == value) {
                    nextNode = toBeDel.next;
                    toBeDel = nextNode;
                    if (preNode == null)
                        pHead = nextNode;
                    else
                        preNode.next = nextNode;
                    node = nextNode;
                }
            }
        }

        return pHead;
    }

}
