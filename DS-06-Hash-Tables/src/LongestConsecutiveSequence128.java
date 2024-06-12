import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    /*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
     */

    // T: O(n)
    // This approach ensures O(n) time complexity because each element is processed a constant number of times.

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence128 test = new LongestConsecutiveSequence128();
        System.out.println(test.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int answer = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) { // only walk starting from the beginning of a streak, finds the smallest element
                int i = x + 1; // Initializes i to the next integer after x.
                while (set.contains(i)) {
                    i++;
                }
                answer = Math.max(answer, i - x);
            }
        }
        return answer;


    }
}

