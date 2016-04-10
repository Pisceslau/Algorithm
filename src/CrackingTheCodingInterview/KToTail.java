package CrackingTheCodingInterview;

import Algorithm.ListNode;

/**
 * Created by Lunar on 2016/4/10.
 * 程序员面试金典2.2 链表中倒数第k个结点
 * 思路：快慢指针
 * 顺便复习了剑指Offer的同一题
 */
public class KToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode quick = head;

        for (int i = 0; i < k - 1; i++) {
            if (quick.next != null) {
                quick = quick.next;
            } else {
                return null;
            }
        }

        ListNode slow = head;
        while ((quick.next != null) && (slow.next != null)) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;

    }
}
