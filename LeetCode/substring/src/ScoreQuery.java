import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class ScoreQuery {
    public static void handleScore(String[] operate, int[][] input, int[] score) {
        if (operate.length != input.length) {
            return;
        }
        int M = operate.length;
        for (int i = 0; i < M; i++) {
            
            if (operate[i].equals("Q")) {
                int l = Math.min(input[i][1], input[i][0]);
                int r = Math.max(input[i][1], input[i][0]);
                int[] MAX = new int[r - l + 1];
                System.arraycopy(score, l - 1, MAX, 0, MAX.length);
                Arrays.sort(MAX);
                System.out.println(MAX[MAX.length - 1]);
            } else if (operate[i].equals("U")) {
                score[input[i][0] - 1] = input[i][1];
            } else {
                return;
            }
        }
    }

    public static void readAGroup(BufferedReader br, String[] operate, int[][] input, int[] score) throws IOException{
        
        String content = null;
        
        String[] scoreS = br.readLine().trim().split(" ");
        for (int i = 0; i < scoreS.length; i++) {
            score[i] = Integer.parseInt(scoreS[i]);
        }
        
        int row = 0;
        while ((row < operate.length) && (content = br.readLine()) != null) {
            operate[row] = content.trim().split(" ")[0];
            input[row][0] = Integer.parseInt(content.trim().split(" ")[1]);
            input[row][1] = Integer.parseInt(content.trim().split(" ")[2]);
            row++;
        }
    }
    public static void main(String[] args) throws Exception {
        String content = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((content = br.readLine()) != null) {
            String[] t = content.trim().split(" ");
            String[] operate = new String[Integer.parseInt(t[1])];
            int[][] input = new int[Integer.parseInt(t[1])][2];
            int[] score = new int[Integer.parseInt(t[0])];
            ScoreQuery.readAGroup(br, operate, input, score);
            ScoreQuery.handleScore(operate, input, score);
        }
    }
}