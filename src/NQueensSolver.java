import java.util.Stack;

public class NQueensSolver {

    // POSITION CLASS
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
            System.out.println("N = " + n);

            displayAllSolutions(n);
        }

        // demo for N=4
        System.out.println("(N=4)");
        solveNQueensStepByStep(4);
    }

    // CHECK SAFE POSITION
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

    // ITERATIVE STACK SOLUTION
    public static int solveNQueens(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2 || n == 3) return 0;

        Stack<Position> stack = new Stack<>();
        int row = 0, col = 0;
        int solutions = 0;

        while (true) {

            boolean placed = false;

            while (col < n) {

                Position pos = new Position(row, col);

                if (isSafe(pos, stack)) {
                    stack.push(pos);
                    row++;
                    col = 0;
                    placed = true;
                    break;
                }

                col++;
            }

            // If not placed
            if (!placed) {

                if (stack.isEmpty()) break;

                Position last = stack.pop();
                row = last.row;
                col = last.col + 1;
            }

            // Solution found
            if (row == n) {
                solutions++;
                stack.pop(); // backtrack
                row--;
                col = stack.isEmpty() ? 0 : stack.peek().col + 1;
            }
        }

        return solutions;
    }

    // DISPLAY ALL SOLUTIONS COUNT
    public static void displayAllSolutions(int n) {

        int count = solveNQueens(n);

        System.out.println("Total Solutions: " + count);
    }

    // 🔹 STEP-BY-STEP (FOR N=4)
    public static void solveNQueensStepByStep(int n) {

        Stack<Position> stack = new Stack<>();
        int row = 0, col = 0;

        while (true) {

            boolean placed = false;

            while (col < n) {

                Position pos = new Position(row, col);

                System.out.println("Trying: " + pos);

                if (isSafe(pos, stack)) {
                    stack.push(pos);
                    System.out.println("Placed: " + pos);
                    displayStack(stack);
                    displayBoard(stack, n);

                    row++;
                    col = 0;
                    placed = true;
                    break;
                }

                col++;
            }

            if (!placed) {

                if (stack.isEmpty()) break;

                Position last = stack.pop();
                System.out.println("Backtrack from: " + last);

                row = last.row;
                col = last.col + 1;
            }

            if (row == n) {
                System.out.println("Solution Found!");
                displayBoard(stack, n);

                stack.pop();
                row--;
                col = stack.isEmpty() ? 0 : stack.peek().col + 1;
            }
        }
    }

    // 🔹 DISPLAY STACK
    public static void displayStack(Stack<Position> stack) {
        System.out.println("Stack: " + stack);
    }

    // 🔹 DISPLAY BOARD (ASCII)
    public static void displayBoard(Stack<Position> queens, int n) {

        System.out.println("Board:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean hasQueen = false;

                for (Position q : queens) {
                    if (q.row == i && q.col == j) {
                        hasQueen = true;
                        break;
                    }
                }

                if (hasQueen) System.out.print(" Q ");
                else System.out.print(" . ");
            }
            System.out.println();
        }

        System.out.println("------------------");
    }

    // 🔹 RECURSIVE SOLUTION
    public static int solveRecursive(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2 || n == 3) return 0;

        return solveHelper(0, n, new Stack<>());
    }

    public static int solveHelper(int row, int n, Stack<Position> queens) {

        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            Position pos = new Position(row, col);

            if (isSafe(pos, queens)) {
                queens.push(pos);

                count += solveHelper(row + 1, n, queens);

                queens.pop(); // backtrack
            }
        }

        return count;
    }
}