import java.util.Stack;

public class EmployeeStackDemo {                     // Create the main class
    public static void main (String[] args){
        // Create the Stack
        Stack <String> employeeAction = new Stack<>();
        // Add 5 employee action
        employeeAction.push("A logged in");
        employeeAction.push("B updated client records");
        employeeAction.push("C generated report");
        employeeAction.push("D approved leave request");
        employeeAction.push("E logged out");

        // Display all elements
        System.out.println(employeeAction);

        // Add one more employee action
        employeeAction.push("R change Passwords");

        // Display the updated Stack
        System.out.println("Updated Employee Actions in Stack:");
        System.out.println(employeeAction);
    }

}
