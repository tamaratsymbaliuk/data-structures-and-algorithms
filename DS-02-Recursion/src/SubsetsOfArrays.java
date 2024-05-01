import java.util.ArrayList;
import java.util.List;

public class SubsetsOfArrays {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        backtrack(list, tempList, nums, index + 1);

        tempList.add(nums[index]);
        backtrack(list, tempList, nums, index + 1);
        tempList.remove(tempList.size() - 1);
    }

}
