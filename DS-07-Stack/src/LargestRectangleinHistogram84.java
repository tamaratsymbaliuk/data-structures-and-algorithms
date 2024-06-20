import java.util.Stack;

public class LargestRectangleinHistogram84 {
    // https://leetcode.com/problems/largest-rectangle-in-histogram/description/
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int[] lessFromLeft = new int[n]; // Index of the first bar to the left that is lower than current
        int[] lessFromRight = new int[n]; // Index of the first bar to the right that is lower than current
        lessFromRight[n - 1] = n;
        lessFromLeft[0] = -1;

        // Calculate lessFromLeft using a stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            lessFromLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack to reuse for lessFromRight
        stack.clear();

        // Calculate lessFromRight using a stack
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            lessFromRight[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}
