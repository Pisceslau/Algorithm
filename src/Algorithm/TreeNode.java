package Algorithm;

/**
 * Created by Lunar on 2016/3/29.
 * 二叉树定义(牛客网剑指Offer使用)
 */
public class TreeNode {
    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }
}
