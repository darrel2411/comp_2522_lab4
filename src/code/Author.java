/**
 * Extends from Person class, and represents a person.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Author  extends Person implements Printable {
    private final String genre;

    private static final int STRING_LENGTH = 30;

    /**
     * Creates the objects
     * @param name representing the name of the author
     * @param dateOfBirth represents the date of birth
     * @param dateDied represents the date the person died
     * @param genre represents the genre and string cannot be null
     *              and must have less than STRING_LENGTH
     */
    public Author(final Name name,
                  final Date dateOfBirth,
                  final Date dateDied,
                  final String genre)
    {
        super(name, dateOfBirth, dateDied);

        validateGenre(genre);

        this.genre = genre;
    }

    /**
     * Overloaded method that allows to create
     * a person with a null dateOfDeath
     * @param name
     * @param dateOfBirth
     * @param genre
     */
    public Author(final Name name,
                  final Date dateOfBirth,
                  final String genre)
    {
        this(name, dateOfBirth, null, genre);
    }

    /*
     * Validates if the genre is not null
     * and has less than STRING_LENGTH characters.
     * @param genre as a string
     */
    private static void validateGenre(final String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null " +
                    "or empty");
        }

        final int length;
        length = genre.length();

        if (length > STRING_LENGTH) {
            throw new IllegalArgumentException("Genre must be less than " +
                    STRING_LENGTH + " characters");
        }
    }


    /**
     * Displays the author information.
     */
    @Override
    public void display(){
        super.display();

        System.out.println("Genre is " + genre + ".");
    }

}
