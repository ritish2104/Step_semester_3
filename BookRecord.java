        import java.util.Scanner;

class Book {
    String title;
    double price;
}

public class BookRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();

        System.out.print("Enter book title: ");
        book.title = scanner.nextLine();

        System.out.print("Enter book price: ");
        book.price = scanner.nextDouble();

        System.out.println("Title: " + book.title + " | Price: Rs " + book.price);

        scanner.close();
    }
}