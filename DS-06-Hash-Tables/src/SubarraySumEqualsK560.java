import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
    /*Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        SubarraySumEqualsK560 test = new SubarraySumEqualsK560();
        System.out.println(test.subarraySum(nums, k));
    }
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        int pref_sum_i = 0;

        Map<Integer, Integer> HT = new HashMap<>();
        HT.put(0,1); // single empty subarray in the beginning
        for (int i = 0; i < nums.length; i++) {
            pref_sum_i += nums[i];
            if (HT.containsKey(pref_sum_i - k)) {
                answer += HT.get(pref_sum_i - k);
            }
            // either add (pref_sum_i, 1) to hash table
            // or make it (pref_sum_i, existing_value + 1)
            HT.put(pref_sum_i, HT.getOrDefault(pref_sum_i, 0) + 1);
        }
        return answer;
    }
}
