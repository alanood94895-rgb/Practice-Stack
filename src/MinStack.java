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
            stack.pop(); // empty case
            stack.getMin(); // empty case

        }
}
