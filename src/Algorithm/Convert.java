package Algorithm;

/**
 * Created by Lunar on 2016/3/20.
 * 剑指Offer第二十七题：把二叉搜索树转换为一个排序的双向链表
 */
public class Convert {
    BinaryTreeNode convert(BinaryTreeNode rootOfTree) {
        if (rootOfTree == null) {
            return null;
        }
        if (rootOfTree.left == null && rootOfTree.right == null) return rootOfTree;
        BinaryTreeNode lastNodeInList = null;//链表的最后一个结点
        convertNode(rootOfTree, lastNodeInList);//装换的方法
        //lastNode 是指向双向链表的尾结点的我们需要返回头结点，循环左移动
        BinaryTreeNode headOfList = lastNodeInList;
        while (headOfList != null && headOfList.left != null) {
            headOfList = headOfList.left;
        }
        return headOfList;
    }

    private void convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
        if (node == null) {
            return;
        }
        BinaryTreeNode current = node;
        if (current.left != null) {
            convertNode(current.left, lastNodeInList);
        }
        current.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = current;
        }
        lastNodeInList = current;
        if (current.right != null) {
            convertNode(current.right, lastNodeInList);
        }

    }

    static class BinaryTreeNode {
        int value = 0;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}
