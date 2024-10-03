import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        int n = nums.length;

        for (int left = 0, right = n - 1; left < right; left++, right--) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
        }
        System.out.println(Arrays.toString(nums));
    }

}
