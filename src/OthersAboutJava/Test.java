package OthersAboutJava;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lunar on 2016/3/27.
 * Set存储URL联网与不联网的区别?
 */
public class Test {
    private static final String[] URLNAMES = {
            "http://www.sina.com.cn",
            "http://www.nwu.edu.cn",
            "http://javapuzzlers.com",
            "http://www.google.com",
            "http://Javapuzzlers.com",

    };

    public static void main(String[] args) throws MalformedURLException {
        Set<URL> favorites = new HashSet<>();
        for (String urlName : URLNAMES) {
            favorites.add(new URL(urlName));
        }
        System.out.println(favorites.size());
    }
}
