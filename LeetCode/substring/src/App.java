import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        System.out.println(shortest("aaaaabbdaaaacccdddddeeffbb",3));
    }

  public static String shortest(String input, int k) {
    // Write your solution here
    if (input == null || input.length() == 0 || k <= 0) {
      return new String();
    }
    int gLeft = 0;
    int length = Integer.MAX_VALUE;
    int left = 0;
    Map<Character, Integer> map = new HashMap();
    for (int i = 0; i < input.length(); i++) {
      char temp = input.charAt(i);
      Integer count = map.get(temp);
      if (count == null) {
        while (map.size() > k - 1) {
          removeChar(map, input, left++);
        }
        map.put(temp, 1);
      } else {
            map.put(temp, count + 1);        
      }
      while (left + 1 < i && (input.charAt(left) == input.charAt(left + 1) || input.charAt(left) == input.charAt(i) )) {
        temp = input.charAt(left);
        count = map.get(temp);
        map.put(temp, count - 1);
        left++;
      }
      if (map.size() == k && i - left + 1 < length) {
        gLeft = left;
        length = i - left + 1;
      }
    }
    if (map.size() < k) {
      return new String();
    }
    return input.substring(gLeft, gLeft + length);
  }
  
  private static void removeChar(Map<Character, Integer> map, String input, int left) {
    char temp = input.charAt(left);
    Integer count = map.get(temp);
    if (count == 1) {
      map.remove(temp);
    } else {
      map.put(temp, count - 1);
    }
  }
}


