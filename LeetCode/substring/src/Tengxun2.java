import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Tengxun2 {
    // public static void maxNUm(int[] input) {
    //     int max = 0;
    //     for (int i = 0; i < input.length; i++) {
    //         int index = i;
    //         int res = 0;
    //         while (index < input.length) {
    //             res += input[index];
    //             index += input[index];
    //         }
    //         max = Math.max(max, res);
    //     }
    //     System.out.println(max);
    // }

    public static void maxNUm(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            int res = maxNUm(input, i, 0, map);
            max = Math.max(max, res);
        }
        System.out.println(max);
    }

    public static int maxNUm(int[] input, int start, int sum, HashMap<Integer, Integer> map) {
        if (map.containsKey(start)) {
            return map.get(start) + sum;
        }
        if (start + input[start] >= input.length) {
            map.put(start, sum + input[start]);
            return sum + input[start];
        }
        return maxNUm(input, start + input[start], sum + input[start], map);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content = null;
        int t = Integer.parseInt(br.readLine().trim());

        int row = 0;
        while ((row < t) && (content = br.readLine()) != null) {
            int n = Integer.parseInt(content.trim());
            content = br.readLine();
            int[] input = new int[n];
            String[] strs = content.trim().split(" ");
            for (int i = 0; i < strs.length; i++) {
                input[i] = Integer.parseInt(strs[i]);
            }
            
            maxNUm(input);
            row++;
        }
    }

}