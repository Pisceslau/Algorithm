package Algorithm;

/**
 * Created by Lunar on 2016/3/7.
 * 剑指Offer第六题：重建二叉树
 */
public class ConstructBinaryTree {
    //构造二叉树的方法
    /*@param 前序 中序 数组长度
    * */
    public static BinaryTree constructTree(int[] preOrder, int[] inOrder, int length) {
        //树为空
        if (preOrder == null || inOrder == null || length <= 0)
            return null;
        //取出前序遍历的首结点的值作为根结点
        int rootValue = preOrder[0];
        //新建一个二叉树根结点的值为preOrder[0]左右子树为空
        BinaryTree root = new BinaryTree();
        root.value = rootValue;
        root.setLeft(null);
        root.setRight(null);

        //左子树的结点个数
        int leftNums = 0;

        //在中序遍历中找到根结点的值
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue)
                break;
            else {
                //在找到根结点值得之前是为左子树的结点个数
                leftNums++;
            }
        }
        //右子树的结点个数为整个结点的个数-根结点的一个-左子树的结点数目
        int rightNums = inOrder.length - 1 - leftNums;
        //while是循环结构，if是选择判断while执行后还判断，if是执行完然后去执行下一个语句
        //刚刚是while写造成死循环了因为leftNumbers此时永远大于0
        //构造左子树
        if (leftNums > 0) {
            //左子树的前序中序数组构造完毕
            int[] leftInOrder = new int[leftNums];
            int[] leftPreOrder = new int[leftNums];

            for (int i = 0; i < leftNums; i++) {
                leftInOrder[i] = inOrder[i];
                leftPreOrder[i] = preOrder[i + 1];
            }
            //递归构造左子树
            BinaryTree left = constructTree(leftPreOrder, leftInOrder, leftNums);
            root.setLeft(left);
        }
        //构造右子树
        if (rightNums > 0) {
            //右子树的前序中序构造
            int[] rightPreOrder = new int[rightNums];
            int[] rightInOrder = new int[rightNums];

            for (int i = 0; i < rightNums; i++) {
                rightPreOrder[i] = preOrder[i + leftNums + 1];
                rightInOrder[i] = inOrder[i + leftNums + 1];
            }
            //递归构造右子树
            BinaryTree right = constructTree(rightPreOrder, rightInOrder, rightNums);
            root.setRight(right);
        }
        //返回该树
        return root;

    }

    //主方法测试
    public static void main(String[] args) {
        //前中序序列
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree root = constructTree(preOrder, inOrder, preOrder.length);
        printPostOrder(root);
    }

    //后序打印树
    public static void printPostOrder(BinaryTree root) {
        if (root != null) {
            //递归左右根
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.print(root.getValue());
        }
    }

    //二叉树
    public static class BinaryTree {
        private int value;
        private BinaryTree left;//左子树
        private BinaryTree right;//右子树

        public int getValue() {
            return value;
        }

        public BinaryTree getLeft() {
            return left;
        }

        public void setLeft(BinaryTree left) {
            this.left = left;
        }

        public BinaryTree getRight() {
            return right;
        }

        public void setRight(BinaryTree right) {
            this.right = right;
        }

    }
}
