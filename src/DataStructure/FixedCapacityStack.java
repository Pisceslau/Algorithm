package DataStructure;

import java.util.Iterator;

/**
 * Created by Lunar on 2016/1/23.
 * <p>
 * 一种表示泛型定容栈的抽象数据类型, 下压栈LIFO
 * <p>
 * 如何可迭代呢？
 * 集合数据类型必须实现一个iterator()方法返回一个Iterator对象：implements Iterable<Item>的iterator方法
 * 返回的迭代器都为泛型，迭代器是实现了hasNext()和next()方法的类的对象
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {

    //容量
    private int N;
    //泛型数组
    private Item[] a;

    //构造函数 创建一个容量为cap的定容字符串栈
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    //压入（添加）一个字符串
    public void push(Item item) {
        //将元素压入栈顶
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    //弹出（删除）最近添加的字符串,栈大小是否等于数组大小的1/4
    public Item pop() {
        //从栈顶删除元素
        Item item = a[--N];
        a[N] = null;//避免对象游离，保存一个不需要的对象的引用称之为游离，设置为null.可被垃圾回收之内存
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    //栈是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //栈中的字符串数量
    public int size() {
        return N;
    }

    /*动态调整数组的大小，使得它既可以保存所有的元素，
    * 又不至于浪费过多的空间*/
    private void resize(int max) {
        //将大小为N<=max的栈移动到一个新的大小为max的数组中
        Item[] temp = (Item[]) new Object[max];//临时数组，大小为max
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;//？

    }


    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    //迭代器
    public class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

}
