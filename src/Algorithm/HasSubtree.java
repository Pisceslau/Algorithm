package Algorithm;

/**
 * Created by Lunar on 2016/3/12.
 * 剑指Offer18题：树的子结构：判断B树是不是A的子结构
 */
public class HasSubtree {
    //判断是不是子树
    public boolean hasSubTree(BinaryTree root1, BinaryTree root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            //如果根结点相同
            if (root1.value == root2.value) result = doesTree1HasTree2(root1, root2);
            //如果根结点不同则遍历大树
            if (!result) result = hasSubTree(root1.left, root2);
            if (!result) result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    private boolean doesTree1HasTree2(BinaryTree root1, BinaryTree root2) {

        if (root1 == null) return false;
        if (root2 == null) return true;
        if (root1.value != root2.value) return false;
        //递归左右子树看是否相同
        return doesTree1HasTree2(root1.left, root1.left) && doesTree1HasTree2(root1.right, root2.right);

    }

    //树的结构
    class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    }
}
