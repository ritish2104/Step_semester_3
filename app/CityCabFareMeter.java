import java.util.Scanner;

interface NightServiceable {
    default double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    private final double ratePerKm;
    private static final double MINIMUM_FARE = 100.0;

    public Cab(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public double calculateFare(double distance, boolean isNight) throws IllegalStateException {
        if (isNight && !(this instanceof NightServiceable)) {
            throw new IllegalStateException("night service not available");
        }

        double baseFare = distance * ratePerKm;
        if (baseFare < MINIMUM_FARE) {
            baseFare = MINIMUM_FARE;
        }

        if (isNight && this instanceof NightServiceable) {
            return ((NightServiceable) this).applyNightSurcharge(baseFare);
        }

        return baseFare;
    }
}

class MiniCab extends Cab {
    public MiniCab() {
        super(10.0);
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab() {
        super(14.0);
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab() {
        super(18.0);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = time.equalsIgnoreCase("NIGHT");

            Cab cab = null;
            switch (cabType.toUpperCase()) {
                case "MINI":
                    cab = new MiniCab();
                    break;
                case "SEDAN":
                    cab = new SedanCab();
                    break;
                case "SUV":
                    cab = new SUVCab();
                    break;
            }

            if (cab != null) {
                try {
                    double fare = cab.calculateFare(distance, isNight);
                    grandTotal += fare;
                    System.out.printf("%s: %.2f\n", cabType.toUpperCase(), fare);
                } catch (IllegalStateException e) {
                    System.out.printf("%s: %s\n", cabType.toUpperCase(), e.getMessage());
                }
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}