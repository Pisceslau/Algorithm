package Algorithm;

/**
 * Created by Lunar on 2016/4/1.
 * 剑指Offer第六十二题：序列化二叉树
 */
public class Serialize {

    TreeNode node = null;

    String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            builder.append("$,");
            return builder.toString();
        }
        builder.append(root.val);
        builder.append(serialize(root.left));
        builder.append(serialize(root.right));
        return builder.toString();
    }

    /* TreeNode Deserialize(String str) {

         for (int i = 0;i<str.length();i++){
             node.val=(int)str.charAt(i);
             node.left=null;
             node.right = null;
         }

     }*/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        System.out.print(new Serialize().serialize(n1));
    }
}
