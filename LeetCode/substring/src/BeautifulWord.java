import java.util.ArrayList;
/**
 * 漂亮数指 字符串的每个字符出现的次数都能被k整除 
 * 找到比s字典序大的最小的漂亮数
 */
public class BeautifulWord {

    public void nextbeautifulWord(String s, int k) {
        int n = s.length();
        ArrayList<String> combinations = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        backtrack(combinations, combination, s, k);
    }

    public void backtrack(ArrayList<String> combinations, StringBuilder combination, String s, int k) {
        int n = s.length();
        if (combination.length() == n && /*是否漂亮*/) {
            combinations.add(combination.toString());
            return;
        }
        for (int i = 0; i < 26; i++) {//下一个字典序
            combination.append('a' + i);
            backtrack(combinations, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] As = {1,1,1,1,1,1,5};
        BeautifulWord b = new BeautifulWord();
        return;
    }
}