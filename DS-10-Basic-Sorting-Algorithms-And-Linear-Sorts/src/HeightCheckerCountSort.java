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
        }
        for (int i = 1, j = 0; i <= 100; i++) { //starting from i = 1 because student heights are generally positive integers, and the given problem assumes that the heights range from 1 to 100
            while (frequency[i] > 0) {
                sorted_copy[j] = i;
                frequency[i]--;
                j++;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (sorted_copy[i] != heights[i]) {
                answer++;
            }
        }
        return answer;
    }
}
