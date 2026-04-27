import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        int[][] testCases = {
                {2,1,5,6,2,3},
                {2,4},
                {6,2,5,4,5,1,6},
                {1,1,1,1},
                {5,4,3,2,1},
                {1},
                {},
                {2,3,4,5,6}
        };

        for (int[] heights : testCases) {
            displayHistogram(heights);

            int maxArea = findLargestRectangle(heights);

            displayResult(heights, maxArea);
        }

        compareApproaches();
    }

    // MAIN ALGORITHM
    public static int findLargestRectangle(int[] heights) {

        if (heights.length == 0) {
            System.out.println("Empty histogram.");
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        System.out.println("\nStep-by-step:");

        while (i < heights.length) {

            // PUSH if increasing
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                System.out.println("Push index " + i);
                i++;
            } else {
                // POP
                int top = stack.pop();
                int height = heights[top];

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);

                System.out.println("Pop index " + top +
                        " → height=" + height +
                        ", width=" + width +
                        ", area=" + area);
            }

            System.out.println("Stack: " + stack);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int height = heights[top];

            int width;
            if (stack.isEmpty()) {
                width = i;
            } else {
                width = i - stack.peek() - 1;
            }

            int area = height * width;
            maxArea = Math.max(maxArea, area);

            System.out.println("Final pop " + top +
                    " → area=" + area);
        }

        return maxArea;
    }

    // 🔹 AREA HELPER
    public static int calculateArea(int[] heights, int start, int end, int height) {
        return height * (end - start + 1);
    }

    // 🔹 DISPLAY HISTOGRAM (ASCII)
    public static void displayHistogram(int[] heights) {

        System.out.println("Histogram:");

        if (heights.length == 0) {
            System.out.println("Empty");
            return;
        }

        int max = 0;
        for (int h : heights) max = Math.max(max, h);

        for (int level = max; level > 0; level--) {
            for (int h : heights) {
                if (h >= level) System.out.print("█ ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        // base line
        for (int i = 0; i < heights.length; i++) {
            System.out.print("--");
        }
        System.out.println();

        // values
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println();
    }

    // 🔹 DISPLAY RESULT
    public static void displayResult(int[] heights, int maxArea) {
        System.out.println("\nMax Rectangle Area: " + maxArea);
    }

    // 🔹 BRUTE FORCE VS STACK
    public static void compareApproaches() {

        System.out.println("\n==============================");
        System.out.println("Comparison:");

        System.out.println("Brute Force:");
        System.out.println("Check all pairs → O(n^2)");

        System.out.println("\nStack Approach:");
        System.out.println("Single pass using stack → O(n)");
    }

    // 🔹 BONUS: BINARY MATRIX
    public static int largestRectangleInMatrix(int[][] matrix) {

        if (matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int[] row : matrix) {

            for (int j = 0; j < cols; j++) {
                if (row[j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, findLargestRectangle(heights));
        }

        return maxArea;
    }
}