import java.util.Stack;

public class BrowserHistorySimulator {
    public static void main (String[] args){
        // Create the Stack
        Stack<String> webPageURLs = new Stack<>();

        webPageURLs.push("google.com");
        webPageURLs.push("linkedin.com");
        webPageURLs.push("github.com");
        webPageURLs.push("youtube.com");
        webPageURLs.push("instagram.com");

        System.out.println(webPageURLs);

        // Use pop()
        String removed = webPageURLs.pop();
        String removed2 = webPageURLs.pop();
        System.out.println("popped element:" + removed);
        System.out.println("popped element:" + removed2);

        // Use peek() to view current page
        System.out.println("Current page (peek): " + webPageURLs.peek());

        // Simulate pressing back button twice
        System.out.println("\nPressing back button...");

        webPageURLs.pop();
        System.out.println("After 1st back, current page: " + webPageURLs.peek());

        webPageURLs.pop();
        System.out.println("After 2nd back, current page: " + webPageURLs.peek());

        // Check if stack is empty
        System.out.println("\nIs history empty? " + webPageURLs.isEmpty());

        // Add 2 new pages
        System.out.println("\nVisiting new pages...");

        webPageURLs.push("twitter.com");
        display(webPageURLs);

        webPageURLs.push("facebook.com");
        display(webPageURLs);

        // Final history
        System.out.println("\nFinal browsing history:");
        System.out.println(webPageURLs);

        // Bonus: clear history
        webPageURLs.clear();
        System.out.println("\nHistory cleared. Is empty? " + webPageURLs.isEmpty());
    }

    // Method to display current page and full history
    public static void display(Stack<String> stack) {
        System.out.println("Current page: " + stack.peek());
        System.out.println("History: " + stack);
        System.out.println("----------------------");
    }
}