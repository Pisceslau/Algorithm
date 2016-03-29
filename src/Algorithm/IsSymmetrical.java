package Algorithm;

/**
 * Created by Lunar on 2016/3/29.
 * 剑指Offer第五十九题：对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的，如果一棵二叉树和它的镜像
 * 一样，那么它是对称的。
 * 思路：通过考虑二叉树的前序遍历和对称前序遍历并且考虑null结点，
 * 若二者序列相同则为对称，否则不是对称。
 */
public class IsSymmetrical {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode t1 = new BinaryTreeNode(6);
        BinaryTreeNode t2 = new BinaryTreeNode(6);
        BinaryTreeNode t3 = new BinaryTreeNode(5);
        BinaryTreeNode t4 = new BinaryTreeNode(7);
        BinaryTreeNode t5 = new BinaryTreeNode(7);
        BinaryTreeNode t6 = new BinaryTreeNode(5);
        root.setLeft(t1);
        root.setRight(t2);
        t1.setLeft(t3);
        t1.setRight(t4);
        t2.setLeft(t5);
        t2.setRight(t6);
       /* t3.setLeft(null);
        t3.setRight(null);
        t4.setLeft(null);
        t4.setRight(null);
        t5.setLeft(null);
        t5.setRight(null);
        t6.setLeft(null);
        t6.setRight(null);*/

        BinaryTreeNode root2 = new BinaryTreeNode(7);
        BinaryTreeNode node1 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        root2.setLeft(node1);
        root2.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
       /* node2.setRight(null);
        node3.setLeft(null);
        node3.setRight(null);
        node4.setLeft(null);
        node4.setRight(null);
        node5.setLeft(null);
        node5.setRight(null);*/


        // 逐层打印
        System.out.println("The root Tree is " + isSymmetrical(root));
        System.out.println("The root2 Tree is " + isSymmetrical(root2));
    }

    static boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) return true;//递归边界条件，考虑了都为null,执行此句才不会
        //一直递归
        if (root1 == null || root2 == null) return false;//上一行排除了二者都相为空的或情况

        if (root1.value != root2.value) return false;
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
