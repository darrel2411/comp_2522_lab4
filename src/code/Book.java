/**
 * The Book class represents a book with a title, year of publication,
 * and author. It implements the Comparable, Printable, and Reversible
 * interfaces, allowing books to be compared by publication year,
 * displayed, and reversed in terms of the title.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Book implements Comparable<Book>, Printable, Reversible {
    private final String title;
    private final int yearPublished;
    private final Author author;

    private static final int MAX_TITLE_LENGTH = 100;
    private static final int CURRENT_YEAR = 2024;
    private static final int FIRST_YEAR = 50;

    /**
     * Constructs a new Book with the specified title, year published, and author.
     *
     * @param title The title of the book.
     * @param yearPublished The year the book was published.
     * @param author The author of the book.
     * @throws IllegalArgumentException if the title is invalid,
     *  the year published is out of range, or the author is null.
     */
    public Book(final String title,
                final int yearPublished,
                final Author author)
    {
        validateTitle(title);
        validateYearPublished(yearPublished);
        validateAuthor(author);

        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    /*
     * Validates the book's title.
     *
     * @param title The title of the book.
     * @throws IllegalArgumentException if the title is null, blank, or exceeds the maximum length.
     */
    private static void validateTitle(final String title) {
        if (title == null || title.isBlank() || title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException("Invalid title.");
        }
    }

    /*
     * Validates the year the book was published.
     *
     * @param yearPublished The year the book was published.
     * @throws IllegalArgumentException if the year is outside the acceptable range.
     */
    private static void validateYearPublished(final int yearPublished) {
        if (yearPublished < FIRST_YEAR || yearPublished > CURRENT_YEAR) {
            throw new IllegalArgumentException("Invalid year.");
        }
    }

    /*
     * Validates the author of the book.
     *
     * @param author The author of the book.
     * @throws IllegalArgumentException if the author is null.
     */
    private static void validateAuthor(final Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null.");
        }
    }

    /**
     * Compares this book to another book by the year published.
     * Older books are considered "larger."
     *
     * @param o The other book to compare to.
     * @return A negative integer, zero, or a positive integer
     * as this book was published more recently,
     *         the same year, or earlier than the specified book.
     */
    @Override
    public int compareTo(final Book o) {
        return o.yearPublished - this.yearPublished;  // Older books are "larger"
    }

    /**
     * Displays the book's information, including title,
     * year published, and author.
     */
    @Override
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Year Published: " + yearPublished);
        System.out.print("Author: ");
        author.display();
    }

    /**
     * Reverses the book's title and prints the reversed title.
     */
    @Override
    public void backward() {
        final StringBuilder sb = new StringBuilder();
        sb.append(title);
        sb.reverse();

        System.out.println(sb.toString());
    }
}
