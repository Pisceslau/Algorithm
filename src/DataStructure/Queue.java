package DataStructure;

import java.util.Iterator;

/**
 * Created by Lunar on 2016/1/20.
 * 数据结构：队列 链表实现
 * 实例变量first指向队列的开头，实例变量last指向队列的末尾
 * <p>
 * 先进先出队列
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first;//指向最早添加的结点的链接
    private Node last;//指向最近添加的结点的链接
    private int N;//队列中的元素数量

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public boolean isEmpty() {
        return first == null;//或N==0

    }

    public int size() {
        return N;
    }

    //进入队列
    public void enqueue(Item item) {
        //向表尾添加元素
        Node oldFirst = last;
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else oldFirst.next = last;
        N++;
    }

    public Item dequeue() {
        //从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        //定义了结点的嵌套类
        Item item;
        Node next;
    }
}
