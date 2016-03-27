package OthersAboutJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lunar on 2016/3/26.
 * Java程序员面试宝典：P204面试题2：Iterator也是需要泛型参数的
 * Iterator<String>
 */
public class IteratorGeneric {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("to");
        list.add("Beijing");

        for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
            String s = i.next();
            System.out.println(s);
        }
    }
}
