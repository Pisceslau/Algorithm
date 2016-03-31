package Algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lunar on 2016/3/31.
 * 剑指Offer第六十题：把二叉树打印成多行。
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到
 * 一行。
 * 思路：一个变量表示在当前层中还没有打印的结点数，另一个变量表示下一层结点的数目
 */
public class Print {
    static void print(BinaryTreeNode root) {
        if (root == null) return;
        //使用LinkedList实现队列，因为这个插入删除快。
        List<BinaryTreeNode> nodes = new LinkedList<>();
        //首先把根结点放入队列中
        nodes.add(root);
        //初始化，下一行的数目和还没有打印的数目
        int nextLevel = 0;
        int toBePrinted = 1;

        while (!nodes.isEmpty()) {
            //首先不出队列仅仅是打印它的值
            BinaryTreeNode node = nodes.get(0);
            System.out.print(node.getValue() + " ");
            //如果儿子结点不为空，则把他们加入队列并且下一行的数目增加
            if (node.left != null) {
                nodes.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                nodes.add(node.right);
                nextLevel++;
            }
            //把自己出列，会导致要打印的数目减少一
            nodes.remove(0);
            toBePrinted--;
            //如果本行变为零0.说明要进行下一行的打印了，下一行的数目自然是要打印的数目了（toBePrinted == nextLevel; ）
            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(10);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(9);
        BinaryTreeNode n7 = new BinaryTreeNode(11);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        print(n1);
    }

}
