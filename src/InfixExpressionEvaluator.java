import java.util.Stack;

public class InfixExpressionEvaluator {

    public static void main(String[] args) {

        String[] expressions = {
                "3+4*2",
                "(1+2)*3",
                "10+2*6",
                "100*(2+12)/14",
                "5+((1+2)*4)-3",
                "7+8*(3-2)",
                "12.5+3.5*2",
                "20/(5-5)",
                "2^3+1",
                "9%4+2",
                "6+2*3-4",
                "8*(2+3*(1+1))"
        };

        for (String exp : expressions) {
            System.out.println("Expression: " + exp);

            double result = evaluate(exp);

            if (result == Double.MIN_VALUE) {
                System.out.println("Evaluation failed.");
            } else {
                System.out.println("Result: " + result);
            }
        }
    }

    // MAIN EVALUATION METHOD
    public static double evaluate(String expression) {

        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        System.out.println("Step-by-step:");

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // HANDLE NUMBER
            if (isNumber(ch)) {

                StringBuilder num = new StringBuilder();

                while (i < expression.length() && isNumber(expression.charAt(i))) {
                    num.append(expression.charAt(i));
                    i++;
                }

                double value = Double.parseDouble(num.toString());
                operandStack.push(value);
                i--;

                System.out.println("Push number: " + value);
            }

            else if (ch == '(') {
                operatorStack.push(ch);
                System.out.println("Push operator: (");
            }

            else if (ch == ')') {

                while (operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    if (!processTop(operandStack, operatorStack)) return Double.MIN_VALUE;
                }

                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();
                }
            }

            // OPERATOR
            else if (isOperator(ch)) {

                while (!operatorStack.isEmpty() &&
                        operatorStack.peek() != '(' &&
                        getPrecedence(operatorStack.peek()) >= getPrecedence(ch)) {

                    if (!processTop(operandStack, operatorStack)) return Double.MIN_VALUE;
                }

                operatorStack.push(ch);
                System.out.println("Push operator: " + ch);
            }

            else {
                System.out.println("Invalid character: " + ch);
                return Double.MIN_VALUE;
            }

            displayStacks(operandStack, operatorStack);
        }

        while (!operatorStack.isEmpty()) {
            if (!processTop(operandStack, operatorStack)) return Double.MIN_VALUE;
        }

        if (operandStack.size() != 1) {
            System.out.println("Invalid expression");
            return Double.MIN_VALUE;
        }

        return operandStack.pop();
    }

    public static boolean processTop(Stack<Double> operands, Stack<Character> operators) {

        if (operands.size() < 2) {
            System.out.println("Invalid expression");
            return false;
        }

        double b = operands.pop();
        double a = operands.pop();
        char op = operators.pop();

        if (op == '/' && b == 0) {
            System.out.println("Division by zero");
            return false;
        }

        double result = applyOperation(a, b, op);
        operands.push(result);

        System.out.println("Apply: " + a + " " + op + " " + b + " = " + result);

        return true;
    }

    public static double applyOperation(double a, double b, char op) {

        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        if (op == '/') return a / b;
        if (op == '%') return a % b;
        if (op == '^') return Math.pow(a, b);

        return 0;
    }

    public static int getPrecedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/' || op == '%') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' ||
                ch == '/' || ch == '%' || ch == '^';
    }

    public static boolean isNumber(char ch) {
        return Character.isDigit(ch) || ch == '.';
    }

    public static void displayStacks(Stack<Double> operands, Stack<Character> operators) {

        System.out.println("Operands:  " + operands);
        System.out.println("Operators: " + operators);
    }
}