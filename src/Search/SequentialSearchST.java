package Search;

import DataStructure.Queue;

/**
 * Created by Lunar on 2016/1/26.
 * 顺序查找（基于无序链表）
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N;

    //查找指定的键，返回相关联的值
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                //命中
                return x.val;
            }
        }
        return null;
    }

    //查找给定的键，找到则更新其值，否则在表中创建结点
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("Key is Null");
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
            first = new Node(key, val, first);
            N++;
        }
    }
    //删除方法
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("Key is Null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;

    }

    //键值对数目
    public int size() {
        return N;
    }

    //表中所有键的集合
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    //是空么
    boolean isEmpty() {
        return size() == 0;
    }

    private class Node {
        //列表结点的定义
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

}
