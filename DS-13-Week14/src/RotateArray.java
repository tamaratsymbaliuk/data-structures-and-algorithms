import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        reverse(nums, 2, 5);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            // swap(nums[start], nums[end])
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // Move to the next pair of numbers
            start++;
            end--;
        }
    }
}


