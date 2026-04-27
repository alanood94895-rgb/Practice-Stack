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
            System.out.println("\n==============================");

            int[] spans = calculateSpan(prices);
            displayResults(prices, spans);
            visualizeSpans(prices, spans);

            int[] brute = calculateSpanBruteForce(prices);

            System.out.println("\nBrute Force Spans:");
            printArray(brute);

            analyzeSpans(spans);
        }
    }
    // Step-by-step demo
        System.out.println("\n===== STEP-BY-STEP =====");
    calculateSpanStepByStep(new int[]{100, 80, 60, 70, 60, 75, 85});
}

// 🔹 O(n) STACK METHOD
public static int[] calculateSpan(int[] prices) {

    int n = prices.length;
    int[] span = new int[n];

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
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