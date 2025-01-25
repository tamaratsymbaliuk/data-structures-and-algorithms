import java.util.Random;

public class SortArray912_CountingSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        SortArray912_CountingSort test = new SortArray912_CountingSort();
        for (int i : test.sortArray(nums)) {
            System.out.println(i + " ");
        }
    }
    public int[] sortArray(int[] nums) {
        // Counting Sort

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += 50000; // each number will be from 0 to 100,000
        }

        int[] frequency = new int[100001]; // indices 0...100,000
        for (int i = 0; i < n; i++) {
            frequency[nums[i]]++;
        }
        for (int i = 1, j = 0; i <= 100000; i++) {
            while (frequency[i] > 0) {
                nums[j] = i;
                frequency[i]--;
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] -= 50000;
        }
        return nums;
    }
}
