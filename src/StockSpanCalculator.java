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
