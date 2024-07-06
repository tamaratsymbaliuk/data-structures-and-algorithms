import java.util.Arrays;

public class ArrayPartition561 {
    //https://leetcode.com/problems/array-partition/description/

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i+=2) {
            result += Math.min(nums[i], nums[i + 1]);
        }
        return result;

    }
}
