package Algorithm;


import java.util.ArrayList;

/**
 * Created by Lunar on 2016/3/31.
 * 剑指Offer第六十一题：按之字形打印二叉树。
 * 题目；请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左
 * 到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右顺序打印，其他行类推。
 * 思路：奇数层先保存自己的左子结点，后保存自己的右子结点
 * 偶数层先保存自己的右子结点，再保存自己的左子结点。
 */
public class PrintTreesInZigZag {
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        //结果集合保存的是每一行的arrayList，每一行的ArrayList包含每一行的各个元素
        //当前栈
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (pRoot == null) return resultList;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> current = new ArrayList<>();
        ArrayList<TreeNode> reverse = new ArrayList<>();
        int flag = 0;
        current.add(pRoot);
        while (!current.isEmpty()) {
            TreeNode node = current.get(current.size() - 1);//因为模仿栈，所以从最后取得
            current.remove(current.size() - 1);
            System.out.print(node.val);
            //每一行的结果存在结果里
            result.add(node.val);
            if (flag == 0) {
                if (node.left != null) reverse.add(node.left);
                if (node.right != null) reverse.add(node.right);

            } else {
                if (node.right != null) reverse.add(node.right);
                if (node.left != null) reverse.add(node.left);

            }
            if (current.isEmpty()) {
                //打完了，换行，添加此集合到结果集里
                resultList.add(result);
                //每次打印完，新建一个结果装每行的元素。
                result = new ArrayList<>();
                System.out.println();

                flag = 1 - flag;

                ArrayList<TreeNode> temp = current;
                current = reverse;
                reverse = temp;
            }

        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        ArrayList<ArrayList<Integer>> resultList = print(n1);
        for (ArrayList<Integer> result : resultList) {
            System.out.print(result);
        }
    }
}
