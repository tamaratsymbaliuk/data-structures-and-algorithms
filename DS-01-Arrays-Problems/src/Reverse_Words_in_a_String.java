public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String result = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            result += str[i] + " ";
            //System.out.println(result);
        }

        // Append the first word to the output (without trailing space) +" " on line 12
        return result + str[0];
    }

    public String reverseWordsNoStringMethods(String s) {

        char[] str  = s.toCharArray();
        char[] result = new char[s.length()+1];


        //initialize pointer starting from the end of the string
        int l =  s.length() - 1;
        //used to mark the end of a word
        int j;
        //track current position in the result array
        int k = 0;

        while(l>=0){
            //trimming trailing spaces and moving to the last character of the last word
            while(l>=0 && str[l] == ' '){
                l--;
            }
            if(l<0) break;
            j = l;
            while(l>=0 && str[l]!=' '){
                l--;
            }
            for(int i = l+1;i<=j;i++){
                result[k++] = str[i];
            }
            result[k++] = ' ';

        }
        return new String(result, 0 ,k-1);
    }

    public static void main(String[] args) {
        String s = new String("  hello world   it's me ");
        Reverse_Words_in_a_String test = new Reverse_Words_in_a_String();
        System.out.println(test.reverseWords(s));
        System.out.println(test.reverseWordsNoStringMethods(s));
    }
}
