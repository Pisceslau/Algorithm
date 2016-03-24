package DataStructure;

import java.util.Iterator;

/**
 * Created by Lunar on 2016/1/20.
 * 数据结构：背包
 * 集合类的数据类型的一个关键特性是我们可以用它们存储任意类型的数据
 * 泛型（参数化类型）
 * 背包是一种不支持从中删除元素的集合数据类型
 * 它的目的就是帮助用例收集元素并迭代遍历所有
 * 收集到的元素，迭代的顺序不确定与用例无关
 * 元素的处理顺序不重要
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
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
}

