import java.util.Scanner;

public class Problem2 {
    public static void simulateLogin(String correctCode, String[] attempts) {
        boolean accessGranted = false;
        int maxAttempts = Math.min(attempts.length, 3);

        for (int i = 0; i < maxAttempts; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                accessGranted = true;
                break;
            }
        }

        if (!accessGranted) {
            System.out.println("Access denied all attempts used");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Set the correct access code: ");
        String correctCode = scanner.next();
        
        System.out.print("Enter the number of attempts to make (up to 3): ");
        int count = scanner.nextInt();
        String[] attempts = new String[count];
        
        for (int i = 0; i < count; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = scanner.next();
        }
        
        simulateLogin(correctCode, attempts);
        
        scanner.close();
    }
}