import java.util.Stack;

public class InfixToPostfixConverter {
    public static void main(String[] args){

        // 8 different infix expressions
        String[] expressions = {
                "3 + 4 * 2",
                "(1 + 2) * 3",
                "10 + 2 * 6",
                "100 * ( 2 + 12 ) / 14",
                "5 + ((1 + 2) * 4) - 3",
                "7 + 8 * (3 - 2)",
                "12.5 + 3.5 * 2",
                "20 / (5 - 5)"

        };
        for (String infix : expressions) {
            System.out.println("Infix: " + infix);

            String postfix = infixToPostfix(infix);
            System.out.println("Final Postfix: " + postfix);
            double result = PostfixEvaluator.evaluatePostfix(postfix);
            System.out.println("Result: " + result);

            System.out.println("Error: " + e.getMessage());
        }

        }
        // infixToPostfix
        public static String infixToPostfix(String infix) {

            Stack<Character> ops = new Stack<>();
            StringBuilder output = new StringBuilder();

            System.out.println("\nStep-by-step:");

            for (int i = 0; i < infix.length(); i++) {

                char ch = infix.charAt(i);

                // HANDLE NUMBERS
                if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder number = new StringBuilder();

                    while (i < infix.length() &&
                            (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                        number.append(infix.charAt(i));
                        i++;
                    }

                    output.append(number).append(" ");
                    i--; // adjust index
                }
                else if (ch == '(') {
                    ops.push(ch);
                }

                // HANDLE ')'
                else if (ch == ')') {
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        output.append(ops.pop()).append(" ");
                    }

                    if (ops.isEmpty())
                        throw new RuntimeException("Unmatched parentheses");

                    ops.pop(); // remove '('

                    else if (isOperator(ch)) {
                        while (!ops.isEmpty() &&
                                ops.peek() != '(' &&
                                precedence(ops.peek()) >= precedence(ch)) {

                            output.append(ops.pop()).append(" ");
                        }

                        ops.push(ch);
                    }
                    else {
                        throw new RuntimeException("Invalid character: " + ch);
                    }

                    // PRINT STEP
                    System.out.println("Token: " + ch);
                    System.out.println("Stack: " + ops);
                    System.out.println("Output: " + output);
                    System.out.println("-------------------");
                }

                // POP REMAINING OPERATORS
                while (!ops.isEmpty()) {
                    if (ops.peek() == '(')
                        throw new RuntimeException("Unmatched parentheses");

                    output.append(ops.pop()).append(" ");
                }

                return output.toString().trim();
            }
                }

            }
}
