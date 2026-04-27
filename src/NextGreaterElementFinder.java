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

      }
}
