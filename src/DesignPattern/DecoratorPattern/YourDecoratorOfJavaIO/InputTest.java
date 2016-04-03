package DesignPattern.DecoratorPattern.YourDecoratorOfJavaIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lunar on 2016/4/3.
 * 测试类
 */
public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("F:\\JavaEEWorkSpace\\Test\\src\\DesignPattern\\DecoratorPattern\\YourDecoratorOfJavaIO\\test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
