import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ElegantPermutedSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.printf("%d %d\n", number/10, number%10);
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
    }
}

