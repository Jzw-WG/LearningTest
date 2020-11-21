import java.util.ArrayList;
import java.util.List;

class CombinationsOfSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList();
        List<Integer> combination = new ArrayList();
        // Arrays.sort(candidates);
        dfs(candidates, target, combinations, combination, 0, 0); 
        return combinations;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> combinations, List<Integer> combination, int sum, int index) {
        if (index == candidates.length) {
            return;
        }
        if (sum == target) {
            combinations.add(new ArrayList<Integer>(combination));
            // sum = 0;
            return;
        } 
        // combination.remove(combination.size() - 1);
        dfs(candidates, target, combinations, combination, sum, index + 1);           
        if (sum < target) {
            combination.add(candidates[index]);
            dfs(candidates, target, combinations, combination, sum + candidates[index], index);
            combination.remove(combination.size() - 1);
        }
        
    }

    public static void main(String[] args) {
        List<List<Integer>> combinations = new ArrayList<>();
        CombinationsOfSum l = new CombinationsOfSum();
        int[] candidates = {2,3,5,7};
        int target = 7;
        combinations = l.combinationSum(candidates, target);
        System.out.println(combinations);
    }
}