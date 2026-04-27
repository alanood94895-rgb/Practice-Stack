import java.util.Stack;

public class NextGreaterElementFinder {

    public static void main(String[] args) {

        int[][] testArrays = {
                {4, 5, 2, 10},
                {1, 2, 3, 4},
                {9, 8, 7, 6},
                {3},
                {},
                {6, 8, 0, 1, 3}
        };

        for (int[] arr : testArrays) {
            System.out.println("testArrays");

            int[] nge = findNextGreaterElement(arr);
            displayResults(arr, nge);

            int[] nse = findNextSmallerElement(arr);
            System.out.println("\nNext Smaller Element:");
            displayResults(arr, nse);

            int[] circular = findNextGreaterElementCircular(arr);
            System.out.println("\nCircular Next Greater:");
            displayResults(arr, circular);
        }

        compareApproaches();
    }

    // 🔹 NEXT GREATER ELEMENT (O(n))
    public static int[] findNextGreaterElement(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) result[i] = -1;

        Stack<Integer> stack = new Stack<>();

        System.out.println("\nStep-by-step (Next Greater):");

        for (int i = 0; i < n; i++) {

            System.out.println("\nProcessing index " + i + " value " + arr[i]);

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                result[idx] = arr[i];
                System.out.println("Pop index " + idx + " → set result[" + idx + "] = " + arr[i]);
            }

            stack.push(i);
            System.out.println("Push index " + i);
            System.out.println("Stack: " + stack);
        }

        return result;
    }

    // 🔹 NEXT SMALLER ELEMENT
    public static int[] findNextSmallerElement(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) result[i] = -1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int idx = stack.pop();
                result[idx] = arr[i];
            }

            stack.push(i);
        }

        return result;
    }

    // 🔹 CIRCULAR NEXT GREATER
    public static int[] findNextGreaterElementCircular(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) result[i] = -1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            while (!stack.isEmpty() && arr[stack.peek()] < arr[index]) {
                int idx = stack.pop();
                result[idx] = arr[index];
            }

            if (i < n) {
                stack.push(index);
            }
        }

        return result;
    }

    // 🔹 DISPLAY TABLE
    public static void displayResults(int[] arr, int[] result) {

        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.println("\nIndex\tValue\tNext");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "\t" + arr[i] + "\t" + result[i]);
        }
    }

    // 🔹 COMPARISON
    public static void compareApproaches() {

        System.out.println("\n==============================");
        System.out.println("Comparison:");

        System.out.println("Brute Force:");
        System.out.println("For each element, check all elements to the right");
        System.out.println("Time Complexity: O(n^2)");

        System.out.println("\nStack Approach:");
        System.out.println("Each element is pushed and popped at most once");
        System.out.println("Time Complexity: O(n)");
    }
}