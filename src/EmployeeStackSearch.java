import java.util.Stack;

public class EmployeeStackSearch {
    public static void main (String[] args){
        Stack <String> employeeAction = new Stack<>();

        employeeAction.push("A logged in");
        employeeAction.push("B updated client records");
        employeeAction.push("C generated report");
        employeeAction.push("D approved leave request");
        employeeAction.push("E logged out");
        employeeAction.push("Z change Passwords");

        // Display all elements
        System.out.println(employeeAction);

        int position = Stack.search ("Find position 2");
        if (position != -1){
            System.out.println("Position of 'B updated client records': " + position);
        }
        System.out.println("contains 'B updated client records':" + Sentance.contain ("B updated client records"));

        System.out.println(("stack element:" ));
        for (Integer nums :stack) {
            System.out.println(nums);
        }
    }

}
