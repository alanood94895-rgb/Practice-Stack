import java.util.Stack;

public class DecimalToBinaryConverter {

    public static void main(String[] args) {

        // 6 test decimal numbers
        int[] numbers = {0, 5, 10, 13, 32, 255};

        System.out.println("Decimal to Binary Conversion");

        for (int i = 0; i < numbers.length; i++) {

            int decimal = numbers[i];

            System.out.println("Decimal: " + decimal);

            displayConversionProcess(decimal);

            String binary = decimalToBinary(decimal);

            System.out.println("Binary (Stack method): " + binary);

            System.out.println("Binary (Built-in): " + Integer.toBinaryString(decimal));

        }
    }

    // METHOD 1
    public static String decimalToBinary(int decimal) {

        if (decimal == 0) return "0";

        Stack<Integer> stack = new Stack<>();

        int temp = decimal;

        // Push remainder
        while (temp > 0) {
            int remainder = temp % 2;
            stack.push(remainder);
            temp = temp / 2;
        }

        // Build binary string
        String binary = "";

        while (!stack.isEmpty()) {
            binary += stack.pop();
        }

        return binary;
    }

    // METHOD 2
    public static void displayConversionProcess(int decimal) {

        if (decimal < 0) {
            System.out.println("Negative number -> convert absolute value only");
            decimal = Math.abs(decimal);
        }

        if (decimal == 0) {
            System.out.println("0 ÷ 2 = 0 remainder 0");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        int temp = decimal;

        System.out.println("Step-by-step division:");

        while (temp > 0) {

            int quotient = temp / 2;
            int remainder = temp % 2;

            System.out.println(temp + " ÷ 2 = " + quotient + " remainder " + remainder);

            stack.push(remainder);

            System.out.println("Stack: " + stack);

            temp = quotient;
        }
    }

    // Binary to Decimal conversion
    public static int binaryToDecimal(String binary) {

        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {

            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }

            power++;
        }

        return decimal;
    }
}