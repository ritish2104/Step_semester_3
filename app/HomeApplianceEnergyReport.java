import java.util.Scanner;

interface SaverModeSupported {
    default double applySaverDiscount(double units) {
        return units * 0.75;
    }
}

abstract class Appliance {
    private final double powerWatts;

    public Appliance(double powerWatts) {
        this.powerWatts = powerWatts;
    }

    public double calculateUnits(double hours, boolean isSaverMode) throws UnsupportedOperationException {
        if (isSaverMode && !(this instanceof SaverModeSupported)) {
            throw new UnsupportedOperationException("saver mode not supported");
        }

        double units = (powerWatts * hours) / 1000.0;
        if (isSaverMode && this instanceof SaverModeSupported) {
            units = ((SaverModeSupported) this).applySaverDiscount(units);
        }

        return units;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge() {
        super(150.0);
    }
}

class AC extends Appliance implements SaverModeSupported {
    public AC() {
        super(1500.0);
    }
}

class TV extends Appliance {
    public TV() {
        super(100.0);
    }
}

class Washer extends Appliance implements SaverModeSupported {
    public Washer() {
        super(500.0);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String applianceType = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaverMode = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance = null;
            switch (applianceType.toUpperCase()) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AC();
                    break;
                case "TV":
                    appliance = new TV();
                    break;
                case "WASHER":
                    appliance = new Washer();
                    break;
            }

            if (appliance != null) {
                try {
                    double units = appliance.calculateUnits(hours, isSaverMode);
                    double cost = appliance.calculateCost(units);
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", applianceType.toUpperCase(), units, cost);
                } catch (UnsupportedOperationException e) {
                    System.out.printf("%s: %s\n", applianceType.toUpperCase(), e.getMessage());
                }
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}