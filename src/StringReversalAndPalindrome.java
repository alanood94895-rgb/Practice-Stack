import java.util.Stack;

public class StringReversalAndPalindrome {
    public static void main (String[] args){
        // Create the Stack
        Stack<Character> stack = new Stack<>();

        stack.push ('j');
        stack.push ('H');
        stack.push ('B');
        stack.push ('T');
        stack.push ('W');
        stack.push ('O');

        System.out.println(stack);
             //test case f
        System.out.println("Original String :"+ stack);
        System.out.println("Reverse String :"+reverseString(stack));
        System.out.println(isPalindrome(stack));
        //Show stack process :
        for (int i = 0; i<stack.length(); i++) {
            stack.push(stack.charAt(i));
            System.out.println("pushed "+stack.charAt(i)+" to stack");
        }
        for (int i = 0; i<stack.length(); i++) {
            char popped = stack.pop();
            System.out.println("popped "+popped+" from stack");
        }
    }

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        //check if empty or null or length ==1
        if (s == null) return null;
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        String result = "";
        //push character from string s
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        //added pushed character to result ..reversed string
        for (int i = 0; i < s.length(); i++) {
            result += stack.pop();
        }
        return result;
    }

    public static Boolean isPalindrome(String s) {
        //ignore sensitive case with space
        s=s.toLowerCase().trim();
        //check if isPalindrome
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}






