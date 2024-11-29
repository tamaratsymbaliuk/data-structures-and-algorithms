import java.util.HashMap;
import java.util.Map;

public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public static void main(String[] args) {
        String word1 = "aaaa";
        String word2 = "bccb";
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {

        Map<Character, Integer> wordFr1 = new HashMap<>();
        Map<Character, Integer> wordFr2 = new HashMap<>();

        for (char w : word1.toCharArray()) {
            wordFr1.put(w, wordFr1.getOrDefault(w, 0) + 1);
        }

        for (char w : word2.toCharArray()) {
            wordFr2.put(w, wordFr2.getOrDefault(w, 0) + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int freq1 = wordFr1.getOrDefault(c, 0);
            int freq2 = wordFr2.getOrDefault(c,0);
            if (Math.abs(freq1 - freq2) > 3) {
                return false;
            }
        }
        return true;
    }
}
