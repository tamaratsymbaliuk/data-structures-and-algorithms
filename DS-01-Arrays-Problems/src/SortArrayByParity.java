public class SortArrayByParity {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;

        while (i < n && j < n) {
            // Find the next odd integer at an even position
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            // Find the next even integer at an odd position
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }

            // If both found, swap them
            if (i < n && j < n) {
                swap(nums, i, j);
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
