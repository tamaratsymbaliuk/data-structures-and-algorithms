public class HeightCheckerBubbleSort {
    // https://leetcode.com/problems/height-checker/description/

    /*
    Bubble Sort -
    Iterate over the array (possibly multiple times, up to [n - 1] times)
    if a[i] > a[i + 1]
    swap(a[i], a[i + 1]
    swapped = true
    After iterating over the array, check swapped
    If swapped is true, iterate over the array again
    else
    stop the algorithm, array is sorted

    Time: (worst case): O? decreasing order [5,4,3,2,1], So O(n) passes in the worst case, each pass
    takes O(n - 1) passes through the array, hence O(n^2) time complexity; after the first iteration the largest 5 is guaranteed to go to the end[4,3,2,1,5] and so on
    Space: (worst case): note that we don't need to create a sorted_copy in normal case
    in general, O(1) constant space complexity - only 3 variables

    Best case (Time): O(n). increasing order, it will do a single pass and break out of the while loop
    Best case (Space):O (1)
     */
    public static void main(String[] args) {
        HeightCheckerBubbleSort test = new HeightCheckerBubbleSort();
        int[] array = {1,1,4,2,1,3};
        System.out.println(test.heightChecker(array));
    }

    public int heightChecker(int[] heights) {
        int n = heights.length;

        int[] sorted_copy = new int[n];
        for (int i = 0; i < n; i++) {
            sorted_copy[i] = heights[i];
        }
        boolean swapped;
        while (true) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (sorted_copy[i] > sorted_copy[i + 1]) {
                    swap(sorted_copy, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) { // the array is sorted
                break;
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

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
