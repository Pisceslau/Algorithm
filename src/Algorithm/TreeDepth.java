package Algorithm;

/**
 * Created by Lunar on 2016/3/25.
 * 剑指Offer第三十九题：二叉树的深度,判断是不是平衡二叉树？
 * 思路：（1）递归左右子树中的深度的最大值然后加1
 * （2）二叉树是不是平衡的：左右子树的深度差不超过1则是一棵平衡的二叉树。
 * （3）后序遍历的方式遍历二叉树的每一个结点在遍历到每一个结点之前，我们已经遍历了它的左右子树
 */
public class TreeDepth {
    static int treeDepth(BinaryTree root) {
        if (root == null) return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }

    //二叉树定义
    static class BinaryTree {
        int value;
        BinaryTree left, right;
    }

    public static void main(String[] args) {
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

        System.out.println(treeDepth(root));
        System.out.println(isBalanced(root));
        System.out.println(isBalanced(root));
    }

    //使用递归的方式判断
    // 一棵二叉树是不是平衡二叉树，缺点是会重复遍历许多结点
    static boolean isBalanced(BinaryTree root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int dif = left - right;
        if (dif > 1 || dif < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //每个结点只遍历一次的解法
    static boolean isBalanced(BinaryTree root, int depth) {
        depth = 0;
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;//左右子树的深度
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left - right;
            if (diff > 1 || diff < -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }
}
