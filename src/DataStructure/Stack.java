package DataStructure;

import java.util.Iterator;

/**
 * Created by Lunar on 2016/1/20.
 * 数据结构：栈,链表实现
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first;//栈顶，最近添加的元素
    private int N;//元素数量
    //嵌套类Node(结点)
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;//或者N==0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        //向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        //数量加一
        N++;
    }
    public Item pop(){
        //栈顶删除元素
        Item item = first.item;
        first = first.next;
        //数量减去一
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    public class ListIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return current !=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
