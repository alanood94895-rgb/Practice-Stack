import java.util.Stack;

public class MinStack {
    public static void main (String[] args){
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        public static void main(String[] args) {
            MinStack stack = new MinStack();

            stack.push(5);
            stack.push(3);
            stack.push(7);
            stack.getMin();
            stack.push(2);
            stack.push(8);
            stack.getMin();
            stack.pop();
            stack.pop();
            stack.getMin();
            stack.peek();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.getMin();
            // Demonstrate Approach 1
            System.out.println("\n--- Approach 1 (Pair Method) ---");
            PairMinStack pairStack = new PairMinStack();
            pairStack.push(5);
            pairStack.push(3);
            pairStack.push(7);
            pairStack.push(2);
            pairStack.display();
        }
        // 🔹 PUSH
        public void push(int value) {

            mainStack.push(value);
            // Update minStack
            if (minStack.isEmpty() || value <= minStack.peek()) {
                minStack.push(value);
            }

            System.out.println("\nPush: " + value);
            display();
        }
        // 🔹 POP
        public void pop() {

            if (mainStack.isEmpty()) {
                System.out.println("\nPop: Stack is empty");
                return;
            }
            int removed = mainStack.pop();

            if (!minStack.isEmpty() && removed == minStack.peek()) {
                minStack.pop();
            }

            System.out.println("\nPop: " + removed);
            display();
        }
        // 🔹 PEEK
        public void peek() {

            if (mainStack.isEmpty()) {
                System.out.println("\nPeek: Stack is empty");
                return;
            }

            System.out.println("\nPeek: " + mainStack.peek());
            display();
        }
        }
    // 🔹 GET MIN (O(1))
    public void getMin() {

        if (minStack.isEmpty()) {
            System.out.println("\nMin: Stack is empty");
            return;
        }

        System.out.println("\nCurrent Min: " + minStack.peek());
        display();
    }
    // 🔹 DISPLAY
    public void display() {

        System.out.println("Main Stack: " + mainStack);
        System.out.println("Min Stack:  " + minStack);

        if (!minStack.isEmpty()) {
            System.out.println("Min Value: " + minStack.peek());
        }

        System.out.println("-----------------------");
    }
    // 🔹 APPROACH 1: PAIR METHOD
    class PairMinStack {

        static class Pair {
            int value;
            int min;

            Pair(int value, int min) {
                this.value = value;
                this.min = min;
}
        }
    }

    public String toString() {
        return "(" + value + "," + min + ")";
    }
}
Stack<Pair> stack = new Stack<>();

public void push(int value) {

    if (stack.isEmpty()) {
        stack.push(new Pair(value, value));
    } else {
        int currentMin = Math.min(value, stack.peek().min);
        stack.push(new Pair(value, currentMin));
    }
}

    }

}
