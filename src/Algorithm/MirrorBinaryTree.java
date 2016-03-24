package Algorithm;

/**
 * Created by Lunar on 2016/3/13.
 * 剑指Offer第19题 镜像二叉树：把一个二叉树镜像：
 * 思路：从根结点遍历，若有左子，右子则交换，然后递归左右子树，根左右，先序遍历
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();
        BinaryTree b = new BinaryTree();
        BinaryTree c = new BinaryTree();

        a.left = b;
        a.right = c;
        a.value = 1;
        b.value = 2;
        c.value = 3;

        mirrorBinaryTree(a);
        a.pre(a);

    }

    //镜面二叉树方法
    public static void mirrorBinaryTree(BinaryTree pNode) {
        if (pNode == null) return;
        if (pNode.left == null && pNode.right == null) return;
        //正常情况则交换左右子树
        BinaryTree temp = pNode.left;
        pNode.left = pNode.right;
        pNode.right = temp;

        if (pNode.left != null) mirrorBinaryTree(pNode.left);
        if (pNode.right != null) mirrorBinaryTree(pNode.right);
    }

    //二叉树
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        //先序遍历
        static void pre(BinaryTree root) {
            if (root == null) return;
            System.out.print(root.value);
            if (root.left != null) pre(root.left);
            if (root.right != null) pre(root.right);
        }
    }
}
