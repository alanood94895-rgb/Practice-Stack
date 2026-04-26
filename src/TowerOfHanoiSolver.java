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
}
