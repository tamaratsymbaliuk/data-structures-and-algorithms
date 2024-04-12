public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String result = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i >= 0; i--) {
            // Append the current word and a space to the output
            result += str[i] + " ";
            System.out.println(result);
        }

        // Append the first word to the output (without trailing space) +" " on line 12
        return result + str[0];
    }

    public static void main(String[] args) {
        String s = new String("  hello world   it's me ");
        Reverse_Words_in_a_String test = new Reverse_Words_in_a_String();
        System.out.println(test.reverseWords(s));
    }
}
