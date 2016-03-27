package OthersAboutJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Lunar on 2016/3/27.
 * Java Collection
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);//自动装箱
        }
        for (Integer i : c) {
            System.out.print(i);
        }

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(4, 3, 2, 1, 0));
        Collections.addAll(collection, 1, 2, 3, 4, 5);

    }
}
