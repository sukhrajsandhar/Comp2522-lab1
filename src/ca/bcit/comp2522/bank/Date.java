package ca.bcit.comp2522.bank;

public class Date {

    private static final int MIN_YEAR = 1800;
    private static final int CURRENT_YEAR = java.time.LocalDate.now().getYear();
    private static final int [] MONTH_CODES = {1,4,4,0,2,5,0,3,6,1,4,6};
    private static final String[] DAY_NAMES = {
            "saturday","sunday","monday","tuesday","wednesday","thursday","friday"
    };

    public final int year;
    public final int month;
    public final int day;

    public final static int MAX_YEAR = 2099;
    public final static int TWO_MIN_YEAR = 2000;
    public final static int EIGHT_MAX_YEAR = 1899;

    public final static int December = 12;
    public final static int November = 11;

    public final static int NON_LEAP = 31;
    public final static int THIRTY = 30;
    public final static int LEAP_1 = 29;
    public final static int LEAP_2 = 28;

    public final static int MAX_YEAR_NUMBER = 12;

    public final static int FOUR_HUNDRED = 400;






    public Date(final int year, final int month, final int day) {
        if(year < MIN_YEAR || year > CURRENT_YEAR) {
            throw new IllegalArgumentException("Invalid year");
        }
        if (month < 1 || month > December) {
            throw new IllegalArgumentException("Invalid month");
        }
        int maxDay = daysInMonth(month, year);
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Invalid Day");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    private static int daysInMonth(final int month, final int year) {
        return switch (month) {
            case 4, 6, 9, November -> THIRTY;
            case 2 -> isLeapYear(year) ? LEAP_1 : LEAP_2;
            default -> NON_LEAP;
        };
    }

    public static boolean isLeapYear(final int y) {
        return (y % 4 == 0) && (y % 100 != 0 || y % FOUR_HUNDRED == 0);
    }

    /**
     * Implements the 7-step algorithm described in the spec.
     * Returns lower-case day name such as "monday".
     */
    public String getDayOfTheWeek() {
        int start = 0;
        if (year >= TWO_MIN_YEAR && year <= MAX_YEAR) {
            start += 6;
        } else if (year >= MIN_YEAR && year <= EIGHT_MAX_YEAR) {
            start += 2;
        }
        //For Jan/Feb in leap years add 6 per:
        if ((month == 1 || month == 2) && isLeapYear(year)) {
            start += 6;
        }

        int yy = year % 100;
        int twelves = yy/MAX_YEAR_NUMBER;
        int remainder = yy % MAX_YEAR_NUMBER;
        int fours = remainder / 4;

        int total = start + twelves + remainder + fours + day + MONTH_CODES[month - 1];
        int weekdayIndex = total % 7; // 0 -> saturday
        return DAY_NAMES[weekdayIndex];
    }
}
