import java.util.Stack;

public class EmployeeStackDemo {                     // Create the main class
    public static void main (String[] args){
        // Create the Stack
        Stack <String> employeeAction = new Stack<>();
        employeeAction.push("A logged in");
        employeeAction.push("B updated client records");
        employeeAction.push("C generated report");
        employeeAction.push("D approved leave request");
        employeeAction.push("E logged out");

        System.out.println(employeeAction);

        employeeAction.push("z change Passwords");
        System.out.println("Updated Employee Actions in Stack:");
        System.out.println(employeeAction);
    }

}
