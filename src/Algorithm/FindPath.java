package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lunar on 2016/3/18.
 * 剑指Offer第25题：二叉树中和为某一个值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中结点的值的和为输入整数的所有路径，从树的根结点
 * 开始往下一直到叶结点所经过的结点形成一条路径
 * 快捷键：查找与替换Ctrl + R
 */
public class FindPath {
    public static void findPath(BinaryTree root, int expectedSum) {
        if (root == null) {
            return;
        }
        //创建一个链表用于存储所有路径上的结点
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            findPath(root, 0, expectedSum, list);
        }
    }

    private static void findPath(BinaryTree root, int curSum, int expectedSum, List<Integer> result) {
        if (root != null) {
            //如果结点不是空则进行处理
            //加上当前结点的值
            curSum += root.value;
            //将当前结点入队
            result.add(root.value);
            //如果当前的结点的和小于期望的和
            if (curSum < expectedSum) {
                //递归处理左子树
                findPath(root.left, curSum, expectedSum, result);
                //递归处理右子树
                findPath(root.right, curSum, expectedSum, result);
            } else if (curSum == expectedSum) {
                //如果当前和和期望和相等，而且
                //当前结点为叶子结点
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }
            }
            //在返回到父结点之前删除当前结点（递归回）
            result.remove(result.size() - 1);
        }

    }

    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        BinaryTree root = new BinaryTree();
        root.value = 10;
        root.left = new BinaryTree();
        root.left.value = 5;
        root.left.left = new BinaryTree();
        root.left.left.value = 4;
        root.left.right = new BinaryTree();
        root.left.right.value = 7;
        root.right = new BinaryTree();
        root.right.value = 12;

        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);

        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);

        // 有一条路径上的结点和为19
        System.out.println("findPath(root, 19);");
        findPath(root, 19);


        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        BinaryTree root2 = new BinaryTree();
        root2.value = 5;
        root2.left = new BinaryTree();
        root2.left.value = 4;
        root2.left.left = new BinaryTree();
        root2.left.left.value = 3;
        root2.left.left.left = new BinaryTree();
        root2.left.left.left.value = 2;
        root2.left.left.left.left = new BinaryTree();
        root2.left.left.left.left.value = 1;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        BinaryTree root3 = new BinaryTree();
        root3.value = 1;
        root3.right = new BinaryTree();
        root3.right.value = 2;
        root3.right.right = new BinaryTree();
        root3.right.right.value = 3;
        root3.right.right.right = new BinaryTree();
        root3.right.right.right.value = 4;
        root3.right.right.right.right = new BinaryTree();
        root3.right.right.right.right.value = 5;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);

        // 树中只有1个结点
        BinaryTree root4 = new BinaryTree();

        root4.value = 1;
        // 有一条路径上面的结点和为1
        System.out.println("findPath(root4, 1);");
        findPath(root4, 1);

        // 没有路径上面的结点和为2
        System.out.println("findPath(root4, 2);");
        findPath(root4, 2);

        // 树中没有结点
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
    }

    //二叉树数据结构
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    }
}

