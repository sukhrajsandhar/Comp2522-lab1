package ca.bcit.comp2522.bank;

/**
 * Represents a calendar date with validation and day-of-week calculation.
 * Supports leap years and years from 1800 to 2025.
 *
 * Author: Sukhraj Sandhar, Jaiden Zhang
 * Version: 1.3
 */
public class Date {

    private final int year;
    private final int month;
    private final int day;

    // Year bounds
    private static final int MIN_YEAR = 1800;
    private static final int MAX_YEAR = 2025;

    // Month names
    private static final String JANUARY = "January";
    private static final String FEBRUARY = "February";
    private static final String MARCH = "March";
    private static final String APRIL = "April";
    private static final String MAY = "May";
    private static final String JUNE = "June";
    private static final String JULY = "July";
    private static final String AUGUST = "August";
    private static final String SEPTEMBER = "September";
    private static final String OCTOBER = "October";
    private static final String NOVEMBER = "November";
    private static final String DECEMBER = "December";

    // Century offsets for day-of-week calculation
    private static final int CENTURY_1800S = 2;
    private static final int CENTURY_1900S = 0;
    private static final int CENTURY_2000S = 6;

    // Leap year adjustment for Jan/Feb
    private static final int LEAP_YEAR_OFFSET = 6;

    // Month codes for day-of-week calculation
    private static final int JANUARY_CODE = 1;
    private static final int FEBRUARY_CODE = 4;
    private static final int MARCH_CODE = 4;
    private static final int APRIL_CODE = 0;
    private static final int MAY_CODE = 2;
    private static final int JUNE_CODE = 5;
    private static final int JULY_CODE = 0;
    private static final int AUGUST_CODE = 3;
    private static final int SEPTEMBER_CODE = 6;
    private static final int OCTOBER_CODE = 1;
    private static final int NOVEMBER_CODE = 4;
    private static final int DECEMBER_CODE = 6;

    /**
     * Constructs a Date object.
     *
     * @param year  the year (1800-2025)
     * @param month the month (1-12)
     * @param day   the day for the month/year
     * @throws IllegalArgumentException if year, month, or day is invalid
     */
    public Date(int year, int month, int day) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException(
                    "Year must be between " + MIN_YEAR + " and " + MAX_YEAR
            );
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if (day < 1 || day > daysInMonth(year, month)) {
            throw new IllegalArgumentException("Invalid day for given month/year.");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the year.
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month number.
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the day of the month.
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns date in ISO format YYYY-MM-DD.
     *
     * @return ISO formatted date
     */
    public String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Returns formatted date with month name, e.g., "March 14, 1879".
     *
     * @return formatted date string
     */
    public String getFormattedDate() {
        return getMonthName() + " " + day + ", " + year;
    }

    /**
     * Checks if a year is a leap year.
     *
     * @param y the year
     * @return true if leap year, false otherwise
     */
    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /**
     * Returns the number of days in a month for a given year.
     *
     * @param y year
     * @param m month
     * @return number of days
     */
    private int daysInMonth(int y, int m) {
        if (m == 2) return isLeapYear(y) ? 29 : 28;
        if (m == 4 || m == 6 || m == 9 || m == 11) return 30;
        return 31;
    }

    /**
     * Returns the month code for day-of-week calculation.
     *
     * @return month code
     */
    private int getMonthCode() {
        if (month == 1) return JANUARY_CODE;
        if (month == 2) return FEBRUARY_CODE;
        if (month == 3) return MARCH_CODE;
        if (month == 4) return APRIL_CODE;
        if (month == 5) return MAY_CODE;
        if (month == 6) return JUNE_CODE;
        if (month == 7) return JULY_CODE;
        if (month == 8) return AUGUST_CODE;
        if (month == 9) return SEPTEMBER_CODE;
        if (month == 10) return OCTOBER_CODE;
        if (month == 11) return NOVEMBER_CODE;
        return DECEMBER_CODE;
    }

    /**
     * Returns the month name without using arrays or switch.
     *
     * @return month name
     */
    private String getMonthName() {
        if (month == 1) return JANUARY;
        if (month == 2) return FEBRUARY;
        if (month == 3) return MARCH;
        if (month == 4) return APRIL;
        if (month == 5) return MAY;
        if (month == 6) return JUNE;
        if (month == 7) return JULY;
        if (month == 8) return AUGUST;
        if (month == 9) return SEPTEMBER;
        if (month == 10) return OCTOBER;
        if (month == 11) return NOVEMBER;
        return DECEMBER;
    }

    /**
     * Calculates the day of the week using Zeller's-like formula.
     *
     * @return day of week (0=Saturday, 1=Sunday, ..., 6=Friday)
     */
    public int getDayOfWeek() {
        int centuryOffset = year >= 2000 ? CENTURY_2000S
                : (year >= 1900 ? CENTURY_1900S : CENTURY_1800S);

        int yy = year % 100;
        int twelves = yy / 12;
        int remainder = yy % 12;
        int fours = remainder / 4;

        int sum = day + centuryOffset + twelves + remainder + fours + getMonthCode();

        if ((month == 1 || month == 2) && isLeapYear(year)) {
            sum += LEAP_YEAR_OFFSET;
        }

        return sum % 7;
    }
}
