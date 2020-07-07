import java.util.LinkedList;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        LinkedList<Character> stringMap = new LinkedList<>(); 
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            
            char temp = s.charAt(i);
            if (!stringMap.contains(temp)) {
                stringMap.add(temp);
                max++;
                if (max > maxLength) {
                    maxLength = max;
                }
            } else {              
                while (stringMap.getFirst() != temp) {
                    stringMap.poll();
                }
                stringMap.poll();
                stringMap.add(temp);
                max = stringMap.size();                                  
            } 
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String testStr = "";
        // String testStr = "aaaaaaaaa";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int a = l.lengthOfLongestSubstring(testStr);
        System.out.println(a);
    }
}