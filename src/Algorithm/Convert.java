package Algorithm;

/**
 * Created by Lunar on 2016/3/20.
 * 剑指Offer第二十七题：把二叉搜索树转换为一个排序的双向链表
 */
public class Convert {
    public TreeNode convert(TreeNode root) {
        //刚是最后我们要头结点
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) return root;
        //递归遍历左子树，然后返回左子树根结点
        TreeNode leftNode = convert(root.left);
        //然后得到左子树最大的数结点
        TreeNode leftMax = leftNode;
        while (leftMax != null && leftMax.right != null) {
            leftMax = leftMax.right;
        }
        //把左边最大的数那个结点与根结点相连
        if (leftNode != null) {
            leftMax.right = root;
            root.left = leftMax;
        }
        //递归遍历右子树,构建双链表
        TreeNode rightNode = convert(root.right);
        //如果右子树链表不为空的话，则把右子树添加到根结点后面
        if (rightNode != null) {

            rightNode.left = root;
            root.right = rightNode;
        }
        return leftNode != null ? leftNode : root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(16);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode node = new Convert().convert(root);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}
