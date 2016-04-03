package DesignPattern.DecoratorPattern.YourDecoratorOfJavaIO;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lunar on 2016/4/3.
 * Head First 装饰者模式:编写自己的JavaI/O装饰者
 * 把输入流中的所有大写字符转换成小写
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read() throws IOException {
        int c = super.read();
        return (c == -1) ? c : Character.toLowerCase((char) c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
