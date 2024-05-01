import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsOfArrays {

    //How many subsets ? 2^n
    //Time complexity: 2^n * O(n) -> O(n 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(tempList)); ////O(n)    n+n =O(n)
            return;
        }
        // Skip nums[index], don't add it to tempList
        backtrack(list, tempList, nums, index + 1);

        // Add nums[index] to current subset and generate all of the possible subsets with numbers nums[index+1...nums.lenth-1]
        // where nums[index] is present
        tempList.add(nums[index]); //O(1)
        backtrack(list, tempList, nums, index + 1); ///O(1)
        tempList.remove(tempList.size() - 1); //O(1)
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};

        SubsetsOfArrays test = new SubsetsOfArrays();
        test.subsets(nums);

    }



}
