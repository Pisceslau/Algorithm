package Algorithm;

import java.util.HashMap;

/**
 * Created by Lunar on 2016/4/16.
 */
public class Solution {
    HashMap<Character, Integer> map = new HashMap<>();

    public int FirstNotRepeatingChar(String str) {
        if (str == null) return -1;
        int length = str.length();
        int times = 1;
        for (int i = 0; i < length; i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
            map.put(str.charAt(i), times++);
        }
        return 0;
    }
}
