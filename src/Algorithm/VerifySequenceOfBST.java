package Algorithm;

/**
 * Created by Lunar on 2016/3/18.
 * 剑指Offer第二十四题：检测一个数组序列是不是一个二叉树的后序遍历
 */
public class VerifySequenceOfBST {
    public static boolean verifySquenceOfBST(int[] sequence, int length) {
        //int length = sequence.length;
        if (sequence == null || length <= 0) {
            return false;
        }
        //得到根结点的值
        int root = sequence[length - 1];
        //从左到右遍历左子树增加索引i直到一个大于根结点的值的地方跳出循环，并把这个开始大于根结点的位置
        //的索引保留赋值给j，开始右子树
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        //从左向右搞右子树，如果出现小于根结点的值得，说明肯定不是
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //下面开始递归的调用
        //判断左子树是不是BSR
        boolean left = true;
        if (i > 0) {
            left = verifySquenceOfBST(sequence, i);
        }
        //判断右子树是不是BSR
        boolean right = true;
        if (i < length - 1) {
            right = verifySquenceOfBST(sequence, length - i - 1);
        }
        return left && right;

    }

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 9, 11, 10, 8};
        int[] array2 = {7, 4, 6, 5};
        System.out.println(verifySquenceOfBST(array, array.length));
        System.out.println(verifySquenceOfBST(array2, array2.length));
    }
}
