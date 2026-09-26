import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected double billAmount;

    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();
}

class Student extends Customer {
    public Student(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.90; // 10% discount
    }
}

class Staff extends Customer {
    public Staff(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.95; // 5% discount
    }
}

class Guest extends Customer {
    public Guest(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount + 10.0; // Full amount + 10 service charge
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Customer> customers = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            types.add(type);

            switch (type) {
                case "STUDENT":
                    customers.add(new Student(amount));
                    break;
                case "STAFF":
                    customers.add(new Staff(amount));
                    break;
                case "GUEST":
                    customers.add(new Guest(amount));
                    break;
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            double finalAmount = customers.get(i).calculateFinalAmount();
            System.out.printf("%s: %.2f\n", types.get(i), finalAmount);
            grandTotal += finalAmount;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}