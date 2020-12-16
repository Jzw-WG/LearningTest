/**LeetCode 290 */
import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) {
            return false;
        }
        HashMap<String, String> map = new HashMap();
        for (int i = 0; i < ss.length; i++) {
            String c = String.valueOf(pattern.charAt(i) + 26);
            if (!map.containsKey(ss[i]) && !map.containsKey(c)) {
                map.put(ss[i], c);
                map.put(c, ss[i]);
            } else {
                if (!map.getOrDefault(c, "").equals(ss[i]) || !map.getOrDefault(ss[i], "").equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean b = wp.wordPattern(pattern, s);
    }
}