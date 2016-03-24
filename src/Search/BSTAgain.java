package Search;

import DataStructure.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Lunar on 2016/3/15.
 * 二叉查找树Again
 */
public class BSTAgain<Key extends Comparable<Key>, Value> {
    //二叉查找树的根结点
    private Node root;

    //结点大小
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    //得到某个键的值
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    //查找值，找到则更新它的值，否则为他创建一个新的结点
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (key == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;

    }

    //最小键
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + 1 + size(x.right);
        return x;
    }

    private void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    //返回最大键
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }

    private void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {//找到了那要删除的结点
            Node t = x;//保存
            x = min(x.right);//x用它的后继结点也就是它的右子树的最小结点代替
            //此时右边子树也有那个最小结点，重复了，于是删除它，更新后的树作为右子树
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }
    //中序遍历，左根右
    public void print(Node x) {
        if (x==null)return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;

        else return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    //查找排名为k的键
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return rank(x.right, key) + 1 + rank(x.left, key);
        else return size(x.left);
    }

    public Iterable<Key> keys() {
        return keys(min(),max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x==null)return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = lo.compareTo(x.key);
        if (cmplo<0) keys(x.left, queue, lo, hi);
        if (cmplo<=0&&cmphi>=0) queue.enqueue(x.key);
        if (cmphi>0)keys(x.right,queue,lo,hi);
    }

    //二叉查找树定义
    public class Node {
        private Value value;
        private Key key;
        private Node left, right;
        private int N;//结点的数目

        public Node(Key key, Value value, int N) {
            this.value = value;
            this.key = key;
            this.N = N;
        }
    }

}
