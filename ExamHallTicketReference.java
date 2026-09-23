import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicketReference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int initialSeat = sc.nextInt();
        int newSeat = sc.nextInt();

        HallTicket priya = new HallTicket(name, initialSeat);
        HallTicket copy = priya;

        copy.seatNumber = newSeat;

        System.out.println(priya.studentName + "'s seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket(name, newSeat);
        System.out.println("separate == priya: " + (separate == priya));

        sc.close();
    }
}