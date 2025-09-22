package ca.bcit.comp2522.bank;

/**
 * Represents a person's name with first and last name.
 * Provides formatted name strings and initials.
 *
 * Author: Sukhraj Sandhar
 * Version: 1.0
 */
public class Name {

    private static final int MAX_LENGTH = 45;

    private final String first;
    private final String last;

    /**
     * Constructs a Name object with validation.
     *
     * @param first first name (not null, blank, >45 chars, or containing "admin")
     * @param last  last name (not null, blank, >45 chars, or containing "admin")
     * @throws IllegalArgumentException if any name is invalid
     */
    public Name(String first, String last) {
        if (first == null || first.isBlank()
                || first.length() > MAX_LENGTH
                || first.toLowerCase().contains("admin")) {
            throw new IllegalArgumentException("Invalid first name");
        }

        if (last == null || last.isBlank()
                || last.length() > MAX_LENGTH
                || last.toLowerCase().contains("admin")) {
            throw new IllegalArgumentException("Invalid last name");
        }

        this.first = capitalize(first);
        this.last = capitalize(last);
    }

    /**
     * Capitalizes the first letter and lowercases the rest.
     *
     * @param str input string
     * @return capitalized string
     */
    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    /**
     * Returns the first name.
     *
     * @return first name
     */
    public String getFirst() {
        return first;
    }

    /**
     * Returns the last name.
     *
     * @return last name
     */
    public String getLast() {
        return last;
    }

    /**
     * Returns the initials, e.g., "AE" for Albert Einstein.
     *
     * @return initials string
     */
    public String getInitials() {
        return first.charAt(0) + "" + last.charAt(0);
    }

    /**
     * Returns the full name in "First Last" format.
     *
     * @return full name string
     */
    public String getFullName() {
        return first + " " + last;
    }

    /**
     * Returns the name in "Last, First" format.
     *
     * @return reversed name string
     */
    public String getReverseName() {
        return last + ", " + first;
    }
}
