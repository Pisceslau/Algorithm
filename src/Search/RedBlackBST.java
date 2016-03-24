package Search;

/**
 * Created by Lunar on 2016/1/30.
 * 红黑树 实现2-3树
 * 红黑树的基本思想是：用标准的二叉树（完全由2-结点构成）和一些额外的信息（替换）3-结点来表示2-3树
 * 我们将树中的链接分为二种类型：红链接 将两个2-结点链接起来构成一个3-结点
 * 黑链接 2-3树中的普通链接
 * 优点：无需修改便可以使用标准二叉树的get()方法
 * <p>
 * 等价定义：红链接均为左链接 没有任何一个结点同时和二条红色链接相连； 该树是完美黑色平衡的，即任意空链接到根结
 * 点的路径上的黑链接数量相同
 * <p>
 * 结点的颜色是指向该结点的链接的颜色，反之亦然。
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    /*父结点指向的结点的链接是黑色、空链接的话则为false
    * 父结点指向的结点的链接是红色则为true*/
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;//根结点

    private int size() {
        return size(root);
    }

    //私有方法isRed()判断结点和它父结点之间的链接的颜色
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    //左旋
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    //左旋
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    //更换颜色
    public void flipColor(Node h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    //put方法
    private void put(Key key, Value val) {
        //查找key,找到则更新其值，否则为它创建一个结点
        root = put(root, key, val);
        root.color = BLACK;//因为指向root结点的链接为空，规定了空连接颜色为黑色


    }

    private Node put(Node h, Key key, Value val) {
        if (h == null)//标准的插入插入操作,其父结点和红链接相连
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public class Node {
        Key key;//键
        Value val;//值
        Node left, right;//左右链接
        int N;//这课子树中结点总数
        boolean color;//父结点指向此结点链接的颜色

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

}