import java.util.Stack;

public class StackSorter {

    public static void main(String[] args) {

        // 5 stacks
        Stack<Integer> s1 = createStack(new int[]{3, 1, 4, 2, 5});
        Stack<Integer> s2 = createStack(new int[]{10, 9, 8, 7, 6});
        Stack<Integer> s3 = createStack(new int[]{1, 2, 3, 4, 5});
        Stack<Integer> s4 = createStack(new int[]{7});
        Stack<Integer> s5 = createStack(new int[]{});

        processStack(s1, "Stack 1");
        processStack(s2, "Stack 2");
        processStack(s3, "Stack 3");
        processStack(s4, "Stack 4");
        processStack(s5, "Stack 5");
    }

    // 🔹 CREATE STACK
    public static Stack<Integer> createStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        return stack;
    }

    // 🔹 PROCESS STACK
    public static void processStack(Stack<Integer> stack, String name) {

        System.out.println("\n==============================");
        System.out.println(name);

        displayStack(stack, "Original");

        Stack<Integer> sorted = sortStack(stack);

        displayStack(sorted, "Sorted (Iterative)");

        // Recursive version
        sortStackRecursive(sorted);
        displayStack(sorted, "Sorted (Recursive)");
    }

    // 🔹 ITERATIVE SORT USING TEMP STACK
    public static Stack<Integer> sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<>();

        System.out.println("\nStep-by-step sorting:");

        while (!stack.isEmpty()) {

            int temp = stack.pop();
            System.out.println("\nPopped: " + temp);

            // Move elements back if needed
            while (!tempStack.isEmpty() && tempStack.peek() < temp) {
                int moved = tempStack.pop();
                stack.push(moved);
                System.out.println("Move back: " + moved);
            }

            tempStack.push(temp);
            System.out.println("Push to tempStack: " + temp);

            System.out.println("Original: " + stack);
            System.out.println("Temp:     " + tempStack);
        }

        return tempStack;
    }

    // 🔹 RECURSIVE SORT
    public static void sortStackRecursive(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();

        // Sort remaining stack
        sortStackRecursive(stack);

        // Insert in correct position
        insertInSortedOrder(stack, temp);
    }

    // 🔹 INSERT IN SORTED ORDER (HELPER)
    public static void insertInSortedOrder(Stack<Integer> stack, int value) {

        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();

        insertInSortedOrder(stack, value);

        stack.push(temp);
    }

    // 🔹 DISPLAY STACK
    public static void displayStack(Stack<Integer> stack, String name) {

        System.out.println(name + ": " + stack);

        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element: " + stack.peek());
            System.out.println("Size: " + stack.size());
        }
    }
}