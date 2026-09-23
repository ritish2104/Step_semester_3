import java.util.Scanner;

class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " " + copiesAvailable + " copies available");
    }
}

public class LibraryInventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        BookInventory[] books = new BookInventory[n];
        for (int i = 0; i < n; i++) {
            String title = sc.nextLine();
            String author = sc.nextLine();
            int copies = sc.nextInt();
            sc.nextLine();
            books[i] = new BookInventory(title, author, copies);
        }

        for (BookInventory book : books) {
            book.printEntry();
        }

        sc.close();
    }
}