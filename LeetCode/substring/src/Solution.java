import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param old string字符串 
     * @return string字符串
     */
    public String skipsame (String old) {
        // write code here
        HashSet<Character> map = new HashSet<>();
        StringBuilder sb = new StringBuilder(old);
        for (int i = 0; i < old.length(); i++) {
            char c = old.charAt(i);
            if (!map.contains(c)) {
                map.add(c);
                sb.append(c);
            } else {
                //sb.append(c);
            }
        }
        return sb.toString();
    }

    public int findLongest(int[] A, int n) {
        // write code here
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i - 1; j++) {
                if (A[j] < A[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[n];
    }

    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int reverseStart = low + (high - low) / 2;
            if (array[reverseStart] <= array[high]) {
                high = reverseStart;
            } else {
                low = reverseStart + 1;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {2};
        System.out.println(s.minNumberInRotateArray(A));
    }
}