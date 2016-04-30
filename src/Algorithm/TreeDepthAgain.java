package Algorithm;

/**
 * Created by Lunar on 2016/4/16.
 * 剑指Offer第39题复习：二叉树的深度（通过牛客AC）
 * 思路：深度为1+左右子树的深度的大值。
 */
public class TreeDepthAgain {
    public int TreeDepth(TreeNode pRoot) {
        if (pRoot == null) return 0;
        int leftDepth = 0;
        int rightDepth = 0;
        if (pRoot.left != null)
            leftDepth = TreeDepth(pRoot.left);
        if (pRoot.right != null)
            rightDepth = TreeDepth(pRoot.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
