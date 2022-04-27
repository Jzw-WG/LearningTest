import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Tengxun3 {
    public static int calplusatx(String s) {
        if (s.indexOf("+") == -1) {
            return calatx(s);
        }
        String[] ss = s.split("+");
        int res = 0;
        for (int i = 0; i < ss.length; i++) {
            res += calatx(ss[i]);
        }
        return res;
    }

    public static int calatx(String s) {
        if (s.indexOf("x") == -1) {
            return calat(s);
        }
        String[] ss = s.split("x");
        int res = 0;
        for (int i = 0; i < ss.length; i++) {
            res += calatx(ss[i]);
        }
        return res;
    }

    public static int calat(String s) {
        if (s.indexOf("@") == -1) {
            return Integer.parseInt(s);
        }
        String[] ss = s.split("@");
        int[] nums = new int[ss.length];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
            
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res | (res + nums[i]);
            
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String content = null;
        // String s = br.readLine().trim();
        String s = "10+2@1x2";
        System.out.println(calplusatx(s));
    }

}