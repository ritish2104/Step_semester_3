import java.util.Scanner;

class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileCreation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String permId = sc.next();
        String permName = sc.next();
        double permSalary = sc.nextDouble();

        String internId = sc.next();
        String internName = sc.next();

        EmployeeProfile permEmp = new EmployeeProfile(permId, permName, permSalary);
        EmployeeProfile internEmp = new EmployeeProfile(internId, internName);

        permEmp.printProfile();
        internEmp.printProfile();

        sc.close();
    }
}