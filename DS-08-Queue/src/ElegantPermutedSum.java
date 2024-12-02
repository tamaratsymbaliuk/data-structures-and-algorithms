import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ElegantPermutedSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.printf("%d %d\n", number / 10, number % 10);

        int[] nums = {1, 3, 5, 2, 4}; // Example input array
        ElegantPermutedSum eps = new ElegantPermutedSum();
        int result = eps.solution(nums);
        System.out.println("Result: " + result);
    }

    public int solution(int[] nums) {

        Arrays.sort(nums);
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int n = nums.length;
        for (int i = 0; i < n / 2; ++i) {
            minDeque.offerLast(nums[i]);
            maxDeque.offerLast(nums[n - i - 1]);
        }
        // If the array has an odd length, add the middle element to minDeque
        if (n % 2 == 1) {
            minDeque.offerLast(nums[n / 2]);
        }

        int maxSum = maxDeque.stream().mapToInt(Integer::intValue).sum();
        int minSum = minDeque.stream().mapToInt(Integer::intValue).sum();

        return maxSum - minSum;
    }
}
