package doctor;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;
    private double feesCollected;

    public Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void collectFee() {
        feesCollected += consultationFee;
    }

    public double getFeesCollected() {
        return feesCollected;
    }

    public void displayDetails() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.printf("Consultation Fee: %.2f%n", consultationFee);
        System.out.printf("Fees Collected: %.2f%n", feesCollected);
    }
}