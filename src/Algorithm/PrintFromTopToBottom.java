package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lunar on 2016/3/17.
 * 剑指Offer第二十三题：从上到下打印二叉树
 * 也就是广度优先，层次遍历
 * 用到了队列
 * 每次我们在打印一个结点的时候如果该结点具有子结点则把该结点的子节点放到一个队列的末尾，接下来到队列的
 * 头部，取出最早进入队列的结点，重复前面的打印操作
 */
public class PrintFromTopToBottom {
    //二叉树结点定义
    BinaryTreeNode node;
    //队列结构用于存储
    Queue<BinaryTreeNode> queue;

    //层次遍历
    public static void printFromTopToBottom(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        //队列结构用于存储

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            //队列非空去掉队列的头
            BinaryTreeNode head = queue.poll();//head每次都不一样呢
            System.out.print(head.value + ",");
            if (head.left != null) queue.add(head.left);
            if (head.right != null) queue.add(head.right);
        }
    }

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }
    public static void main(String args[]) {
        // 构建二叉树
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
        t3.setLeft(null);
        t3.setRight(null);
        t4.setLeft(null);
        t4.setRight(null);
        t5.setLeft(null);
        t5.setRight(null);
        t6.setLeft(null);
        t6.setRight(null);

        // 层次遍历
        System.out.print("层次遍历序列：");
        printFromTopToBottom(root);

    }
}
