/**
 * Represents a person.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Person implements Printable, Reversible,
        Comparable<Person> {
    private final Name name;
    private final Date birthDate;
    private final Date dateOfDeath;

    private static final int FIRST_CHARACTER = 0;
    private static final int STRING_CHAR_ADJUSTMENT = 1;
    private static final int CURRENT_YEAR = 2024;

    /**
     * Creates the object
     * @param name to represent the name of the person
     * @param birthDate represents the birthdate of the person
     * @param dateOfDeath represents the date the person died
     */
    public Person(final Name name,
                  final Date birthDate,
                  final Date dateOfDeath)
    {
        validateName(name);
        validateDate(birthDate);

        this.name = name;
        this.birthDate = birthDate;
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Overloaded constructor in case the person
     * is still alive then dateOfDeath can be null.
     * @param name represents the name of a person
     * @param birthDate represents the date the person was born
     */
    public Person(final Name name,
                  final Date birthDate)
    {
        this(name, birthDate, null);
    }

    /**
     * Prints the instance variables
     * (including the parent) in a sentence.
     */
    @Override
    public void display(){
        // Displays the name first
        name.display();
        // Added text to make the sentence
        System.out.print(" was born on");
        //Display the birthDate
        birthDate.display();


        // Verify if date of death is not null
        // If is not null it will print the date
        if(dateOfDeath != null)
        {
            System.out.print(" and died on");
            dateOfDeath.display();
        }

        //Adding a period to end sentence
        System.out.println(".");
    }

    /*
     * Validates the name is not null.
     * @param name represents the name to validate
     */
    private static void validateName(final Name name)
    {
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    /*
     * Validates if the date is not null.
     * @param date as the date to validate
     */
    private static void validateDate(final Date date)
    {
        if(date == null){
            throw new IllegalArgumentException("Date cannot be null");
        }
    }

    public int yearBorn(){
        return CURRENT_YEAR - birthDate.getYear();
    }

    /**
     * It will print a name or title backwards.
     */
    @Override
    public void backward() {
        final int fullNameLength;
        final String fullName;


        fullName = this.name.toString();
        fullNameLength = fullName.length();

        for(int i = fullNameLength - STRING_CHAR_ADJUSTMENT;
            i > FIRST_CHARACTER;
            i--)
        {
            System.out.print(fullName.charAt(i));
        }


    }

    /**
     * Compares using the age.
     * @param that the object to be compared.
     * @return +int then this > that
     *          -int then that > this
     *          0 then that equals this
     */
    @Override
    public int compareTo(final Person that)
    {
        return this.yearBorn() - that.yearBorn();
    }
}
