import java.util.Scanner;

public class Main {
    private static final int JUNCTION_COUNT = 3;
    private static final int STATUS_DISPLAY_COUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            TrafficJunction[] junctions = new TrafficJunction[JUNCTION_COUNT];

            for (int index = 0; index < junctions.length; index++) {
                System.out.println("\nEnter details for junction " + (index + 1));
                System.out.print("Junction name: ");
                String junctionName = scanner.nextLine();
                System.out.print("Traffic status: ");
                String trafficStatus = scanner.nextLine();
                System.out.print("Monitoring delay (ms): ");
                long monitoringDelay = readPositiveDelay(scanner);
                scanner.nextLine();

                junctions[index] = new TrafficJunction(
                        junctionName, trafficStatus, monitoringDelay);
            }

            for (TrafficJunction junction : junctions) {
                junction.start();
            }

            for (TrafficJunction junction : junctions) {
                junction.join();
            }

            System.out.println("All traffic junctions have completed monitoring.");
        }
    }

    private static long readPositiveDelay(Scanner scanner) {
        long delay = scanner.nextLong();
        while (delay <= 0) {
            System.out.print("Enter a positive monitoring delay: ");
            delay = scanner.nextLong();
        }
        return delay;
    }

    private static class TrafficJunction extends Thread {
        private final String trafficStatus;
        private final long monitoringDelay;

        private TrafficJunction(String junctionName, String trafficStatus,
                                long monitoringDelay) {
            super(junctionName + " Thread");
            this.trafficStatus = trafficStatus;
            this.monitoringDelay = monitoringDelay;
        }

        @Override
        public void run() {
            for (int count = 1; count <= STATUS_DISPLAY_COUNT; count++) {
                try {
                    Thread.sleep(monitoringDelay);
                    System.out.println(getName() + " - Traffic status: "
                            + trafficStatus + " (display " + count + "/"
                            + STATUS_DISPLAY_COUNT + ")");
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    System.out.println(getName() + " monitoring was interrupted.");
                    return;
                }
            }
        }
    }
}