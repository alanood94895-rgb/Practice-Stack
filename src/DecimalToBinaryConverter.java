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

    }

}
