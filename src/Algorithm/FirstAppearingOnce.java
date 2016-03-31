package Algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lunar on 2016/3/31.
 * 剑指Offer第五十五题：字符流中第一个不重复的字符
 */
public class FirstAppearingOnce {
    //新建HashMap ，键为字符，值为频率
    Map<Character, Integer> map = new HashMap<>();
    //创建一个List集合用于接收字符流中的字符
    List<Character> list = new LinkedList<>();

    //从字符流中插入字符到HashMap中,还有List中
    public void insert(char ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, 1);//map中不包含则加入，频率为1
            list.add(ch);
        } else {
            map.put(ch, map.get(ch) + 1);
            if (list.contains(ch))
                list.remove(ch);
        }
    }
/*
    public char firstAppearingOnce(char ch) {
        insert(ch);
        for (int i = 0; i < map.size(); i++) {
            if (map.get(ch) == 1)
                return ch;
        }
    }*/
}
