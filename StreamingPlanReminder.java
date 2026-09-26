import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    public Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends Plan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Plan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Plan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Plan> subscribers = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next(), formatter);

            switch (planType) {
                case "BASIC":
                    subscribers.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    subscribers.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    subscribers.add(new PremiumPlan(name, startDate));
                    break;
            }
        }

        for (Plan subscriber : subscribers) {
            LocalDate renewalDate = subscriber.calculateRenewalDate();
            System.out.println(subscriber.getName() + ": " + renewalDate.format(formatter));
        }

        sc.close();
    }
}