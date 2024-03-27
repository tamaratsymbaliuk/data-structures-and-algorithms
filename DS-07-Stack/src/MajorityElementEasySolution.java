import java.util.Arrays;

public class MajorityElementEasySolution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

    public static void main(String[] args) {

        MajorityElementEasySolution solution = new MajorityElementEasySolution();

        int[] nums = {3, 2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + solution.majorityElement(nums));

    }
}
