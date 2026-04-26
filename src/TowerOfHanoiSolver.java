import java.util.Stack;

public class TowerOfHanoiSolver {

    static Stack<Integer> pegA = new Stack<>();
    static Stack<Integer> pegB = new Stack<>();
    static Stack<Integer> pegC = new Stack<>();

    static int moveCount = 0;

    public static void main(String[] args) {

        int[] tests = {3, 4, 5};

        for (int n : tests) {

            System.out.println("Solving for " + n + " disks");

            initializePegs(n);
            displayPegs();

            solveHanoi(n, 'A', 'C', 'B');

            System.out.println("Total moves: " + moveCount);
            System.out.println("Expected: " + ((int)Math.pow(2, n) - 1));

        }
    }

    public static void initializePegs(int numDisks) {
        pegA.clear();
        pegB.clear();
        pegC.clear();
        moveCount = 0;

        for (int i = numDisks; i >= 1; i--) {
            pegA.push(i);
        }
    }

    public static Stack<Integer> getPeg(char peg) {
        if (peg == 'A')
            return pegA;
        if (peg == 'B')
            return pegB;
            return pegC;
    }

    public static boolean isValidMove(char fromPeg, char toPeg) {
        Stack<Integer> from = getPeg(fromPeg);
        Stack<Integer> to = getPeg(toPeg);

        if (from.isEmpty()) return false;
        if (to.isEmpty()) return true;

        return from.peek() < to.peek();
    }

    public static void moveDisk(char fromPeg, char toPeg) {

        if (!isValidMove(fromPeg, toPeg)) {
            System.out.println("Invalid move from " + fromPeg + " to " + toPeg);
            return;
        }

        Stack<Integer> from = getPeg(fromPeg);
        Stack<Integer> to = getPeg(toPeg);

        int disk = from.pop();
        to.push(disk);

        moveCount++;

        System.out.println("Move disk " + disk + " from " + fromPeg + " -> " + toPeg);
        displayPegs();
    }

    // MAIN LOGIC
    public static void solveHanoi(int n, char from, char to, char aux) {

        if (n == 1) {
            moveDisk(from, to);
            return;
        }

        solveHanoi(n - 1, from, aux, to);
        moveDisk(from, to);
        solveHanoi(n - 1, aux, to, from);
    }

    // CLEAN DISPLAY METHOD
    public static void displayPegs() {
        System.out.println("A: " + pegA);
        System.out.println("B: " + pegB);
        System.out.println("C: " + pegC);
    }
}