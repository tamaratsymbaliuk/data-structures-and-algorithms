import java.util.Random;

public class QuickSort {

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] arr, int left, int right) {

        if( left >= right) {
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(left, right + 1); // right + 1 not inclusive
        swap(arr, left, randomIndex);

        int pivot = arr[left];
        int storeIndex = left + 1;
        for (int i = storeIndex; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, left, storeIndex - 1);
        // int leftBoundary = storeIndex - 2; // adding leftBoundary and rightBoundary variables significantly increases the runtime
        //  while (leftBoundary >= 0 && arr[leftBoundary] == pivot) leftBoundary--;
        quickSort(arr, left, storeIndex - 2);
        //  int rightBoundary = storeIndex;
        // while (rightBoundary <= right && arr[rightBoundary] == pivot) rightBoundary++;
        quickSort(arr, storeIndex, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        QuickSort test = new QuickSort();
        test.sortArray(nums);

    }
}

