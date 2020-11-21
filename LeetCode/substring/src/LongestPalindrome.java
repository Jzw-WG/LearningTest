/**LeetCode 5 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LongestPalindrome {
    // public String longestPalindrome(String s) {
    //     if (s.equals("")) {
    //         return "";
    //     }
    //     int max = 0;
    //     int maxIndex = 0;
    //     List<String> list = new ArrayList();
    //     for (int i = 0; i < s.length(); i++) {
    //         String result = getkth(s, i, i, i);
    //         list.add(result);
    //         if (max < result.length()) {
    //             maxIndex = i;
    //             max = result.length();
    //         }
    //     }
    //     return list.get(maxIndex);
    // }

    // public String getkth(String s, int k, int l, int r) {
    //     // if (l < 0 || r > s.length() - 1) {
    //     //     return "";
    //     // }
    //     while (l >= 0 && r <= s.length() - 1) {
    //         if (s.charAt(l) == s.charAt(k)) {
    //             if (l-1 >= 0 && r <= s.length() - 1)
    //                 return getkth(s, k, l-1, r);
    //         }
    //         if (s.charAt(r) == s.charAt(k)) {
    //             if (l >= 0 && r+1 <= s.length() - 1)
    //                 return getkth(s, k, l, r+1);
    //         }
    //         if (s.charAt(l) == s.charAt(r)) {
    //             if (l-1 >= 0 && r+1 <= s.length() - 1)
    //                 return getkth(s, k, l-1, r+1);            
    //         }
    //         break;
    //     }
    //     return s.substring(l,r+1);
    // }

    /**
     * DP 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 中心扩散
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String testStr = "babad";
        LongestPalindrome l = new LongestPalindrome();
        String a = l.longestPalindrome2(testStr);
        System.out.println(a);
    }
}
