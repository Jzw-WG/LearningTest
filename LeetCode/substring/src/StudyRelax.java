import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class StudyRelax {
    public int decrease;
    public int increase;
    public HashMap<String, Integer> memo = new HashMap<>();
    public int getScore(int startScore, int decrease, int increase, int hours) {
        this.decrease = decrease;
        this.increase = increase;
        return dp(startScore, hours);
    }

    public int dp(int currentScore, int hours) {
        if (hours == 1) {
            return currentScore;
        }
        if (memo.containsKey(currentScore + "," + hours)) {
            return memo.get(currentScore + "," + hours);
        }
        int relax = dp(currentScore + increase, hours - 1);
        int study = dp(currentScore - decrease, hours - 1) + currentScore;
        int res = Math.max(relax, study);
        memo.put(currentScore + "," + hours, res);
        return res;
    }

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String content = null;
        // String[] t = br.readLine().trim().split(" ");
        // int[][] input = new int[Integer.parseInt(t[0])][4];
        // int row = 0;
        // while ((content = br.readLine()) != null && (row < Integer.parseInt(t[0]))) {
        //     input[row][0] = Integer.parseInt(content.trim().split(" ")[0]);
        //     input[row][1] = Integer.parseInt(content.trim().split(" ")[1]);
        //     input[row][2] = Integer.parseInt(content.trim().split(" ")[2]);
        //     input[row][3] = Integer.parseInt(content.trim().split(" ")[3]);
        //     row++;
        // }

        int[] q = {15,5,5,4};
        StudyRelax sr = new StudyRelax();
        int res = sr.getScore(q[0], q[1], q[2], q[3]);
        System.out.println(res);
    }
}