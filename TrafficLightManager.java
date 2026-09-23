import java.util.Scanner;

class TrafficLightController {
    private final String lightId;
    private String currentColor;

    public TrafficLightController(String lightId) {
        this.lightId = lightId;
        this.currentColor = "RED";
    }

    public void next() {
        if ("RED".equals(currentColor)) {
            currentColor = "GREEN";
        } else if ("GREEN".equals(currentColor)) {
            currentColor = "YELLOW";
        } else if ("YELLOW".equals(currentColor)) {
            currentColor = "RED";
        }
    }

    public String getColor() {
        return currentColor;
    }

    public String getLightId() {
        return lightId;
    }
}

public class TrafficLightManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int steps = sc.nextInt();

        TrafficLightController t = new TrafficLightController(id);
        System.out.println("Initial color: " + t.getColor());

        for (int i = 0; i < steps; i++) {
            t.next();
            System.out.println("After step " + (i + 1) + ": " + t.getColor());
        }

        sc.close();
    }
}