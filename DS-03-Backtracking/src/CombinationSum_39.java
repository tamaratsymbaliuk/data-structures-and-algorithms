import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum_39 test = new CombinationSum_39();
        List<List<Integer>> results = test.combinationSum(candidates, target);
        System.out.println(results);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentCombination, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            results.add(new ArrayList<>(currentCombination));
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentCombination.add(candidates[i]);
                backtrack(results, currentCombination, candidates, remain - candidates[i], i); // not i + 1 because we can reuse same elements
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
