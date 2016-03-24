package Algorithm;

/**
 * Created by Lunar on 2016/3/19.
 * 剑指Offer第二十六题：复制复杂链表
 */
public class CloneNodes {
    //汇总
    public static ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        connectNodes(head);
        return reconnectNodes(head);
    }

    //第一步： //复制每一个结点并把N'放到N的后面
    public static void cloneNodes(ComplexListNode head) {
        if (head == null) {
            return;
        }
        ComplexListNode node = head;
        while (node != null) {
            //复制每一个结点并把N'放到N的后面
            ComplexListNode clone = new ComplexListNode();
            clone.value = node.value;
            clone.next = node.next;
            clone.sibling = node.sibling;

            node.next = clone;
            node = clone.next;
        }
    }

    //第二步： 连接结点，如果N的sibling的结点为S，则N‘对应的sibling结点为N对应的sibling结点（S)的下一个结点
    public static void connectNodes(ComplexListNode head) {
        ComplexListNode node = head;//指向头结点的指针

        while (node != null) {
            ComplexListNode cloned = node.next;//指向复制顶点的指针
            if (node.sibling != null) {
                cloned.sibling = node.sibling.next;
                node = cloned.next;//到下一个顶点继续循环
            }
        }
    }

    //第三步：把长链表分为二个链表，奇数部分的结点是原始的链表，偶数的是复制的链表
    static ComplexListNode reconnectNodes(ComplexListNode head) {
        //指针初始化
        ComplexListNode node = head;//指向头结点的指针，可以移动用作每个结点
        ComplexListNode cloneHead = null;//指向复制顶点的头结点的指针，指代这个链表
        ComplexListNode cloneNode = null;//指代这个链表上的某一个结点
        if (node != null) {
            //把cloneNode初始化为指向复制链表的头结点，cloneHead也一样
            cloneNode = cloneHead = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        //复制链表的next结点还没有动呢，刚刚只是增加了一些链条，此时要去掉
        // 多余的链条,依次去掉多余的链条
        while (node != null) {
            cloneNode.next = node.next;

            cloneNode = cloneNode.next;
            node = node.next;
        }
        //返回复制链表
        return cloneHead;
    }

    public static boolean isSame(ComplexListNode h1, ComplexListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }
        return h1 == null && h2 == null;
    }

    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;

        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next.next;
        head.next.next.next.sibling = head.next;

        ComplexListNode tmp = head;
        printList(head);
        ComplexListNode newHead = clone(head);
        printList(head);
        System.out.println(isSame(head, tmp));
        printList(newHead);
        System.out.println(isSame(head, newHead));


        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        ComplexListNode head2 = new ComplexListNode();
        head2.value = 1;
        head2.next = new ComplexListNode();
        head2.next.value = 2;
        head2.next.next = new ComplexListNode();
        head2.next.next.value = 3;
        head2.next.next.next = new ComplexListNode();
        head2.next.next.next.value = 4;
        head2.next.next.next.next = new ComplexListNode();
        head2.next.next.next.next.value = 5;

        head2.next.sibling = head2.next.next.next.next;
        head2.next.next.next.sibling = head2.next.sibling;
        head2.next.next.sibling = head2.next.next;

        System.out.println("\n");
        tmp = head2;
        printList(head2);
        ComplexListNode newHead2 = clone(head2);
        printList(head2);
        System.out.println(isSame(head2, tmp));
        printList(newHead2);
        System.out.println(isSame(head2, newHead2));


        ComplexListNode head3 = new ComplexListNode();
        head3.value = 1;

        System.out.println("\n");
        tmp = head3;
        printList(head3);
        ComplexListNode newHead3 = clone(head3);
        printList(head3);
        System.out.println(isSame(head3, tmp));
        printList(newHead3);
        System.out.println(isSame(head3, newHead3));

        System.out.println("\n");
        ComplexListNode head4 = clone(null);
        printList(head4);
    }

    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }
}


