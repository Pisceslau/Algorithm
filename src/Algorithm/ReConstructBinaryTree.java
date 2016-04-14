package Algorithm;

/**
 * Created by Lunar on 2016/4/14.
 * 剑指Offer重建二叉树网上的解法和自己重新被牛客AC的解法
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }

        return root;
    }

    //自己提交的解法（牛客AC）
    public class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            if (pre == null || in == null) return null;
            int preLength = pre.length;
            int inLength = pre.length;
            if (preLength <= 0 || inLength <= 0) return null;

            //得到根结点的值
            int rootValue = pre[0];
            //新建根结点
            TreeNode root = new TreeNode(rootValue);
            root.left = null;
            root.right = null;
            int numsOfLeft = 0;//定义左子树结点个数。
            //在中序中找到根结点
            for (int i = 0; i < inLength; i++) {
                if (in[i] == rootValue)
                    break;
                else {
                    numsOfLeft++;
                }
            }
            //右子树的结点个数
            int numsOfRight = preLength - 1 - numsOfLeft;
            //构建左子树
            if (numsOfLeft > 0) {
                //左子树的前序
                int[] preLeft = new int[numsOfLeft];
                int[] inLeft = new int[numsOfLeft];

                for (int i = 0; i < numsOfLeft; i++) {
                    preLeft[i] = pre[i + 1];
                    inLeft[i] = in[i];
                }
                TreeNode leftTree = reConstructBinaryTree(preLeft, inLeft);
                root.left = leftTree;
            }
            //构造右子树
            if (numsOfRight > 0) {
                int[] preRight = new int[numsOfRight];
                int[] inRight = new int[numsOfRight];

                for (int i = 0; i < numsOfRight; i++) {
                    preRight[i] = pre[i + 1 + numsOfLeft];
                    inRight[i] = in[i + 1 + numsOfLeft];
                }
                TreeNode rightTree = reConstructBinaryTree(preRight, inRight);
                root.right = rightTree;
            }
            return root;
        }
    }
}
