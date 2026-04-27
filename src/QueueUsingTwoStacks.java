import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main (String[] args){

        Stack<T> inputStack = new Stack<>();
        Stack<T> outputStack = new Stack<>();

        public static void main(String[] args) {
            QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

            System.out.println("Queue Operations:");
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.peek();
            queue.dequeue();
            queue.enqueue(40);
            queue.enqueue(50);
            queue.dequeue()
            queue.peek();
            queue.enqueue(60);
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.peek();
        }
        // 🔹 ENQUEUE
        public void enqueue(T element) {
            inputStack.push(element);
            System.out.println("\nEnqueue: " + element);
            displayState();
            // 🔹 DEQUEUE
            public T dequeue() {

                if (isEmpty()) {
                    System.out.println("\nDequeue: Queue is empty");
                    return null;
                }
                // Transfer only if needed
                if (outputStack.isEmpty()) {
                    transfer();
                }

                T value = outputStack.pop();
                System.out.println("\nDequeue: " + value);
                displayState();
                return value;
            }
            // 🔹 PEEK
            public T peek() {

                if (isEmpty()) {
                    System.out.println("\nPeek: Queue is empty");
                    return null;
                }

                if (outputStack.isEmpty()) {
                    transfer();
                }

                T value = outputStack.peek();
                System.out.println("\nPeek: " + value);
                displayState();
                return value;
        }
            // 🔹 CHECK EMPTY
            public boolean isEmpty() {
                return inputStack.isEmpty() && outputStack.isEmpty();
            }
            // 🔹 SIZE
            public int size() {
                return inputStack.size() + outputStack.size();
            }
        }
        // 🔹 TRANSFER ELEMENTS (core logic)
        private void transfer() {
            System.out.println("Transferring elements from inputStack → outputStack");

            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
            // 🔹 DISPLAY STATE
            public void displayState() {

                System.out.println("Input Stack:  " + inputStack);
                System.out.println("Output Stack: " + outputStack);
// Show logical queue order
                System.out.print("Queue Order:  ");

            }
            // First: outputStack (top to bottom)
            for (int i = outputStack.size() - 1; i >= 0; i--) {
                System.out.print(outputStack.get(i) + " ");
            }
// Then: inputStack (bottom to top)
            for (int i = 0; i < inputStack.size(); i++) {
                System.out.print(inputStack.get(i) + " ");
            }
            System.out.println("\nSize: " + size());
            System.out.println("---------------------------");
        }
    }

        }
