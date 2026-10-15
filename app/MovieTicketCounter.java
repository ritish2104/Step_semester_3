import java.util.Scanner;

abstract class Seat {
    private final double basePrice;
    private static final double CONVENIENCE_FEE = 20.00;

    public Seat(double basePrice) {
        this.basePrice = basePrice;
    }

    public double calculateTicketPrice() {
        return basePrice + CONVENIENCE_FEE;
    }

    public double calculateBookingAmount(int count) {
        return calculateTicketPrice() * count;
    }
}

class RegularSeat extends Seat {
    public RegularSeat() {
        super(150.00);
    }
}

class PremiumSeat extends Seat {
    public PremiumSeat() {
        super(250.00);
    }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat() {
        super(400.00);
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();

            Seat seat = null;
            switch (seatType.toUpperCase()) {
                case "REGULAR":
                    seat = new RegularSeat();
                    break;
                case "PREMIUM":
                    seat = new PremiumSeat();
                    break;
                case "RECLINER":
                    seat = new ReclinerSeat();
                    break;
            }

            if (seat != null) {
                double amount = seat.calculateBookingAmount(count);
                total += amount;
                System.out.printf("%s: %.2f\n", seatType.toUpperCase(), amount);
            }
        }

        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}