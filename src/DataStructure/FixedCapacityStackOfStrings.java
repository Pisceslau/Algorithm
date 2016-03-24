package DataStructure;

/**
 * Created by Lunar on 2016/1/23.
 * <p>
 * 一种表示定容字符串栈的抽象数据类型
 */
public class FixedCapacityStackOfStrings {
    //容量
    private int N;
    //字符串数组
    private String[] a;

    //构造函数 创建一个容量为cap的定容字符串栈
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    //压入（添加）一个字符串
    public void push(String s) {
        a[N++] = s;
    }

    //弹出（删除）最近添加的字符串
    public String pop() {
        return a[--N];
    }

    //栈是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //栈中的字符串数量
    public int size() {
        return N;
    }
    //测试用例
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);

        String s1 = "liu";
        String s2 = "wen";
        String s3 = "yue";

        s.push(s1);
        s.push(s2);
        s.push(s3);

        System.out.print(s.size());
        if (!s.isEmpty()) {
            for (int i = s.size() - 1; i >= 0; i--) {
                System.out.print(s.pop());
            }
        }
    }
}