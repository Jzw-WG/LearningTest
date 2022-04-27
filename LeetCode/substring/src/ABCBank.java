import java.util.Arrays;

public class ABCBank {
    public static int maxScores(int[][] matrix) {
        int[] scores = new int[matrix.length];
        int max = 0;
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
            scores[i] = sum;
            if (max < scores[i]) {
                max = scores[i];
                res = i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] input = {"53424","15223","32521","14252","12315"};
        int[][] matrix = new int[5][5];
        for (int i = 0; i < input.length; i++) {
            String[] nums = input[i].split("");
            for (int j = 0; j < nums.length; j++) {
                matrix[j][i] = Integer.parseInt(nums[j]);
            }
        }
        System.out.println(maxScores(matrix));
    }
}