package Algorithm;

import java.util.ArrayList;

/**
 * Created by Lunar on 2016/4/16.
 * 剑指Offer25题二叉树中和为某一值的路径复习。
 */
public class FindPathAgain {
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectedSum) {

        if (root == null) return resultList;
        list.add(root.val);
        expectedSum -= root.val;
        if (expectedSum == 0 && root.left == null && root.right == null)
            resultList.add(new ArrayList<>(list));

        if (root.left != null)
            FindPath(root.left, expectedSum);
        //如果左子树不为空递归左子树
        if (root.right != null)
            FindPath(root.right, expectedSum);
        list.remove(list.size() - 1);
        return resultList;

    }
}
