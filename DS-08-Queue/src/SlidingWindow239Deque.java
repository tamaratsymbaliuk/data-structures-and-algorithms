import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindow239Deque {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                result[resultIndex++] = nums[q.peekFirst()];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(SlidingWindow239Deque.maxSlidingWindow(nums, k)));

    }


}

