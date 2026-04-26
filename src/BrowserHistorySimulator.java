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

        // Check if webPageURLs is empty
        System.out.println("Is webPageURLs empty? " + webPageURLs.isEmpty());

        // Add 2 new page
        webPageURLs.push("Twitter.com");
        webPageURLs.push("Facebook.com");
        //  Display the final webPageURLs
        System.out.println(webPageURLs);

    }
}
