import java.util.Stack;

public class PostfixEvaluator {
    public static void main (String[] args) {

        //Create 6 String element
        String s1 = "1 2 +";
        String s2 = "3 4 -";
        String s3 = "5 7 *";
        String s4 = "10 1 %";
        String s5 = "2 9 /";
        String s6 = "7 8 + *";

        // loop through expressions
        for (String expr : expressions) {

            System.out.println("Expression: " + expr);

            int result = evaluatePostfix(expr);

            System.out.println("Result: " + result);

        }
    }

    // METHOD: evaluate postfix
    public static int evaluatePostfix(String expression) {

        Stack<Integer> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            // if number → push
            if (isNumber(token)) {

                int num = Integer.parseInt(token);
                stack.push(num);

                System.out.println("Pushed: " + num + " | Stack: " + stack);
            }

            // if operator → calculate
            else {

                if (stack.size() < 2) {
                    System.out.println("Error: Not enough operands");
                    return 0;
                }

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                switch (token) {

                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        if (b == 0) {
                            System.out.println("Error: Division by zero");
                            return 0;
                        }
                        result = a / b;
                        break;

                    case "%":
                        result = a % b;
                        break;

                    default:
                        System.out.println("Invalid operator: " + token);
                        return 0;
                }

                stack.push(result);

                System.out.println("Applied " + token + " -> Stack: " + stack);
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }

    // helper method
    public static boolean isNumber(String s) {

        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}