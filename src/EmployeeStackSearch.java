import java.util.Stack;
import java.util.Iterator;

public class EmployeeStackSearch {

    public static void main(String[] args) {

        // Create a Stack
        Stack<String> employeeActions = new Stack<>();

        // Add  6 employee action
        employeeActions.push("A logged in");
        employeeActions.push("B updated client records");
        employeeActions.push("C generated report");
        employeeActions.push("D approved leave request");
        employeeActions.push("E logged out");
        employeeActions.push("F changed password");

        // Display stack from TOP
        System.out.println("Stack elements from TOP:");
        for (int i = employeeActions.size() - 1, pos = 1; i >= 0; i--, pos++) {
            System.out.println("Position " + pos + ": " + employeeActions.get(i));
        }

        // Use search to find 2 elements
        System.out.println("Search Results:");
        int Position1 = employeeActions.search("A logged in");
        int Position2 = employeeActions.search("B Update client records");

        System.out.println("'A logged in' is at position: " + Position1);
        System.out.println("'B Update client records' is at position: " + Position2);

        // Use contains(
        System.out.println("Contains Check:");
        System.out.println("Contains 'D approved leave request'" + employeeActions.contains("D approved leave request"));


        // Standard for loop (TOP to BOTTOM)
        for (int i = employeeActions.size() - 1; i >= 0; i--) {
            System.out.println(employeeActions.get(i));
        }

        // (BOTTOM to TOP)
        int index = 0;
        for (String action : employeeActions) {
            System.out.println("Index " + index + ": " + action);
            index++;
        }

        // Iterator traversal
        System.out.println("Iterator traversal:");
        Iterator<String> iterator = employeeActions.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println("Index " + i + ": " + iterator.next());
            i++;
        }
    }
}