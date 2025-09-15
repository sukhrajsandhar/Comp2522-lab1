package ca.bcit.comp2522.bank;

    /**
   * Date class represents a calendar date with bounds validation and calculates the day of the week

   * Valid years are between 1800 and 2025. Leap years are possible
   * @author Jaden zhang
   * @version 1.0
     */
public class Date {
    private final int year;
    private final int month;
    private final int day;

    private static final int MIN_YEAR = 1800; // Minimum valid year
    private static final int MAX_YEAR = 2025; // Maximum valid year

    // Constants for each day of the week
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    // Month codes using in day of the week calculation
    private static final int[] MONTH_CODES = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};

    /**
    * Constructs a Date with the given year, month, and day.
    * Performs validation: Bounds must be a valid date on the calendar
    *
    * @param year the year
    * @param month the month
    * @param day the day
    * @throws IllegalArgumentException if the year, month, or day are out of range
     */
    public Date(int year, int month, int day) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Year must be between " + MIN_YEAR + " and " + MAX_YEAR);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Gets the year of this date
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
    * Gets the month of this date
    * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
    * Gets the day of this date
    * @return day
     */
    public int getDay() {
        return day;
    }

    /**
    * return this date in the format YYYY-MM-DD
    * @return  A string of the date in ISO format
     */
    public String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
    * Determines if the year is a leap year
    * @param y the year
    * @return true if the year is a leap year, false otherwise
     */
    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /**
    * Returns the number of days in a given month of a given year
    * @param y the year
    * @param m the month
    * @return the number of days in that month
     */
    private int daysInMonth(int y, int m) {
        if (m == 2) {
            return isLeapYear(y) ? 29 : 28;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        } else{
            return 31;
        }
    }

    /**
    * Calculates the day of the week for the given date
    * @return the day of the week as an integer (0-Saturday, 1-Sunday, 2-Monday, 3-Tuesday, 4-Wednesday, 5-Thursday, 6-Friday)
     */
    public int getDayOfWeek() {
        int century = 0;
        if (year >= 2000) century = 6;
        else if (year < 1900) century = 2;

        int yy = year % 100;
        int twelves = yy/12;
        int remainder = yy - twelves * 12;
        int fours = remainder / 4;
        int sum = day + century + twelves + remainder + fours + MONTH_CODES[month -1];

        if ((month == 1 || month == 2) && isLeapYear(year)) {
            sum += 6;
        }
        return sum % 7;
    }
}