import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
    */

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 18;

        TwoSum test = new TwoSum();
        System.out.println(Arrays.toString(test.twoSum(nums, target)));

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> HT = new HashMap<>();

        // Time: O(N)
        // Space: O(N)

        for (int i = 0; i < nums.length; i++) { //  O(N)

            int complement = target - nums[i]; // nums[j] == target - nums[i], j < i
            if (HT.containsKey(complement)) { // O(1)
                return new int[] { HT.get(complement), i}; // O(1)
            }
            HT.put(nums[i], i); // insert key-value pair (key=nums[i], value=i) // O(1)
        }
        // in case there is no solution return null
        return null;

    }


}
