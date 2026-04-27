public class NextGreaterElementFinder {
      public static void main (String[] args){
          int[][] testArrays = {
                  {4, 5, 2, 10},
                  {1, 2, 3, 4},
                  {9, 8, 7, 6},
                  {3},
                  {},
                  {6, 8, 0, 1, 3}
          };
          for (int[] arr : testArrays) {
              System.out.println("\n==============================");

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
      }
}
