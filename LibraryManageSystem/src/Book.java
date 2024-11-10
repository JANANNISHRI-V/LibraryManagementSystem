import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailableBook;

    // Predefined collections
    static ArrayList<Book> harryPotterCollection = new ArrayList<>();
    static ArrayList<Book> marvelCollection = new ArrayList<>();
    static ArrayList<Book> chroniclesOfNarnia = new ArrayList<>();

    // Static block to initialize collections
    static {
        harryPotterCollection.add(new Book("H001", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        harryPotterCollection.add(new Book("H002", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        harryPotterCollection.add(new Book("H003", "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999));
        harryPotterCollection.add(new Book("H004", "Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000));
        harryPotterCollection.add(new Book("H005", "Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003));
        harryPotterCollection.add(new Book("H006", "Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005));
        harryPotterCollection.add(new Book("H007", "Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007));


        marvelCollection.add(new Book("M001", "The Amazing Spider-Man: The Original Years", "Stan Lee", 1963));
        marvelCollection.add(new Book("M002", "Iron Man: The Armored Avenger", "Stan Lee", 1968));
        marvelCollection.add(new Book("M003", "The Mighty Thor", "Stan Lee", 1966));
        marvelCollection.add(new Book("M004", "Civil War", "Mark Millar", 2007));
        marvelCollection.add(new Book("M005", "Planet Hulk", "Greg Pak", 2007));
        marvelCollection.add(new Book("M006", "The Infinity War", "Jim Starlin", 1992));

        chroniclesOfNarnia.add(new Book("C001", "The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));
        chroniclesOfNarnia.add(new Book("C002", "Prince Caspian", "C.S. Lewis", 1951));
        chroniclesOfNarnia.add(new Book("C003", "The Voyage of the Dawn Treader", "C.S. Lewis", 1952));
        chroniclesOfNarnia.add(new Book("C004", "The Silver Chair", "C.S. Lewis", 1953));
        chroniclesOfNarnia.add(new Book("C005", "The Magician’s Nephew", "C.S. Lewis", 1955));
        chroniclesOfNarnia.add(new Book("C006", "The Last Battle", "C.S. Lewis", 1956));

        
    }

    public Book(String bookID, String title, String author, int publicationYear) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailableBook = true;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailableBook() {
        return isAvailableBook;
    }

    public void setAvailableBook(boolean isAvailable) {
        this.isAvailableBook = isAvailable;
    }

 
    public static void displayBooks(ArrayList<Book> collection) {
        for (Book book : collection) {
            System.out.println("Book ID: " + book.getBookID());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publication Year: " + book.getPublicationYear());
            System.out.println("Is Available: " + (book.isAvailableBook() ? "Yes" : "No"));
            System.out.println();
        }
    }

    public static void viewAllCollections() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose a collection to view:");
        System.out.println("1. Harry Potter Collection");
        System.out.println("2. Marvel Collection");
        System.out.println("3. The Chronicles of Narnia Collection");
        int choice = scan.nextInt();

        ArrayList<Book> selectedCollection = null;
        String collectionName = "";

        switch (choice) {
            case 1:
                collectionName = "Harry Potter Collection";
                selectedCollection = harryPotterCollection;
                break;
            case 2:
                collectionName = "Marvel Collection";
                selectedCollection = marvelCollection;
                break;
            case 3:
                collectionName = "The Chronicles of Narnia Collection";
                selectedCollection = chroniclesOfNarnia;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\n" + collectionName + " :");
        displayBooks(selectedCollection);
    }


    public static void borrowBook(Scanner scanner) {
        System.out.println("Enter the Book ID to borrow:");
        String bookID = scanner.next();

        Book selectedBook = null;
        for (Book book : harryPotterCollection) {
            if (book.getBookID().equals(bookID)) {
                selectedBook = book;
                break;
            }
        }
        if (selectedBook == null) {
            for (Book book : marvelCollection) {
                if (book.getBookID().equals(bookID)) {
                    selectedBook = book;
                    break;
                }
            }
        }
        if (selectedBook == null) {
            for (Book book : chroniclesOfNarnia) {
                if (book.getBookID().equals(bookID)) {
                    selectedBook = book;
                    break;
                }
            }
        }

        if (selectedBook != null) {
            if (selectedBook.isAvailableBook()) {
                selectedBook.setAvailableBook(false);
                System.out.println("You have successfully borrowed the book: " + selectedBook.getTitle());
            } else {
                System.out.println("Sorry, this book is currently unavailable.");
            }
        } else {
            System.out.println("Invalid Book ID.");
        }
    }
}
