import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Room {
    protected double units;

    public Room(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Room> rooms = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            types.add(type);

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new ACRoom(units));
                    break;
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            double bill = rooms.get(i).calculateBill();
            System.out.printf("%s: %.2f\n", types.get(i), bill);
            grandTotal += bill;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}