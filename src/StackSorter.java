public class StackSorter {
    public static void main (String[] args){
// 5 test stacks
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

        // 🔹 CREATE STACK
        public static Stack<Integer> createStack(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            for (int num : arr) {
                stack.push(num);
            }
            return stack;
        }
    }
    }
}
