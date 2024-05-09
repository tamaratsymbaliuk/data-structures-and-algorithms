import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestSubsequenceSum_1755 {
    /* 1.Divide and Conquer: Split the array nums into two halves.
2.Generate Subsets' Sums: For each half, generate all possible sums of subsequences (including the empty subsequence).
3.Sort and Two-Pointer Technique or Binary Search: After generating possible sums for both halves, sort these sums. Then, for each sum in the first half, use binary search or a two-pointer technique to find the sum in the second half that when combined, is closest to the goal.
4.Minimize the Absolute Difference: Track the minimum difference between these combined sums and the goal.*/

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int h = n / 2;
        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();

        generateSums(Arrays.copyOfRange(nums, 0, h), leftSums);
        generateSums(Arrays.copyOfRange(nums, h, n), rightSums);

        Collections.sort(rightSums);

        int minDiff = Integer.MAX_VALUE;
        for (int sum : leftSums) {
            int target = goal - sum;
            int idx = Collections.binarySearch(rightSums, target);
            if (idx < 0) idx = -(idx + 1);

            if (idx < rightSums.size()) minDiff = Math.min(minDiff, Math.abs(goal - (sum + rightSums.get(idx))));
            if (idx > 0) minDiff = Math.min(minDiff, Math.abs(goal - (sum + rightSums.get(idx - 1))));
        }

        return minDiff;
    }

    private void generateSums(int[] nums, List<Integer> sums) {
        sums.add(0); // Include the empty subsequence
        for (int num : nums) {
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                sums.add(sums.get(i) + num);
            }
        }
    }

    public static void main(String[] args) {
        ClosestSubsequenceSum_1755 solution = new ClosestSubsequenceSum_1755();
        int[] nums = {5, -7, 3, 5};
        int goal = 6;
        System.out.println("Minimum Absolute Difference: " + solution.minAbsDifference(nums, goal));
    }


}




