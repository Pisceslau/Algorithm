package Algorithm;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by E440 on 2016/1/18.
 */
public class StdIn {
    /**
     * 公开类
     */
    public static Scanner scanner;
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    static {
        init();
    }

    private static void init() {
        setScanner(new Scanner(new BufferedInputStream(System.in),"UTF-8"));

    }

    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;

    }



    public static long readLong() {
        return scanner.nextLong();
    }

    public static byte readByte() {
        return scanner.nextByte();
    }

    public static float readFlost() {
        return scanner.nextFloat();
    }

    public static double readDouble() {
        return scanner.nextDouble();
    }

    public static String readString() {
        return scanner.next();
    }

    public static String readAll() {
        if (!scanner.hasNextLine())
            return "";
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    public static String[] readAllStrings() {
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0) {
            return tokens;
        }
        String[] decapitokens = new String[tokens.length - 1];
        for (int i = 0; i < tokens.length - 1; i++)
            decapitokens[i] = tokens[i + 1];
        return decapitokens;


    }

    //得到输入的整数数组
    public static int[] readAllInts() {
        String[] s = readAllStrings();
        int[] values = new int[s.length];
        for (int i = 0; i < s.length; i++)
            values[i] = Integer.parseInt(s[i]);
        return values;

    }

    public static boolean readBoolean() {
        String s = readString();
        if (s.equalsIgnoreCase("true")) return true;
        if (s.equalsIgnoreCase("false")) return false;
        if (s.equals("1")) return true;
        if (s.equals("0")) return false;
        return false;
    }
    // throw newInputMismatchException();

    public static boolean isEmpty() {
        scanner = new Scanner(System.in);
        return !scanner.hasNext();
    }

    /* public static String[] readAllLines(){
         ArrayList<String> lines = new ArrayList<String>();
         while (hasNextLine()){
             lines.add(readLine());
         }
         return lines.toArray(new String[0]);
     }**/
    //读取键值
    public static int readInt() {
        return scanner.nextInt();
    }

    public static int println(int key) {
        return key;

    }
}
