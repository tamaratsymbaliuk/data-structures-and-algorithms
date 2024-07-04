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
        }
        for (int i = 1, j = 0; i <= 100; i++) {
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
