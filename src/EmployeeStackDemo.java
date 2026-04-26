import java.util.Stack;

public class EmployeeStackDemo {                     // Create the main class
    public static void main (String[] args){
        // Create the Stack
        Stack <String> employeeAction = new Stack<>();
        employeeAction.push("employee Ali logged in");
        employeeAction.push("employee Noof updated client records");
        employeeAction.push("employee Noor generated report");
        employeeAction.push("employee Hoor approved leave request");
        employeeAction.push("employee Alanoud logged out");

        System.out.println(employeeAction);

        employeeAction.push("employee Said change Passwords");
        System.out.println("Updated Employee Actions in Stack:");
        System.out.println(employeeAction);
    }

}
