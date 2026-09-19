package patient;

import doctor.Doctor;

public class Patient {
    private int patientId;
    private String name;
    private String disease;
    private int age;
    private Doctor assignedDoctor;

    public Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void assignDoctor(Doctor doctor) {
        assignedDoctor = doctor;
        doctor.collectFee();
    }

    public void displayDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("Age: " + age);
        if (assignedDoctor == null) {
            System.out.println("Assigned Doctor: No matching doctor found");
        } else {
            System.out.println("Assigned Doctor: " + assignedDoctor.getName()
                    + " (" + assignedDoctor.getSpecialization() + ")");
        }
    }
}