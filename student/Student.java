package student;

import java.util.Scanner;

public class Student {
    private String name;
    private int rollNo;
    private String department;

    public void inputDetails(Scanner scanner) {
        System.out.print("Enter Student Name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        this.rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Department: ");
        this.department = scanner.nextLine();
    }

    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + department);
    }
}