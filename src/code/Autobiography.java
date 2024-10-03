/**
 * The Autobiography class represents a specific type of biography where the 
 * subject of the biography is the same as the author. It extends the Biography 
 * class and provides a constructor that sets both the author and subject to 
 * the same person. This class also overrides the display method to indicate 
 * that the book is an autobiography.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Autobiography extends Biography {

    /**
     * Constructs a new Autobiography with the specified title, year published, and author.
     * Since this is an autobiography, the subject of the biography is the same as the author.
     *
     * @param title The title of the autobiography.
     * @param yearPublished The year the autobiography was published.
     * @param author The author (and subject) of the autobiography.
     */
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author) {
        super(title, yearPublished, author, author);  // Subject is the same as the author
    }

    /**
     * Displays information about the autobiography. This method first calls 
     * the display method of the Biography class and then prints a statement 
     * indicating that the book is an autobiography.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("This is an autobiography.");
    }
}
