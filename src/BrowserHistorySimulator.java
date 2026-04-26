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

    }
}
