import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, String currentString, int open, int close, int max) {
        if (currentString.length() == max * 2) {
            result.add(currentString);
            return;
        }

        if (open < max) {
            backtrack(result, currentString + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, currentString + ")", open, close + 1, max);
        }
    }
    public static void main(String[] args) {
        GenerateParentheses_22 gp = new GenerateParentheses_22();
        int n = 3; // Number of pairs of parentheses
        List<String> combinations = gp.generateParenthesis(n);
        System.out.println("Generated Parentheses Combinations:");
        for (String s : combinations) {
            System.out.println(s);
        }
    }

}
