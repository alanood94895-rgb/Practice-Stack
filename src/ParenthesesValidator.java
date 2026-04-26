import java.util.Stack;

public class ParenthesesValidator {
    public static void main (String[] args){
        // Create the Stack
        Stack<String> ParenthesesValidator = new Stack<>();

        ParenthesesValidator.push("(((");
        ParenthesesValidator.push(")))");
        ParenthesesValidator.push("[[[]]]");
        ParenthesesValidator.push("]]]");
        ParenthesesValidator.push("{{{");

        System.out.println(ParenthesesValidator);

        if(isBalanced){

        }




    }

}
