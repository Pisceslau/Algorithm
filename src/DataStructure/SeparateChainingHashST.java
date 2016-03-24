package DataStructure;

import edu.princeton.cs.algs4.SequentialSearchST;

/**
 * Created by Lunar on 2016/3/18.
 * 散列表拉链法解决散列冲突
 * 基于拉链法的散列表实现简单，在键的顺序不是这么重要的场合下可能 是最快的也是
 * 使用最广泛的符号表实现，查找和插入快速方便
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;//键值对总数
    private int M;//散列表的大小
    private SequentialSearchST<Key,Value>[] st;//存放链表对象的数组//其每个位置存放指向链表的指针

   /* public SeparateChainingHashST() {
        this(997);
    }*/
    //创建M条链表

    public SeparateChainingHashST(int M) {
        this.M = M;
        //存放链表对象的数组的初始化
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i =0;i<M;i++) {
            st[i] = new SequentialSearchST<>();//每个元素是链表
        }
    }
    //求散列值
    private int hash(Key key) {
        return (key.hashCode()&0x7fffffff)%M;
    }

    public Value get(Key key) {
        //st[hash(key))是链表使用链表的get方法取得对应键的值并强制类型转换之
        return (Value)st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public void delete(Key key, Value value) {
        st[hash(key)].delete(key);
    }
}
