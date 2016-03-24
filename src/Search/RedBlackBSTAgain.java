package Search;

/**
 * Created by Lunar on 2016/3/16.
 * 红黑树复习
 */
public class RedBlackBSTAgain<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    public boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    Node rotateLeft(Node h) {
        //原结点为h,h为指向原结点的指针
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + 1 + size(x.right);
        return x;
    }

    //翻转颜色
    void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    //红黑树的插入算法
    public void put(Key key, Value value) {
        root = put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h==null) return new Node(RED, value, key, 1);
        int cmp = key.compareTo(h.key);
        if (cmp<0) h.left = put(h.left, key, value);
        else if (cmp>0) h.right = put(h.right, key, value);
        else h.value = value;
        //变换的情况
        if (isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left)&&isRed(h.right)) flipColor(h);
        if (isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);
        h.N = size(h.left) + 1 + size(h.right);
        return h;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    //红黑树结点的定义
    public class Node {
        private boolean color;
        private Value value;
        private Key key;
        private int N;
        private Node left, right;

        public Node(boolean color, Value value, Key key, int n) {
            this.color = color;
            this.value = value;
            this.key = key;
            N = n;
        }

    }


}
