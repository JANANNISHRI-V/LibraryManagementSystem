import java.util.HashMap;

public class Author {
    private String authorName;
    private String bio;
    private int birthYear;

    private static HashMap<String, Author> authorDatabase = new HashMap<>();

    public Author(String authorName, String bio, int birthYear) {
        this.authorName = authorName;
        this.bio = bio;
        this.birthYear = birthYear;
        authorDatabase.put(authorName, this);
    }

    public static void viewAuthorDetails() {
        if (authorDatabase.isEmpty()) {
            System.out.println("No author details available.");
        } else {
            System.out.println("Author Details:");
            for (Author author : authorDatabase.values()) {
                System.out.println("Name: " + author.authorName);
                System.out.println("Bio: " + author.bio);
                System.out.println("Birth Year: " + author.birthYear);
                System.out.println();
            }
        }
    }

    // Example authors can be added to the database
    static {
        new Author("J.K. Rowling", "British author, best known for the Harry Potter series.", 1965);
        new Author("Stan Lee", "American comic book writer, known for creating Marvel superheroes.", 1922);
        new Author("C.S. Lewis", "British writer, known for The Chronicles of Narnia series.", 1898);
    }
}
