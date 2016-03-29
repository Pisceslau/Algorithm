package Algorithm;

/**
 * Created by Lunar on 2016/3/29.
 * 剑指Offer第五十八题：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？树中的结点除了有二个分别指向
 * 左右子结点的指针外，还有一个指向父结点的指针。
 */
public class GetNext {
    static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) return null;
        //如果一个结点的右子树存在，则该结点的右子树的最左结点是其的下一个结点
        BinaryTreeNode next = null;
        if (node.right != null) {
            BinaryTreeNode nodeRight = node.right;
            while (nodeRight.left != null) {
                nodeRight = nodeRight.left;
            }
            next = nodeRight;
        } else if (node.parent != null) {
            BinaryTreeNode current = node;
            BinaryTreeNode nodeParent = node.parent;
            //当结点父结点存在并且当前结点是父结点的右子结点。向上遍历到某个父结点是作为另外一个父结点的左子点时候
            while (nodeParent != null && current == nodeParent.right) {
                current = nodeParent;
                nodeParent = nodeParent.parent;
            }
            next = nodeParent;
        }
        return next;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode t1 = new BinaryTreeNode(6);
        BinaryTreeNode t2 = new BinaryTreeNode(10);
        BinaryTreeNode t3 = new BinaryTreeNode(5);
        BinaryTreeNode t4 = new BinaryTreeNode(7);
        BinaryTreeNode t5 = new BinaryTreeNode(9);
        BinaryTreeNode t6 = new BinaryTreeNode(11);
        root.setLeft(t1);
        root.setRight(t2);
        t1.setLeft(t3);
        t1.setRight(t4);
        t2.setLeft(t5);
        t2.setRight(t6);
        //设置父结点指针
        t3.setParent(t1);
        t4.setParent(t1);

        t5.setParent(t2);
        t6.setParent(t2);

        t1.setParent(root);
        t2.setParent(root);
        //使用getValue,输出结点存储的值
        System.out.println(getNext(root).getValue());
        System.out.println(getNext(t4).getValue());
    }
}
