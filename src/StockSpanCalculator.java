import java.util.Stack;

public class StockSpanCalculator {

    public static void main(String[] args) {

        int[][] testCases = {
                {100, 80, 60, 70, 60, 75, 85},
                {10, 20, 30, 40, 50},
                {50, 40, 30, 20, 10},
                {30},
                {},
                {20, 20, 20, 20}
        };

        for (int[] prices : testCases) {

            int[] spans = calculateSpan(prices);
            displayResults(prices, spans);
            visualizeSpans(prices, spans);

            int[] brute = calculateSpanBruteForce(prices);

            System.out.println("Brute Force Spans:");
            printArray(brute);

            analyzeSpans(spans);
        }

        // Step-by-step demo
        calculateSpanStepByStep(new int[]{100, 80, 60, 70, 60, 75, 85});
    }

    // STACK METHOD
    public static int[] calculateSpan(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) span[i] = i + 1;
            else span[i] = i - stack.peek();

            stack.push(i);
        }

        return span;
    }

    // 🔹 BRUTE FORCE O(n²)
    public static int[] calculateSpanBruteForce(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {

            span[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] <= prices[i]) span[i]++;
                else break;
            }
        }

        return span;
    }

    // 🔹 DISPLAY TABLE
    public static void displayResults(int[] prices, int[] spans) {

        if (prices.length == 0) {
            System.out.println("Empty data.");
            return;
        }

        System.out.println("\nDay\tPrice\tSpan");

        for (int i = 0; i < prices.length; i++) {
            System.out.println((i + 1) + "\t" + prices[i] + "\t" + spans[i]);
        }
    }

    // 🔹 VISUALIZATION
    public static void visualizeSpans(int[] prices, int[] spans) {

        System.out.println("\nVisualization:");

        for (int i = 0; i < prices.length; i++) {

            System.out.print("Day " + (i + 1) + " Price:");

            for (int j = 0; j < prices[i] / 10; j++) {
                System.out.print("█");
            }

            System.out.print("  Span:");

            for (int j = 0; j < spans[i]; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // 🔹 STEP-BY-STEP PROCESS
    public static void calculateSpanStepByStep(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] span = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            System.out.println("\nDay " + (i + 1) + " Price: " + prices[i]);

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                int popped = stack.pop();
                System.out.println("Pop index " + popped + " (price " + prices[popped] + ")");
            }

            if (stack.isEmpty()) span[i] = i + 1;
            else span[i] = i - stack.peek();

            stack.push(i);

            System.out.println("Span: " + span[i]);
            System.out.print("Stack: ");

            for (int idx : stack) {
                System.out.print("(" + idx + ":" + prices[idx] + ") ");
            }

            System.out.println();
        }
    }

    // 🔹 ANALYSIS
    public static void analyzeSpans(int[] spans) {

        if (spans.length == 0) return;

        int max = spans[0];
        int day = 0;
        int sum = 0;

        for (int i = 0; i < spans.length; i++) {
            sum += spans[i];

            if (spans[i] > max) {
                max = spans[i];
                day = i;
            }
        }

        double avg = (double) sum / spans.length;

        System.out.println("\nMax Span: " + max + " on day " + (day + 1));
        System.out.println("Average Span: " + avg);
    }

    // 🔹 PRINT ARRAY
    public static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}