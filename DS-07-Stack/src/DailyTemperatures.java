import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    // Approach 2: Array, Optimized Space
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        // Initially, all 0, stores distance between their next greater element and the current temperature
        int[] nge = new int[n]; //nge - next  greater example

        Stack<Integer> stack = new Stack<>();
        // move from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop until we find the next greather element to the right
            // (until temperaturs[stack.top()] > temperatures[i]).
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // If the stack is not empty, then we have some next greather element,
            // so we take the distance between the next greather and the current temperature.
            if (!stack.isEmpty()) {
                nge[i] = stack.peek() - i; // The distance between next greather and current
            }

            // Push the index of the current temperature in the stack
            stack.push(i);
        }
        return nge;

        // T: O(n)
        // S:  O(n)

    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures test = new DailyTemperatures();
        int[] result = test.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));

    }
}



