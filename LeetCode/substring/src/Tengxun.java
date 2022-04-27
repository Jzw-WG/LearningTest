import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tengxun {
    public static void minQ(int[] input) {
        
        for (int i = 0; i < input.length; i++) {
            int minq = 1;
            int x = input[i];
            int first = primeLargerThanN(minq + x);
            int second = primeLargerThanN(first + x);
            int res = first * second;
            System.out.println(res);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content = null;
        int t = Integer.parseInt(br.readLine().trim());
        int row = 0;
        int[] input = new int[t];
        while ((row < t) && (content = br.readLine()) != null) {
            String str = content.trim();
            input[row] = Integer.parseInt(str);
            row++;
        }
        minQ(input);
    }

    public static int primeLargerThanN(int n) {
        for (int i = n; ; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}