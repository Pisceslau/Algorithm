package Algorithm;

import java.util.ArrayList;

/**
 * Created by Lunar on 2016/4/1.
 * 剑指Offer第六十三题：二叉搜索树的第k个结点
 * 题目：给定一棵二叉搜索树，请找出其中的第k大的结点
 */
public class KthNode {
    //中序遍历
    public static ArrayList<Integer> center(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root != null) {
            if (root.left != null) center(root.left);
            System.out.println(root.val);
            list.add(root.val);
            if (root.right != null) center(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.print(kthNode(n1, 3).val);
        System.out.print(center(n1));

    }

    static TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;

        return kthNodeCore(pRoot, k);
    }

    static TreeNode kthNodeCore(TreeNode root, int k) {
        //遍历左子树


        TreeNode target = null;//目标结点
        if (root.left != null) {
            target = kthNodeCore(root.left, k);
        }
        //遍历根结点
        if (target == null) {
            if (k == 1) {
                target = root;
            }
            k--;
        }
        //右子树
        if (root.right != null) {
            target = kthNodeCore(root.right, k);
        }
        return target;
    }
}
