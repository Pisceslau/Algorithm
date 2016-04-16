package Algorithm;

import java.util.ArrayList;

/**
 * Created by Lunar on 2016/4/16.
 */
public class Solution {
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectedSum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return resultList;


        resultList = FindPath(root, 0, expectedSum, list);
        return resultList;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int curSum, int expectedSum, ArrayList<Integer> list) {

        curSum += root.val;
        list.add(root.val);
        //如果现在的和小于期待的和
        boolean isLeaf = (root.left == null && root.right == null);
        if ((curSum == expectedSum) && isLeaf) {
            //如果相等
            //并且是叶子结点
            resultList.add(list);

        }
        if (root.left != null)
            FindPath(root.left, curSum, expectedSum, list);
        //如果左子树不为空递归左子树
        if (root.right != null)
            FindPath(root.right, curSum, expectedSum, list);

        list.remove(list.size() - 1);

        return resultList;

    }
}
