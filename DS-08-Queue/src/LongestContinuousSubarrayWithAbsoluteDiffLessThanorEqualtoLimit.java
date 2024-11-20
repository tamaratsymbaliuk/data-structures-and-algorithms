import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain the maxDeque in descreasing order
            // Maintain the minDeque in increasing order
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) maxDeque.pollLast();
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) minDeque.pollLast();

            maxDeque.offerLast(nums[right]);
            minDeque.offerLast(nums[right]);

            // Check if the current window exceeds the limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Remove the elements that are out of the current window
                if (maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;

    }

    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
    }
}
