public class MinSpaceRemain {
    public static int minSpaceRemain(int v, int[] array) {
        int n = array.length;
        int[][] dp = new int[n + 1][v + 1];
        for (int i = 0; i <= v; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                if (j >= array[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - array[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][v];
    }
    public static void main(String[] args) {
        int v = 24;
        int[] array = {8,8,7,6};
        System.out.println(minSpaceRemain(v, array));
    }
}