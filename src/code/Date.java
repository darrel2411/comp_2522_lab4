//package ca.bcit.comp2522.bank;

/**
 * Represents a specific date.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Date implements Printable{
    private final int year;
    private final int month;
    private final int day;

    //Possible number of days in a month
    private static final int THIRTY_DAYS = 30;
    private static final int THIRTY_ONE_DAYS = 31;
    private static final int TWENTY_NINE_DAYS = 29;
    private static final int TWENTY_EIGHT_DAYS = 28;

    //Year Bounds
    private static final int START_BOUND_YEAR_CASE_ONE = 1800;
    private static final int END_BOUND_YEAR_CASE_ONE = 1900;
    private static final int START_BOUND_YEAR_CASE_TWO = 2000;

    // Months
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    // Days of the Week
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    //Leap Year Division
    private static final int LEAP_YEAR_CASE_ONE = 400;
    private static final int LEAP_YEAR_CASE_TWO = 4;
    private static final int LEAP_YEAR_CASE_THREE = 100;
    private static final int NO_REMAINDER = 0;

    //Month codes
    private static final int MONTH_CODE_ONE = 1;
    private static final int MONTH_CODE_TWO = 2;
    private static final int MONTH_CODE_THREE = 3;
    private static final int MONTH_CODE_FOUR = 4;
    private static final int MONTH_CODE_FIVE = 5;
    private static final int MONTH_CODE_SIX = 6;

    // Adjustments in special cases getDayOfWeek
    private static final int ADJUSTMENT_CASE_ONE = 2;
    private static final int ADJUSTMENT_CASE_TWO = 6;
    private static final int ADJUSTMENT_CASE_THREE = 6;
    private static final int CENTURY_DIVISOR = 100;
    private static final int FOURS_DIVISION = 4;

    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int DAYS_IN_WEEK = 7;
    private static final int MONTH_IN_YEAR = 12;
    private static final int CURRENT_YEAR = 2024;

    /**
     * Constructor of the class date
     * @param year represents the year as integer
     * @param month represents the month as integer
     * @param day represents the day as integer
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        isYearValid(year);
        isMonthValid(month);
        isDayValid(day, month, year);


        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Gets the day
     * @return day as an int
     */
    public int getDay(){
        return day;
    }

    /**
     * Gets the month
     * @return month as an integer
     */
    public int getMonth(){
        return month;
    }

    /**
     * Gets the year.
     * @return year as an integer
     */
    public int getYear(){
        return year;
    }

    /**
     * It will return the month as string and not as an integer
     * @return month as a string
     */
    public String monthToString()
    {
        switch (month)
        {
            case JANUARY:
                return "January";
            case FEBRUARY:
                return "February";
            case MARCH:
                return "March";
            case APRIL:
                return "April";
            case MAY:
                return "May";
            case JUNE:
                return "June";
            case JULY:
                return "July";
            case AUGUST:
                return "August";
            case SEPTEMBER:
                return "September";
            case OCTOBER:
                return "October";
            case NOVEMBER:
                return "November";
            case DECEMBER:
                return "December";
            default:
                throw new IllegalArgumentException("Invalid month");
        }

    }

    /**
     * The amount of days that a month has
     * @return amount as an integer
     */
    private static int daysInMonth(final int month,
                                   final int year)
    {
        switch(month){
            // Month that contains 31 days
            case JANUARY, MAY, MARCH,
                 JULY, AUGUST, OCTOBER, DECEMBER:
                return THIRTY_ONE_DAYS;

            case FEBRUARY:
                // when the year is leap year
                // then February has 29 days
                if (isLeapYear(year)){
                    return TWENTY_NINE_DAYS;
                }
                return TWENTY_EIGHT_DAYS;

            // Month that have 30 days
            case APRIL, JUNE,
                 SEPTEMBER, NOVEMBER:
                return THIRTY_DAYS;
            default:
                throw new IllegalArgumentException("Invalid month");
        }
    }

    /**
     * Input validation if is a leap year.
     * Solved Examples on Leap Year Calculator
     * Example 1:
     * Is 2024 a leap year and verify it using leap year calculator.
     * Solution:
     * Let us divide this year by 4 and check.
     * 2024 ÷ 4 = 506
     * 2024 is divisible by 4.
     * Therefore, 2024 is a leap year.
     * Example 2:
     * Is 2032 a leap year and verify it using leap year calculator.
     * Solution:
     * Let us divide this year by 4 and check.
     * 2032 ÷ 4 = 508
     * 2032 is divisible by 4.
     * Therefore, 2032 is a leap year.
     * Example 3:
     * Is 2032 a leap year and verify it using leap year calculator.
     * Solution:
     * Let us divide this year by 4 and check.
     * 2050 ÷ 4 = 1025/2
     * 2050 is not divisible by 4.
     * Therefore, 2050 is not a leap year.
     *
     * @param year as an int
     * @return result as a boolean
     */
    public static boolean isLeapYear(final int year) {
        final boolean result;

        final int c1;
        final int c2;
        final int c3;

        // First, get the remainder of the year divided by 400
        // e.g. 2024 % 400
        c1 = year % LEAP_YEAR_CASE_ONE;

        // Second, get the remainder of the year divided by 4
        // e.g. 2024 % 4
        c2 = year % LEAP_YEAR_CASE_TWO;

        // Third, get the remainder of the year divided by 100
        // e.g. 2024 % 100
        c3 = year % LEAP_YEAR_CASE_THREE;

        // if the remainder of the first  or the second step is zero
        // and the remainder of the third step is zero then is leap year
        result = c1 == NO_REMAINDER|| c2 == NO_REMAINDER &&
                !(c3 == NO_REMAINDER);

        return result;
    }

    /**
     * It will return the date.
     * @return date as a string.
     */
    public String getYyyyMmDd(){
        // to print the date in format e.g. 2024-9-15
        return year + "-" + month + "-" + day;
    }

    /**
     * To get the day of the week, do the following seven steps for dates in the 1900s:
     * e.g. October 31 1977:
     * step 1: calculate the number of twelves in 77:
     * 6
     * step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 =
     * 5
     * step 3: calculate the number of fours in step 2: 5/4 = 1.25, so
     * 1
     * step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 =
     * 43
     * step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 =
     * 44
     * step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)
     * step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday
     * Extra notes:
     * a) for January/February dates in leap years, add 6 at the start
     * b) for all dates in the 2000s, add 6 at the start
     * c) for all dates in the 1800s, add 2 at the start
     * Another example:
     * e.g. March 15 2021:
     * step 0: add 6 for dates in the 2000s: NUMBER IS 6
     * step 1: there is 1 twelve in 21; NUMBER IS 1
     * step 2: 21/12 = 1 remainder 9; NUMBER IS 9
     * step 3: there are 2 fours in 9: NUMBER IS 2
     * step 4: NUMBER IS 15
     * step 5: month code for march is 4: NUMBER IS 4
     * step 6: Add all numbers 6+1+9+2+15+4 = 37 NUMBER is 2: 37 mod 7 is 2
     * step 7: 37%7 = 2; 2 means monday
     *
     *
     * @return a string containing the day
     */
    public String getDayOfWeek(){

        // Variable declaration
        final int yearLastTwoDigits;
        final int twelves;
        final int remainderTwelve;
        final int fours;
        int total = NO_REMAINDER;
        final int remainderSeven;

        // get the last two numbers of the year e.g. 1977 it would get 77
        yearLastTwoDigits= (year % CENTURY_DIVISOR);

        // Special cases
        // When the year is 2000 or greater add 6
        if(year >= START_BOUND_YEAR_CASE_TWO){
            total += ADJUSTMENT_CASE_TWO;

            // When the year is one of 1800s add 2
        } else if ( year < END_BOUND_YEAR_CASE_ONE) {
            total += ADJUSTMENT_CASE_ONE;
        }

        // If the month is January or February
        // and is a leap year add 6
        if(month == JANUARY || month == FEBRUARY){
            if(isLeapYear(year)){
                total += ADJUSTMENT_CASE_THREE;
            }
        }

        // Step 1
        // It will get how many times 12 can fit in the last two digits
        // of the year e.g. year = 1977, lastTwoDigits = 77, is doing
        // the following operation 77 /12
        twelves = yearLastTwoDigits / MONTH_IN_YEAR;

        // Step 2
        // Calculate the remainder from step 1: 77 - (12*6) = 77 - 72 = 5
        remainderTwelve = yearLastTwoDigits % MONTH_IN_YEAR;

        // Step 3
        // Calculate how many 4s can fit in the result from step 2 5/4 = 1
        fours = remainderTwelve / FOURS_DIVISION;

        // Step 4
        // Add everything
        total += day + twelves + remainderTwelve + fours;

        // Step 5: Add the month code, which uses a
        // supporting method to provide the code
        total += monthCode(month);


        // Step 6
        // Get the remainder if you divide the result
        // from step 5 divided by 7
        remainderSeven = total % DAYS_IN_WEEK;

        // Step 7
        // The result from step 6 is the day only that the week
        // goes from starts on Saturday and ends Friday
        switch (remainderSeven){
            case SATURDAY:
                return "Saturday";
            case SUNDAY:
                return "Sunday";
            case MONDAY:
                return "Monday";
            case TUESDAY:
                return "Tuesday";
            case WEDNESDAY:
                return "Wednesday";
            case THURSDAY:
                return "Thursday";
            case FRIDAY:
                return "Friday";
            default:
                throw new IllegalArgumentException(
                        "Something went wrong! the value passed was " +
                                remainderSeven);
        }
    }

    /*
     * supporting function for the get day of the week
     * Process
     * step 5: add the month code (for jfmamjjasond: 144025036146);
     * jfmamjjasond is the initial of each month
     * @param month to represent the month as an integer
     */
    private int monthCode(final int month){
        // Returns the code of the month use
        // in the method getDayOfWeek
        switch(month){
            case JANUARY, OCTOBER:
                return MONTH_CODE_ONE;
            case FEBRUARY, MARCH, NOVEMBER:
                return MONTH_CODE_FOUR;
            case APRIL, JULY:
                return NO_REMAINDER;
            case MAY:
                return MONTH_CODE_TWO;
            case JUNE:
                return MONTH_CODE_FIVE;
            case AUGUST:
                return MONTH_CODE_THREE;
            case SEPTEMBER, DECEMBER:
                return MONTH_CODE_SIX;
            default:
                throw new IllegalArgumentException(
                        "Something went wrong! the value passed was " );
        }
    }

    /**
     * gives the date in a string format
     * @return date as string
     */
    public String dateToString(){
        return getDayOfWeek() + " " + monthToString() + ", " + getYear();
    }


    /*
     * Verify that the year is between 1800 and the current year
     */
    private static void isYearValid(final int year){
        // Verify if the year is greater than 1800 and equal or
        // lower to the current year
        if(year < START_BOUND_YEAR_CASE_ONE || year > CURRENT_YEAR){
            // illegal argument if it does violate the rule above
            throw new IllegalArgumentException(
                    "Invalid! Year must be between" + START_BOUND_YEAR_CASE_ONE +
                            "and " + CURRENT_YEAR);
        }
    }

    /*
     * Verify if the month entered is between January and December
     * @param month
     */
    private static void isMonthValid(final int month){
        // verify if the month is between January and DECEMBER
        if(month < JANUARY || month > DECEMBER){
            throw new IllegalArgumentException(
                    "Invalid! Month must be between" + JANUARY + "and" + DECEMBER);
        }
    }

    /*
     * Verifies if the day is valid between Sunday and
     *  the Current day
     */
    private static void isDayValid(final int day,
                                   final int month,
                                   final int year)
    {
        final int lastDayMonth = daysInMonth(month, year);

        // Verify if the day is between one and the last day
        // of the month (Depends on the month)
        if(day < FIRST_DAY_OF_MONTH || day > daysInMonth(month, year)){
            throw new IllegalArgumentException(
                    "Invalid! day must be between" + FIRST_DAY_OF_MONTH + " and " +
                            lastDayMonth);
        }
    }

    /**
     * Prints all the instance variables
     * (Including those in parent class) in a sentence.
     */
    @Override
    public void display() {
        final String date;
        date = getYyyyMmDd();

        System.out.print("Today is " + date);
    }
}

