package DesignPattern.AdapterPattern;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by Lunar on 2016/4/3.
 * Head First设计模式适配器模式例子：
 * 编写一个Enumeration适配器将枚举适配到迭代器
 */
/*因为我们将枚举适配成迭代器，适配器需要实现迭代器接口
* 适配器必须看起来就像是一个迭代器*/
public class EnumerationIterator implements Iterator {
    Enumeration enumeration;//利用组合的方式

    @Override
    public boolean hasNext() {
        //迭代器的hasNext方法其实是委托给枚举的hasMoreElements()
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        //迭代器的next其实就是委托给枚举的nextElement();方法
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        //不幸，我们不能支持迭代器的remove方法，所以必须放弃，在这里，我们做法是抛出一个异常。
        throw new UnsupportedOperationException();
    }
}
