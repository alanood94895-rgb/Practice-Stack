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

}
}
