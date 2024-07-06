public class SortAnArray912 {

    // https://leetcode.com/problems/sort-an-array/description/

    public int[] sortArray(int[] nums) {
        // Count Sort

    int n = nums.length;
    for (int i = 0; i < n; i++) {
        nums[i] += 50000; // doing this as we can't count negative indices, and the problem states -5 * 104 <= nums[i] <= 5 * 104
    }

    int[] frequency = new int[100001]; // indices 0...100000
        for (int i = 0; i < n; i++) {
        frequency[nums[i]]++;
    }
        for (int i = 1, j = 0; i <= 100000; i++) { //starting from i = 1 because student heights are generally positive integers, and the given problem assumes that the heights range from 1 to 100 O(m)
        while (frequency[i] > 0) { // in total, over all iterations of the for loop, the body of the while loop will execute O(n) times
            nums[j] = i; // put the very first number
            frequency[i]--; // decrease it's frequency by one
            j++; // move to the next element
        }
    }

        for (int i = 0; i < n; i++) {
            nums[i] -= 50000;
        }
        return nums;
}
}

