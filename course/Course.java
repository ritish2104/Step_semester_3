package course;

import java.util.Scanner;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    public void inputDetails(Scanner scanner) {
        System.out.print("Enter Course Code: ");
        this.courseCode = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        this.courseName = scanner.nextLine();
        System.out.print("Enter Credits: ");
        this.credits = scanner.nextInt();
        scanner.nextLine();
    }

    public void displayDetails() {
        System.out.println("\n--- Course Details ---");
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
    }
}