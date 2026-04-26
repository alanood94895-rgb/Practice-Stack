import java.util.Stack;

public class ParenthesesValidator {
    public static void main(String[] args) {
        // Create the Stack
        Stack<String> ParenthesesValidator = new Stack<>();

        ParenthesesValidator.push("(((");
        ParenthesesValidator.push(")))");
        ParenthesesValidator.push("[[[]]]");
        ParenthesesValidator.push("]]]");
        ParenthesesValidator.push("{{{");

        for (int i = 0; i < ParenthesesValidator.size(); i++) {
            boolean check = isBalanced(ParenthesesValidator.get(i));
            System.out.println(check);
        }
    }

    public static boolean isBalanced(String str) {
        Stack<ParenthesesValidator> Stack = new Stack<>();
        for (int i = 0; i < Stack.size(); i++) {


        }
    }
}












