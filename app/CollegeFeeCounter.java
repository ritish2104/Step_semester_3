import java.util.Scanner;

interface Transportable {
    double TRANSPORT_FEE = 12000.0;
    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getTuitionFee();

    public double calculateTotalFee() {
        double total = getTuitionFee();
        if (this instanceof Transportable) {
            total += ((Transportable) this).getTransportFee();
        }
        return total;
    }
}

class DayScholar extends Student implements Transportable {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements Transportable {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            Student student = null;
            switch (type.toUpperCase()) {
                case "DAY_SCHOLAR":
                case "DAY":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                case "SCHOLARSHIP":
                    student = new ScholarshipStudent(name);
                    break;
            }

            if (student != null) {
                double fee = student.calculateTotalFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f\n", student.getName(), fee);
            }
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}