import java.util.Scanner;

class CompanyEmployee {
    String empName;
    double salary;
    static String companyName;
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CompanyEmployee.companyName = sc.nextLine();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double salary = sc.nextDouble();
            new CompanyEmployee(name, salary);
        }

        CompanyEmployee.printCompanyInfo();
        sc.close();
    }
}