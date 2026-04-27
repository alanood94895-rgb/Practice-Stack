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
            System.out.println("\n==============================");
}
        displayHistogram(heights);

        int maxArea = findLargestRectangle(heights);

        displayResult(heights, maxArea);
    }

    compareApproaches();
}

// 🔹 MAIN ALGORITHM (O(n))
public static int findLargestRectangle(int[] heights) {

    if (heights.length == 0) {
        System.out.println("Empty histogram.");
        return 0;
    }