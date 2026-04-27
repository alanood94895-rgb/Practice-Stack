public class NQueensSolver {
    // 🔹 POSITION CLASS
    static class Position {
        int row, col;

        Position(int r, int c) {
            row = r;
            col = c;
        }
        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }

    public static void main(String[] args) {

        int[] testCases = {0, 1, 2, 3, 4, 5, 6, 8};

        for (int n : testCases) {
            System.out.println("\n==============================");
            System.out.println("N = " + n);

            displayAllSolutions(n);
    }
    }

    // Step-by-step demo for N=4
        System.out.println("\n===== STEP-BY-STEP (N=4) =====");
    solveNQueensStepByStep(4);
}

// 🔹 CHECK SAFE POSITION
public static boolean isSafe(Position pos, Stack<Position> queens) {

    for (Position q : queens) {

// same column
        if (q.col == pos.col) return false;
        // diagonal
        if (Math.abs(q.row - pos.row) == Math.abs(q.col - pos.col))
            return false;
    }

    return true;
}
// 🔹 ITERATIVE STACK SOLUTION
public static int solveNQueens(int n) {

    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (n == 2 || n == 3) return 0;
    Stack<Position> stack = new Stack<>();
    int row = 0, col = 0;
    int solutions = 0;
    while (true) {

        boolean placed = false;