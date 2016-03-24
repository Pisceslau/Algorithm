package Search;

import DataStructure.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Lunar on 2016/1/28.
 * 链表的灵活性，和有序数组查找的高效性结合起来的符号表实现：二叉查找树，链接需要额外的空间
 * 二叉查找树和有序性相关的操作效率，树的高度（树中任意结点的最大深度）
 * 树的高度决定了在最坏情况下的性能（范围查找除外）额外成本和返回的键的数量成正比
 * 可以认为随机构造的树中所有路径的长度都小于3lgN（lg以2为底的对数）而平衡二叉查找树可以保证无论键的插入顺序如何
 * 树的高度都是总键的对数
 *
 * 一日一个快捷键：
 *
 * CTRL + SHIFT + ENTER直接写出大括号
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;//二叉查找树的根结点

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    //得到某个键的值
    public Value get(Key key) {
        //从根结点root递归查找该键
        return   get(root, key);
    }

    private Value get(Node x, Key key) {
        //在以x为根结点的子树中查找并返回key对应的值
        //如果找不到则返回null
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }


    public void put(Key key, Value val) {
        //查找key, 找到则更新它的值， 否则为它创建一个新的结点,返回结点（包含键值的  ）
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        //如果key存在于以x为根结点的子树中，则更新它的值
        //否则将以key和val为键值的新结点插入到子树中
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //BST中最小的结点的键
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);

    }

    //BST中最大结点键
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    //中序遍历,打印结点
    private void print(Node x) {
        if (x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }

    //二叉查找树的范围查找操作
  /*  public Iterable<Key> keys() {
        return keys(min(), max());
    }*/

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo =  lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        //如果键大于最低值，说明有可能还大于最大值，要落在这个范围的话，则继续左移
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        //如果键小于最低值，说明有可能还小于最小值，要落在这个范围的话，则继续右移
        if (cmphi > 0) keys(x.right, queue, lo, hi);

    }

    //删除最小值
    public void deleteMin() {
        root = deleteMin(root);
    }


    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //删除最大值
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    //删除一个结点
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);//deleteMin最后回溯到t.right
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    //max(), floor(), ceiling()， select(), rank()方法的实现
    private class Node {
        private Key key;//键
        private Value val;//值
        private Node left, right;//指向子树的链接
        private int N;//以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

}


