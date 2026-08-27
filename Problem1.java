import java.util.Scanner;

public class Problem1 {
    public static void classifyWithAttendance(int marks, int attendance) {
        if (attendance < 75 || marks < 40) {
            System.out.println("Detained");
        } else {
            if (marks >= 90) {
                System.out.println("Grade: A");
            } else if (marks >= 75) {
                System.out.println("Grade: B");
            } else if (marks >= 50) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: D");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student marks (0-100): ");
        int marks = scanner.nextInt();
        
        System.out.print("Enter attendance percentage (0-100): ");
        int attendance = scanner.nextInt();
        
        classifyWithAttendance(marks, attendance);
        
        scanner.close();
    }
}