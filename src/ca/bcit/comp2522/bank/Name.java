package ca.bcit.comp2522.bank;

/**
 * Represents a Person's Name with first and last names.
 * Provides methods to get the first/last name, initials.
 * properly capitalized full, and reversed name.
 *
 * @author Sukhraj Sandhar
 * @version 1.0
 */

public class Name {

    private final String firstName;
    private final String lastName;

    /**
     * Constructs a Name object with first and last names.
     * Performs validation: names cannot be null, blank, longer than 45 characters,
     * or contain the word "admin" (case-insensitive)
     *
     * @param firstName the first name of the person
     * @param lastName the last name of the person
     * @throws IllegalArgumentException if validation fails
     */
    public Name(String firstName, String lastName) {
        // check null
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Names cannot be null");
        }

        // trim spaces
        firstName = firstName.trim();
        lastName = lastName.trim();

        // check blank
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");

        }

        // check length (max 45)
        if (firstName.length() > 45 || lastName.length() > 45) {
            throw new IllegalArgumentException("Names too long");
        }

        // check "admin" anywhere (case-insensitive)
        if (firstName.toLowerCase().contains("admin") || lastName.toLowerCase().contains("admin")) {
            throw new IllegalArgumentException("Names cannot contain 'admin'");
        }

        // finally save
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the initials of the person in the format "F.L." (uppercase letters with dots).
     * Example: "Tiger Woods" -> "T.W."
     * @return initials string
     */
    public String getInitials() {
        String initials = Character.toUpperCase(firstName.charAt(0)) + "."
                        + Character.toUpperCase(lastName.charAt(0)) + ".";
        return initials;
    }

    /**
     * Returns the full name with proper capitalization.
     * First letter of each name is uppercase, the rest are lowercase.
     * Example: "tigER wooDS" -> "Tiger Woods"
     * @return full name string
     */
    public String getFullName() {
        String fullName = String.valueOf(Character.toUpperCase(firstName.charAt(0)))
                        + firstName.substring(1).toLowerCase()
                        + " "
                        + String.valueOf(Character.toUpperCase(lastName.charAt(0)))
                        + lastName.substring(1).toLowerCase();
        return fullName;
    }

    /**
     * Returns the full name reversed character by character
     * Example: "tigER wooDS" -> "SDoow REgit"
     * @return reversed full name string
     */
    public String getReverseName() {
        String combined = firstName + " " + lastName;
        String reversed = new StringBuilder(combined).reverse().toString();
        return reversed;
    }
}