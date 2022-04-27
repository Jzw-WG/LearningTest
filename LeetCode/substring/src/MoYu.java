import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoYu {
    // x ÷ x =
    // x ÷ x =
    // xxx ÷ xx
    //将1-9不重复填入x中成立
    public void backtrack(boolean[] used, List<Integer> result, List<List<Integer>> results) {       
        if (result.size() == 9) {
            if ((double)result.get(0)/result.get(1) == (double)result.get(2)/result.get(3) 
            && (double)result.get(0)/result.get(1) == (double)(100*result.get(4) + 10*result.get(5) + result.get(6))/(10*result.get(7) + result.get(8))) {
                results.add(new ArrayList<>(result));
            }   
        }
        for (int i = 1; i <= 9; i++) {
            if (used[i]) {
                continue;
            } else {
                result.add(i);
                used[i] = true;
                backtrack(used, result,results);
                used[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }

    public void findAnwser() {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        boolean[] used = new boolean[10];
        Arrays.fill(used, false);
        backtrack(used, result, results);
        System.out.println(results);
    }
    public static void main(String[] args) {
        MoYu m = new MoYu();
        m.findAnwser();
    }
}