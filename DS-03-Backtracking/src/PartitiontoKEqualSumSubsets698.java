import java.util.Arrays;

public class PartitiontoKEqualSumSubsets698 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        PartitiontoKEqualSumSubsets698 test = new PartitiontoKEqualSumSubsets698();

        boolean result = test.canPartitionKSubsets(nums, k);
        System.out.println(result);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        // k -  how many subsets still left to generate
        return backtrack(nums, k, 0, 0, used, sum / k);
    }

    boolean backtrack(int[] nums, int k, int currSum, int idx, boolean[] used, int target) {
        if (k == 1) {
            // If only one subset is left, no need to continue; remaining numbers form the last subset
            return true;
        }
        if (currSum == target) {
            // Current subset is complete; move on to the next subset
            return backtrack(nums, k - 1, 0, 0, used, target);
        }
        for (int i = idx; i < nums.length; i++) {
            // Skip used numbers or duplicates to avoid redundant work
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            // If adding nums[i] doesn't exceed the target and leads to a solution, return true
            if (currSum + nums[i] <= target && backtrack(nums, k, currSum + nums[i], i + 1, used, target)) {
                return true;
            }
            // Backtrack: unmark the number as used
            used[i] = false;
        }

        return false;
    }
}
