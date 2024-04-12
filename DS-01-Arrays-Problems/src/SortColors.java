import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r;)
            if (nums[i] == 0)
                swap(nums, i++, l++);
            else if (nums[i] == 1)
                ++i;
            else
                swap(nums, i, r--);
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        SortColors test = new SortColors();
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
