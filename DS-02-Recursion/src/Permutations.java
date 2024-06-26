import java.util.ArrayList;
import java.util.List;


//Time: (n!) * n
//Space O(n)
public class Permutations {
    /*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;

    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){

        // If we match the length, it is a permutation
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        // iterate over each character
        for (int number : nums){

            // Skip if we get the same element
            if (tempList.contains(number))
                continue;

            // Add the new element
            tempList.add(number);

            // Go back to try other element
            backtrack(resultList, tempList, nums);

            // Remove the element
            tempList.remove(tempList.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Permutations test = new Permutations();
        List<List<Integer>> result = test.permute(nums);
        System.out.println("Permutations: " + result);

    }
}
