import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMIO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content = null;
        String[] t = br.readLine().trim().split(" ");
        int[][] input = new int[Integer.parseInt(t[0])][4];
        int row = 0;
        while ((content = br.readLine()) != null && (row < Integer.parseInt(t[0]))) {
            String[] strs = content.trim().split(" ");
            input[row][0] = Integer.parseInt(strs[0]);
            input[row][1] = Integer.parseInt(strs[1]);
            input[row][2] = Integer.parseInt(strs[2]);
            input[row][3] = Integer.parseInt(strs[3]);
            row++;
        }
        // 用到ACM输入的例子
        // StudyRelax
        // ScoreQuery
    }
}