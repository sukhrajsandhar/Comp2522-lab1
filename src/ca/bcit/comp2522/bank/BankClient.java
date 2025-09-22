package ca.bcit.comp2522.bank;

/**
 * Represents a bank client with personal and account details.
 * Supports alive/deceased status and provides formatted client details.
 *
 * Author: Sukhraj Sandhar
 * Version: 1.0
 */
public class BankClient {

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;
    private final String clientId;
    private final Date signupDate;

    /**
     * Constructs a BankClient.
     *
     * @param name       the client's Name object
     * @param birthDate  the client's birth date
     * @param deathDate  the client's date of death (null if alive)
     * @param signupDate the date the client signed up
     * @param clientId   unique client ID (6 or 7 digits)
     * @throws IllegalArgumentException if clientId is null or not 6-7 digits
     */
    public BankClient(
            Name name,
            Date birthDate,
            Date deathDate,
            Date signupDate,
            String clientId
    ) {
        if (clientId == null || !clientId.matches("\\d{6,7}")) {
            throw new IllegalArgumentException("Client ID must be 6 or 7 digits.");
        }

        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.clientId = clientId;
    }

    /**
     * Returns the client's Name object.
     *
     * @return Name object
     */
    public Name getName() {
        return name;
    }

    /**
     * Checks whether the client is alive.
     *
     * @return true if alive, false if deceased
     */
    public boolean isAlive() {
        return deathDate == null;
    }

    /**
     * Returns formatted client details including full name, ID, birth date,
     * status, and signup date.
     *
     * @return formatted details string
     */
    public String getDetails() {
        String status = isAlive()
                ? "Alive"
                : "Deceased on " + deathDate.getFormattedDate();

        return name.getFullName()
                + " (Client #" + clientId + "), born " + birthDate.getFormattedDate()
                + ", " + status
                + ", signed up on " + signupDate.getFormattedDate();
    }
}
