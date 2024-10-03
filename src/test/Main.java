/**
 * It is the Bookstore system simulation.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Main {

    /**
     * All the classes for the bookstore are tested here.
     * @param args represents the arguments entered the
     *             command line
     */
    public static void main(String[] args) {

        // Authors for the books
        final Author orwell;
        final Author harperLee;
        final Author janeAusten;
        final Author fitzgerald;
        final Author hermanMelville;

        final Author robertCaro;
        final Author walterIsaacson;
        final Author martinGilbert;
        final Author ronChernow;

        orwell = new Author(new Name("George", "Orwell"),
                        new Date(1903, 6, 25),
                        new Date(1950,1,21),
                        "Criticism");

        harperLee = new Author(new Name("Harper", "Lee"),
                new Date(1926, 4, 28),
                new Date(2016, 2, 19),
                "Fiction");

        janeAusten = new Author(new Name("Jane", "Austen"),
                new Date(1875, 12, 16),
                new Date(1817, 7, 18),
                "Romance");

        fitzgerald = new Author(new Name("F. Scott", "Fitzgerald"),
                new Date(1896, 9, 24),
                new Date(1940, 12, 21),
                "Fiction");

        hermanMelville = new Author(new Name("Herman", "Melville"),
                new Date(1819, 8, 1),
                new Date(1891, 9, 28),
                "Adventure, Fiction");


        // Author for the autobiography
        robertCaro = new Author(new Name("Robert", "Caro"),
                new Date(1935, 10, 30),
                null,
                "Biography, Non-fiction");

        walterIsaacson = new Author(new Name("Walter", "Isaacson"),
                new Date(1952, 5, 20),
                null,
                "Biography");

        martinGilbert = new Author(new Name("Martin", "Gilbert"),
                new Date(1936, 10, 25),
                new Date(2017, 2, 3),
                "Biography");

        ronChernow = new Author(new Name("Ron", "Chernow"),
                new Date(1949, 3, 3),
                null,
                "Biography");

        // Persons
        final Person steveJobs;
        final Person winstonChurchill;
        final Person alexanderHamilton;
        final Person albertEinstein;

        // Subjects for the biographies using the Person constructor
        steveJobs = new Person(new Name("Steve", "Jobs"),
                new Date(1955, 2, 24),
                new Date(2011, 10, 5));

        winstonChurchill = new Person(new Name("Winston", "Churchill"),
                new Date(1874, 11, 30),
                new Date(1965, 1, 24));

        alexanderHamilton = new Person(new Name("Alexander", "Hamilton"),
                new Date(1855, 1, 11),
                new Date(1804, 7, 12));

        albertEinstein = new Person(new Name("Albert", "Einstein"),
                new Date(1879, 3, 14),
                new Date(1955, 4, 18));

        // Authors for the biographies
        final Author anneFrank;
        final Author nelsonMandela;
        final Author mahatmaGandhi;
        final Author mayaAngelou;
        final Author malcolmXAndAlexHaley;

        anneFrank = new Author(new Name("Anne", "Frank"),
                new Date(1929, 6, 12),
                new Date(1945, 3, 12),
                "Diary, Biography");

        nelsonMandela = new Author(new Name("Nelson", "Mandela"),
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                "Biography, Politics");

        mahatmaGandhi = new Author(new Name("Mahatma", "Gandhi"),
                new Date(1869, 10, 2),
                new Date(1948, 1, 30),
                "Biography, Politics");

        mayaAngelou = new Author(new Name("Maya", "Angelou"),
                new Date(1928, 4, 4),
                new Date(2014, 5, 28),
                "Biography, Poetry");

        malcolmXAndAlexHaley = new Author(new Name("Malcolm X and Alex", "Haley"),
                new Date(1925, 5, 19),
                new Date(1965, 2, 21),
                "Biography");



        // five books
        final Book b1;
        final Book toKillAMockingbird;
        final Book prideAndPrejudice;
        final Book theGreatGatsby;
        final Book mobyDick;



        // Book 1
        b1 = new Book("1984", 1949, orwell);

        toKillAMockingbird = new Book("To Kill a Mockingbird",
                                      1960, harperLee);

        prideAndPrejudice = new Book("Pride and Prejudice",
                                     1813, janeAusten);

        theGreatGatsby = new Book("The Great Gatsby",
                                  1925, fitzgerald);

        mobyDick = new Book("Moby-Dick",
                            1851, hermanMelville);


        // Biography
        final Biography steveJobsBiography;
        final Biography churchillALifeBiography;
        final Biography alexanderHamiltonBiography;
        final Biography einsteinHisLifeAndUniverseBiography;

        // Creating biographies with title, year published, author, and subject
        steveJobsBiography = new Biography("Steve Jobs", 2011,
                                            walterIsaacson, steveJobs);

        churchillALifeBiography = new Biography("Churchill: A Life",
                                               1991, martinGilbert,
                                                winstonChurchill);

        alexanderHamiltonBiography = new Biography("Alexander Hamilton",
                                                   2004, ronChernow,
                                                    alexanderHamilton);

        einsteinHisLifeAndUniverseBiography = new Biography("Einstein: His Life " +
                                                             "and Universe",
                                                            2007,
                                                             walterIsaacson,
                                                             albertEinstein);

        //Autobiography
        final Biography diaryOfAYoungGirl;
        final Biography longWalkToFreedom;
        final Biography storyOfMyExperimentsWithTruth;
        final Biography iKnowWhyTheCagedBirdSings;
        final Biography autobiographyOfMalcolmX;

        diaryOfAYoungGirl = new Biography("The Diary of a Young Girl",
                                          1947, anneFrank, anneFrank);


        longWalkToFreedom = new Biography("Long Walk to Freedom",
                                          1994, nelsonMandela, nelsonMandela);

        storyOfMyExperimentsWithTruth = new Biography("The Story of My Experiments " +
                "                                       with Truth", 1927,
                                                        mahatmaGandhi, mahatmaGandhi);


        iKnowWhyTheCagedBirdSings = new Biography("I Know Why the Caged Bird Sings",
                                                  1969, mayaAngelou, mayaAngelou);

        autobiographyOfMalcolmX = new Biography("Autobiography of Malcolm X",
                                                1965, malcolmXAndAlexHaley,
                                                 malcolmXAndAlexHaley);

        // 5. Perform Comparisons (example of comparing publication years)
        System.out.println("Comparing Books by Publication Year:");
        System.out.println(b1.compareTo(toKillAMockingbird));

        System.out.println();
        System.out.println(theGreatGatsby.compareTo(mobyDick));

        System.out.println();

        System.out.println("Comparing Authors by Birthdate:");
        System.out.println(orwell.compareTo(walterIsaacson));

        System.out.println();

        System.out.println("Comparing Biographies by Subjects:");
        System.out.println(steveJobsBiography.compareTo(churchillALifeBiography));

        System.out.println();

        // 6. Printing Details Using Printable Interface
        System.out.println("Book Details:");
        b1.display();

        System.out.println();
        toKillAMockingbird.display();
        System.out.println();
        prideAndPrejudice.display();
        System.out.println();
        theGreatGatsby.display();
        System.out.println();
        mobyDick.display();

        System.out.println();

        // 7. Reversible Interface to Print Titles/Authors Backwards
        System.out.println("Book Titles Backwards:");
        b1.backward();
        toKillAMockingbird.backward();
        prideAndPrejudice.backward();

        System.out.println();

        System.out.println("Author Names Backwards:");
        orwell.backward();
        anneFrank.backward();
        nelsonMandela.backward();




    }
}
