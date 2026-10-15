import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public double getInsuranceCharge() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance(declaredValue);
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateCharge() + getInsuranceCharge();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weight);
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight) + 50.0;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            Parcel parcel = null;
            switch (type.toUpperCase()) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
            }

            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double insurance = parcel.getInsuranceCharge();
                double total = parcel.calculateTotal();
                grandTotal += total;

                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", 
                                  type.toUpperCase(), charge, insurance, total);
            }
        }

        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}