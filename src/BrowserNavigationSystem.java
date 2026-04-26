import java.util.Stack;

public class BrowserNavigationSystem {

    // Back and Forward stacks
    static Stack<String> backStack = new Stack<>();
    static Stack<String> forwardStack = new Stack<>();

    // Current page
    static String currentPage = "Home";

    // Limit for back history
    static final int MAX_HISTORY = 10;

    public static void main(String[] args) {

        showCurrentPage();

        // Simulated user actions
        visitPage("Google");
        visitPage("YouTube");
        visitPage("Facebook");
        goBack();
        goBack();
        goForward();
        visitPage("Twitter");
        goBack();
        visitPage("LinkedIn");
        goBack();
        goForward();
        goForward();

        showSessionHistory();
    }

    // Visit new page
    public static void visitPage(String url) {

        // Save current page to back stack
        backStack.push(currentPage);

        // Maintain max history
        if (backStack.size() > MAX_HISTORY) {
            backStack.remove(0); // remove oldest
        }

        currentPage = url;

        // Clear forward history
        forwardStack.clear();

        System.out.println("Visited: " + url);
        display();
    }

    // Use Go back
    public static void goBack() {

        if (backStack.isEmpty()) {
            System.out.println("Cannot go back");
            return;
        }

        forwardStack.push(currentPage);

        currentPage = backStack.pop();

        System.out.println("Went Back");
        display();
    }

    // Use Go forward
    public static void goForward() {

        if (forwardStack.isEmpty()) {
            System.out.println("Cannot go forward");
            return;
        }

        backStack.push(currentPage);

        currentPage = forwardStack.pop();

        System.out.println("Went Forward");
        display();
    }

    // Show current page
    public static void showCurrentPage() {
        System.out.println("Current Page: " + currentPage);
    }

    // Display stacks + current page
    public static void display() {
        System.out.println("Current Page: " + currentPage);
        System.out.println("Back Stack: " + backStack);
        System.out.println("Forward Stack: " + forwardStack);
    }

    //  show all pages visited in session
    public static void showSessionHistory() {
        System.out.println("Session History:");
        System.out.println("Back Stack: " + backStack);
        System.out.println("Current: " + currentPage);
        System.out.println("Forward Stack: " + forwardStack);
    }
}