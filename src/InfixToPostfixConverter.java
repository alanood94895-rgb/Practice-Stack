import java.util.Stack;

public class InfixToPostfixConverter {

    public static void main(String[] args) {

        String[] expressions = {
                "3+4*2",
                "(1+2)*3",
                "10+2*6",
                "100*(2+12)/14",
                "5+((1+2)*4)-3",
                "7+8*(3-2)",
                "12.5+3.5*2",
                "20/(5-5)" // division by zero case
        };

        for (String infix : expressions) {
            System.out.println("\n==============================");
            System.out.println("Infix: " + infix);

            String postfix = infixToPostfix(infix);

            if (postfix.equals("ERROR")) {
                System.out.println("Conversion failed.");
                continue;
            }

            System.out.println("Postfix: " + postfix);

            double result = evaluatePostfix(postfix);

            if (result == Double.MIN_VALUE) {
                System.out.println("Evaluation failed.");
            } else {
                System.out.println("Result: " + result);
            }
        }
    }

    // INFIX → POSTFIX
    public static String infixToPostfix(String infix) {

        Stack<Character> ops = new Stack<>();
        StringBuilder output = new StringBuilder();

        System.out.println("\nStep-by-step:");

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            // NUMBER (multi-digit + decimal)
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder number = new StringBuilder();

                while (i < infix.length() &&
                        (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    number.append(infix.charAt(i));
                    i++;
                }

                output.append(number).append(" ");
                i--;
            }

            // '('
            else if (ch == '(') {
                ops.push(ch);
            }

            // ')'
            else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    output.append(ops.pop()).append(" ");
                }

                if (ops.isEmpty()) {
                    System.out.println("Error: Unmatched parentheses");
                    return "ERROR";
                }

                ops.pop(); // remove '('
            }

            // OPERATOR
            else if (isOperator(ch)) {
                while (!ops.isEmpty() &&
                        ops.peek() != '(' &&
                        precedence(ops.peek()) >= precedence(ch)) {

                    output.append(ops.pop()).append(" ");
                }

                ops.push(ch);
            }

            // INVALID CHARACTER
            else {
                System.out.println("Error: Invalid character -> " + ch);
                return "ERROR";
            }

            // PRINT STEP
            System.out.println("Token: " + ch);
            System.out.println("Stack: " + ops);
            System.out.println("Output: " + output);
            System.out.println("-------------------");
        }

        // POP REMAINING OPERATORS
        while (!ops.isEmpty()) {
            if (ops.peek() == '(') {
                System.out.println("Error: Unmatched parentheses");
                return "ERROR";
            }

            output.append(ops.pop()).append(" ");
        }

        return output.toString().trim();
    }

    // EVALUATE POSTFIX
    public static double evaluatePostfix(String postfix) {

        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {

            // NUMBER
            if (token.matches("\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            }

            // OPERATOR
            else if (token.length() == 1 && isOperator(token.charAt(0))) {

                if (stack.size() < 2) {
                    System.out.println("Error: Invalid expression");
                    return Double.MIN_VALUE;
                }

                double b = stack.pop();
                double a = stack.pop();

                // DIVISION BY ZERO CHECK
                if (token.charAt(0) == '/' && b == 0) {
                    System.out.println("Error: Division by zero");
                    return Double.MIN_VALUE;
                }

                double result = applyOperation(a, b, token.charAt(0));
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            System.out.println("Error: Invalid postfix expression");
            return Double.MIN_VALUE;
        }

        return stack.pop();
    }

    // PRECEDENCE
    public static int precedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/' || op == '%') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    // CHECK OPERATOR
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' ||
                ch == '/' || ch == '%' || ch == '^';
    }

    // APPLY OPERATION
    public static double applyOperation(double a, double b, char op) {

        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        if (op == '/') return a / b;
        if (op == '%') return a % b;
        if (op == '^') return Math.pow(a, b);

        return 0;
    }
}