package Search;

import DataStructure.Queue;

/**
 * Created by Lunar on 2016/1/26.
 * 有序数组的二分查找，有序符号表的完整实现，使用的数据结构是一对平行的数组
 * 一个存储键，一个存储值
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //基于有序数组的二分查找，迭代
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    //递归的二分查找
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) return rank(key, lo, mid - 1);
        else if (cmp > 0) return rank(key, mid + 1, hi);
        else return mid;
    }

    public void put(Key key, Value val) {
        //查找键，找到则更新值，否则创建新的元素
        int i = rank(key);//二分查找获得的下标
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        //若键不存在创建新的元素，键数组该下标后的元素皆向右移动一位置
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        //赋值
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("Key is Null");
        if (isEmpty()) return;

        int i = rank(key);
        //key不在表中
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }
        //删除元素则左移
        for(int j =1; j < N - 1; j++){
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        //元素数量减少一
        N--;
        keys[N] = null;
        vals[N] = null;//避免对象游离
    }

    //基于二分查找的其他操作
    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("Key is Null");
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return keys[i];
        else return keys[i - 1];
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<>();
        //i在低键和高键之间遍历，把键都放置在队列中
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);

        }
        //如果高键hi的值不是空的话
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }

    //某个键的值是否为空
    private boolean contains(Key key) {
        if (key == null) throw new NullPointerException("Key is Null");
        return get(key) != null;
    }

}
