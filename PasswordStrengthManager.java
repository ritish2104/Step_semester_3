import java.util.Scanner;

class EncapsulatedPasswordChecker {
    private String password;

    public EncapsulatedPasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordStrengthManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pwd1 = sc.next();
        String pwd2 = sc.next();

        EncapsulatedPasswordChecker pc1 = new EncapsulatedPasswordChecker(pwd1);
        EncapsulatedPasswordChecker pc2 = new EncapsulatedPasswordChecker(pwd2);

        System.out.println("Password 1 strength: " + pc1.getStrength());
        System.out.println("Password 2 strength: " + pc2.getStrength());

        sc.close();
    }
}