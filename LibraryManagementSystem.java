import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static BookDAO bookDAO = new BookDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        System.out.println("Enter book year:");
        int year = scanner.nextInt();

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);

        bookDAO.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void viewAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        for (Book book : books) {
            System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")");
        }
    }

    private static void updateBook() {
        System.out.println("Enter book ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter new title:");
        String title = scanner.nextLine();
        System.out.println("Enter new author:");
        String author = scanner.nextLine();
        System.out.println("Enter new year:");
        int year = scanner.nextInt();

        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);

        bookDAO.updateBook(book);
        System.out.println("Book updated successfully.");
    }

    private static void deleteBook() {
        System.out.println("Enter book ID to delete:");
        int id = scanner.nextInt();

        bookDAO.deleteBook(id);
        System.out.println("Book deleted successfully.");
    }
}


