/**
 * The Biography class represents a book that details the life of a particular person, known as the subject.
 * It extends the Book class, adding a field for the subject of the biography. This class ensures that the
 * subject is valid and overrides the equals, hashCode, and display methods.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Biography extends Book {
    private final Person subject;

    /**
     * Constructs a new Biography with the specified title, year published, author, and subject.
     *
     * @param title The title of the biography.
     * @param yearPublished The year the biography was published.
     * @param author The author of the biography.
     * @param subject The person who is the subject of the biography.
     * @throws IllegalArgumentException if the subject is null.
     */
    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject) {
        super(title, yearPublished, author);
        validateSubject(subject);
        this.subject = subject;
    }

    /**
     * Validates that the subject is not null.
     *
     * @param subject The person who is the subject of the biography.
     * @throws IllegalArgumentException if the subject is null.
     */
    private static void validateSubject(final Person subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
    }

    /**
     * Checks if this biography is equal to another object. Two biographies are considered equal if they are
     * instances of the Biography class and have the same subject.
     *
     * @param o The object to compare for equality.
     * @return true if the object is a Biography with the same subject, false otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Biography)) {
            return false;
        }

        if(o.getClass().equals(this.getClass())) {
            Biography other = (Biography) o;
            return other.subject.equals(this.subject);
        }
        return false;
    }

    /**
     * Returns a hash code value for the biography. The hash code is based on the subject of the biography.
     *
     * @return The hash code for this biography.
     */
    @Override
    public int hashCode() {
        return subject.hashCode();
    }

    /**
     * Displays information about the biography, including details from the Book class and the subject.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Subject: ");
        subject.display();
    }
}
