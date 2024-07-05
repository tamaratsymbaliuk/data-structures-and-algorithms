public class HeightCheckerCountSort {

    // Count Sort
    public static void main(String[] args) {
        HeightCheckerCountSort test = new HeightCheckerCountSort();
        int[] array = {1,1,4,2,1,3};
        System.out.println(test.heightChecker(array));
    }

    public int heightChecker(int[] heights) {
        int n = heights.length;

        int[] sorted_copy = new int[n];
        for (int i = 0; i < n; i++) {
            sorted_copy[i] = heights[i];
        }

        int[] frequency = new int[101]; // indices 0...100
        for (int i = 0; i < n; i++) {
            frequency[sorted_copy[i]]++;
            // i = 0; sorted_copy[i] = 1;
            //frequency[1]++;
            // same as frequency[1] = frequency[1] + 1; and so on
            // frequency becomes = {0, 1, 0, 0, 0, ..., 0}
            // Example: [1,1,4,2,1,3]
            // frequency[0..100]
            // frequency[1] = 3
            // frequency[2] = 1
            // frequency[3] = 1
            // frequency[4] = 1
            // frequency[5..100] = 0
        }
        for (int i = 1, j = 0; i <= 100; i++) { //starting from i = 1 because student heights are generally positive integers, and the given problem assumes that the heights range from 1 to 100 O(m)
            while (frequency[i] > 0) { // in total, over all iterations of the for loop, the body of the while loop will execute O(n) times
                sorted_copy[j] = i; // put the very first number
                frequency[i]--; // decrease it's frequency by one
                j++; // move to the next element
            }
        }
        // In the second loop:
        // * i = 1
        // * frequency[1] (3) > 0 - > true
        //  * sorted_cope[0] = 1
        //  * frequency[1]--; (becomes 2)
        //  * j++; (becomes 1)
        // * frequency[1] (2) > 0 - > true
        //  * sorted_copy[1] = 1
        //  * frequency[1]--; (becomes 1)
        //  * j++; (becomes 2)
        // * frequency[1] (1) > 0 - > true
        //  * sorted_copy[2] = 1
        //  * frequency[1]--; (becomes 0)
        //  * j++; (becomes 3)
        // * frequency[1] (0) > 0 - > false
        // * move to i = 2
        // * frequency[2] (1) > 0 - > true
        // * ...

        // Time complexity: O(n + m)
        // Space complexity: O(m)


        // let m = max_possible_value - min_possible_value + 1
        // so we need at least O(m) space if we create a frequency array
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (sorted_copy[i] != heights[i]) {
                answer++;
            }
        }
        return answer;
    }
}
