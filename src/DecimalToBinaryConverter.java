public class DecimalToBinaryConverter {
    public static void main (String[] args) {

        // 6 test decimal numbers
        int[] numbers = {0, 5, 10, 13, 32, 255};
        System.out.println("Decimal number");

        for (int i = 0; i < numbers.length; i++) {
            int decimal = numbers[i];
            System.out.println("Decimal: " + decimal);
            DisplayConversionProcess(decimal);
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

        // Push remainders
        while (temp > 0) {
            int remainder = temp % 2;
            stack.push(remainder);
            temp = temp / 2;
        }

    }

}
