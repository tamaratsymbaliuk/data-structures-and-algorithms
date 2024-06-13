import java.util.Stack;

public class MajorityElement169 {
    /*
    https://leetcode.com/problems/majority-element/description/
     */
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] == stack.peek()) { // stack.peek() - Look at the top element of the stack without removing it
                stack.push(nums[i]);
            } else if (nums[i] != stack.peek()) {
                stack.pop();
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        MajorityElement169 solution = new MajorityElement169();
        int[] nums = { 2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + solution.majorityElement(nums));  // Output: Majority Element: 2
    }
}
