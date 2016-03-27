package OthersAboutJava;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Lunar on 2016/3/26.
 * Java程序员面试宝典：P301面试题3截取字符串 汉字，英语字母
 */
public class StringSub {
    public static boolean isChineseChar(char c) throws UnsupportedEncodingException {
        return String.valueOf(c).getBytes("GBK").length > 1;
    }

    public static String cutString(String orignal, int count) throws UnsupportedEncodingException {
        if (orignal != null && !"".equals(orignal)) {
            orignal = new String(orignal.getBytes(), "GBK");
            if (count > 0 && count < orignal.getBytes("GBK").length) {
                StringBuffer buff = new StringBuffer();
                char c;
                for (int i = 0; i < count - 1; i++) {
                    c = orignal.charAt(i);
                    buff.append(c);
                    if (StringSub.isChineseChar(c)) {
                        --count;
                    }
                }
                return buff.toString();
            }
        }
        return orignal;
    }

    public static void main(String[] args) {
        try {
            System.out.println("汉".getBytes("GBK").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("a".getBytes().length);
        String s = "我gfr是Chinese";

        try {
            System.out.println("cutlbit" + StringSub.cutString(s, 1));
            System.out.println("cut2bit" + StringSub.cutString(s, 2));
            System.out.println("cut4bit" + StringSub.cutString(s, 6));
            System.out.println("cut6bit" + StringSub.cutString(s, 7));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Queue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                int result = i % 2 - j % 2;
                if (result == 0) {
                    result = i - j;
                }
                return result;
            }
        });
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }

    }


}
