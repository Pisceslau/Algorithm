package OthersAboutJava;

import java.io.*;

/**
 * Created by Lunar on 2016/3/17.
 * Java序列化，反序列化Demo
 * 静态成员变量属于类不属于对象，还有transient标记的
 * 对象都不参与对象的序列化！！！！！！
 */
public class User implements Serializable {
    private static final long serializableVersionUID = 534343234343434L;

    public int userId;
    public String userName;
    public boolean isMale;

    public User(String userName, int userId, boolean isMale) {
        this.userName = userName;
        this.userId = userId;
        this.isMale = isMale;
    }

    public static void main(String[] args) {
        User user = new User("jake", 0, true);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cache.txt"));
            out.writeObject(user);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //反序列化过程
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cache.txt"));
            try {
                User newUser = (User)in.readObject();
                System.out.println(newUser.userName);
                in.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
