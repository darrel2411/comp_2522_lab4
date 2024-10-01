/**
 * Represents a name.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Name implements Printable{
    private final String firstName;
    private final String lastName;

    private final static int STRING_LENGTH = 50;

    /**
     * Creates the name.
     * @param firstName as String with length
     *                  of STRING_LENGTH.
     * @param lastName as string with length
     *                 of STRING_LENGTH.
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateName(firstName);
        validateName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
     * Validates if the string is null
     * or less than STRING_LENGTH.
     * @param name
     */
    private static void validateName(final String name){
        // In case the name is null
        if(name == null)
        {
            // It will throw and illegal argument exception
            throw new IllegalArgumentException("Name cannot be null");
        }

        // To get the length of the word
        final int nameLength;
        nameLength = name.length();

        // Verify the length of the name
        if (nameLength > STRING_LENGTH)
        {
            throw new IllegalArgumentException("Name cannot have more " +
                    "than " + STRING_LENGTH + " characters");
        }

    }

    /**
     * It returns the name as a string.
     * @return full name
     */
    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    /**
     * Prints all the instance variables
     * (including those in a parent class).
     */
    @Override
    public void display() {
        System.out.print(firstName + " " + lastName);
    }
}
