import java.util.Stack;

public class TowerOfHanoiSolver {
    public static void main (String[] args) {

    }
        // Three stacks representing pegs A, B, C
        static Stack<Integer> pegA = new Stack<>();
        static Stack<Integer> pegB = new Stack<>();
        static Stack<Integer> pegC = new Stack<>();

    // Counter for moves
    static int moveCount = 0;

    // Initialize peg A with disks
    public static void initializePegs(int numDisks) {
        pegA.clear();
        pegB.clear();
        pegC.clear();
        moveCount = 0;

        // Add disks (largest at bottom, smallest at top)
        for (int i = numDisks; i >= 1; i--) {
            pegA.push(i);

        }
    }
    // Get peg reference based on name
    public static Stack<Integer> getPeg(char peg) {
        if (peg == 'A') return pegA;
        if (peg == 'B') return pegB;
        return pegC;
    }
    // Check if move is valid
    public static boolean isValidMove(char fromPeg, char toPeg) {
        Stack<Integer> from = getPeg(fromPeg);
        Stack<Integer> to = getPeg(toPeg);

        if (from.isEmpty()) return false;

        if (to.isEmpty()) return true;

        // smaller disk on larger
        return from.peek() < to.peek();
    }
    // Move disk between pegs
    public static void moveDisk(char fromPeg, char toPeg) {

        if (!isValidMove(fromPeg, toPeg)) {
            System.out.println("Invalid move attempted from " + fromPeg + " to " + toPeg);
            return;
        }
        Stack<Integer> from = getPeg(fromPeg);
        Stack<Integer> to = getPeg(toPeg);

        int disk = from.pop();
        to.push(disk);

        moveCount++;
        System.out.println("Peg A: " + pegA);
        System.out.println("Peg B: " + pegB);
        System.out.println("Peg C: " + pegC);

    }
}
