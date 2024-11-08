import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarraywithSumatLeastK862 {
    //https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
    // solution https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/solutions/143726/c-java-python-o-n-using-deque/

    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        int res = N + 1;  // Initialize result as a large number (larger than any possible subarray length)
        long[] prefixSum = new long[N + 1];  // Array to store prefix sums

        // Compute prefix sums
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();  // Deque to maintain indices of prefix sums
        for (int i = 0; i < N + 1; i++) {
            // Check if the current prefix sum minus the smallest prefix sum seen so far is at least k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }

            // Remove elements from the deque that are not useful
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.pollLast();
            }

            // Add current index to the deque
            deque.addLast(i);
        }

        return res <= N ? res : -1;  // Return the length of the shortest subarray or -1 if not found
    }

    public static void main(String[] args) {

        ShortestSubarraywithSumatLeastK862 solution = new ShortestSubarraywithSumatLeastK862();
         /*
        int[] nums = {2, -1, 2};
        int k = 3;
        System.out.println(solution.shortestSubarray(nums, k));  // Output: 3
         */

        int[] nums2 = {2, 2, 1, 1, 1, 1};
        int k2 = 4;
        System.out.println(solution.shortestSubarray(nums2, k2));  // Output: -1
    }

}
