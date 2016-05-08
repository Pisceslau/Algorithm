package OthersAboutJava;

/**
 * Created by Lunar on 2016/5/7.
 * Java知识之Lambda表达式
 * 有错误：待改正。
 */
public class LambdaExpression {


    public static int add(NewWayAdd newWayAdd) {
        int a = 1, b = 3;
        return newWayAdd.newWayAddFunction(a, b);

    }

    //   public static int addE(int a,int b);
    public static void main(String[] args) {


    }


    //定义函数接口（只有一个抽象方法的接口）
    @FunctionalInterface
    interface NewWayAdd {
        int newWayAddFunction(int a, int b);
    }
}
