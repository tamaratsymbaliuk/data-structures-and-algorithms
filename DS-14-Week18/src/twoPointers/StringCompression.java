package twoPointers;

public class StringCompression {
    public int compress(char[] chars) {

        int n = chars.length;

        int streakStart = 0; // beginning of the next streak
        int indexAnswer = 0;
        while (streakStart < n) {
            // Current streak starts with chars[streakStart]
            char streakChar = chars[streakStart];

            // steakStart and streakend are the two pointers. This is a common technique
            int streakEnd = streakStart;

            // Count how many consecutive streakChar-s there are in this streak
            int count = 1;
            while (streakEnd + 1 < n && chars[streakEnd + 1] == streakChar) {
                streakEnd++;
                count++;
            }
            // if count == 1 -> then we should write in 'chars' just the 'streakChar'
            // else -> then we should write in 'chars' the 'streakChar' followed by the integer 'count'
            chars[indexAnswer] = streakChar;
            indexAnswer++;

            if (count > 1) {
                char[] countAsChars = Integer.toString(count).toCharArray();
                for (char digit : countAsChars) {
                    chars[indexAnswer] = digit;
                    indexAnswer++;
                }
            }
            streakStart = streakEnd + 1;
        }
        return indexAnswer;

    }
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        StringCompression test = new StringCompression();

        System.out.println(test.compress(chars));
    }
}
