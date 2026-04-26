import java.util.Stack;

public class EmployeeStackSearch {
    public static void main(String[] args) {

        // Create Stack
        Stack<String> employeeAction = new Stack<>();

        // Add elements
        employeeAction.push("A logged in");
        employeeAction.push("B updated client records");
        employeeAction.push("C generated report");
        employeeAction.push("D approved leave request");
        employeeAction.push("E logged out");
        employeeAction.push("Z change Passwords");

        // Display all elements
        System.out.println("Stack: " + employeeAction);

        // Use search()
        int position = employeeAction.search("B updated client records");
        if (position != -1) {
            System.out.println("Position of 'B updated client records': " + position);
        } else {
            System.out.println("Element not found");
        }

        // Use contains() correctly
        System.out.println("Contains 'B updated client records': "
                + employeeAction.contains("B updated client records"));

        // Iterate using for-each loop (bottom to top)
        System.out.println("Stack elements:");
        for (String action : employeeAction) {
            System.out.println(action);
        }
    }
}