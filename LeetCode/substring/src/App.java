import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

import sun.misc.Queue;

public class App {
    public static void main(String[] args) {
      String aa = "asd";
      String subaa = aa.substring(2, 3);
      int[] nums = {-1,-1,-2};
      Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(map.get(i), 0)+1);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                ;
            }
        }
        String a= "ababasdasda";
        String b = a.substring(0, 1);
        System.out.println(shortest("aaaaabbdaaaacccdddddeeffbb",3));
    }

  public static String shortest(String input, int k) {
    // Write your solution here
    StringBuffer s = new StringBuffer(input);
    StringBuilder sb = new StringBuilder(input);
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
    String s;
    int a;
    Integer count = map.get(temp);
    if (count == 1) {
      map.remove(temp);
    } else {
      map.put(temp, count - 1);
    }
  }
}


