public class Sort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        SortArray912_CountingSort test = new SortArray912_CountingSort();
        for (int i : test.sortArray(nums)) {
            System.out.println(i + " ");
        }

    }

    public int[] sortArray(int[] nums) {

        int[] freq = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 50000;
        }
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
         for (int i = 1, j = 0; i <=100000; i++ ) {
             while (freq[i] > 0) {
                 nums[j] = i;
                 freq[i]--;
                 j++;
             }
         }
         for (int i = 0; i < nums.length; i++) {
             nums[i] -= 50000;
         }
        return nums;
    }
}
